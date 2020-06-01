package com.ZLYUtils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取或创建Excle
 */
public class ExcelUtils {


    public static void main(String[] args) throws Exception {
        Map<Integer, Map<String, String>> dataMap = new LinkedHashMap<>();
        Map<String, String> m = new LinkedHashMap<>();
        m.put("测试1", "zhi1");
        m.put("测试2", "zhi2");
        m.put("测试3", "zhi3");
        m.put("测试4", "zhi4");
        m.put("测试5", "zhi5");
        m.put("测试6", "zhi6");
        dataMap.put(0, m);
        dataMap.put(1, m);
        if (createExcelFile(new File("x.xlsx"), "测试", dataMap)) {
            System.out.println("data.xlsx is created successfully.");
        }
        Map<Integer, Map<String, String>> S;
        S = getExcelXlsx(new File("x.xlsx"));
        Map<String, String> map;
        for (int i = 0; i < S.size(); i++) {
            map = S.get(i);
            for (Map.Entry<String, String> values : map.entrySet()) {
                System.out.println("Key:" + values.getKey() + " 值:" + values.getValue());
            }
        }


    }


    /**
     * 创建并写入xlsx文件
     *
     * @param excelPath 文件保存路径
     * @param sheetName sheet名称
     * @param dataMap   数据源
     * @return 创建成功或失败
     */
    public synchronized static boolean createExcelFile(File excelPath,
                                                       String sheetName, Map<Integer,
            Map<String, String>> dataMap) throws IOException {
        if (!excelPath.getName().endsWith(".xlsx")) {
            excelPath = new File(excelPath + ".xlsx");
        }
        //HSSFWorkbook();//WorkbookFactory.create(inputStream)
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream outputStream = new FileOutputStream(excelPath)) {
            // XSSFWork used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
            Sheet sheet = workbook.createSheet(sheetName);
            List<String> titleList = new ArrayList<>();
            //读取出所有map的title
            for (Map.Entry<Integer, Map<String, String>> mapEntry : dataMap.entrySet()) {
                for (Map.Entry<String, String> m : mapEntry.getValue().entrySet()) {
                    if (!titleList.contains(m.getKey())) titleList.add(m.getKey());
                }
            }
            Cell cell;
            Row row0 = sheet.createRow(0);
            //写入标题
            for (int i = 0; i < titleList.size(); i++) {
                cell = row0.createCell(i, CellType.STRING);
                cell.setCellStyle(getCellStyle(workbook));
                cell.setCellValue(titleList.get(i));
                sheet.autoSizeColumn(i);
            }
            int index = 1;
            String value;
            Row row;
            for (Map.Entry<Integer, Map<String, String>> integerMapEntry : dataMap.entrySet()) {
                //插入数据
                row = sheet.createRow(index);
                for (int i = 0; i < titleList.size(); i++) {
                    value = integerMapEntry.getValue().get(titleList.get(i));
                    value = value == null ? "" : value;
                    try {
                        cell = row.createCell(i, CellType.NUMERIC);
                        cell.setCellValue(Double.parseDouble(value));
                    } catch (Exception e) {
                        cell = row.createCell(i, CellType.STRING);
                        cell.setCellValue(value);
                    }
                }
                index++;
            }
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            throw new IOException(e);
        }

        return true;
    }

    private static CellStyle getCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置单元格字体
        Font headerFont = workbook.createFont(); // 字体
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(Font.COLOR_RED);
        headerFont.setFontName("宋体");
        style.setFont(headerFont);
        style.setWrapText(true);
        // 设置单元格边框及颜色
        style.setBorderBottom(BorderStyle.valueOf((short) 1));
        style.setBorderLeft(BorderStyle.valueOf((short) 1));
        style.setBorderRight(BorderStyle.valueOf((short) 1));
        style.setBorderTop(BorderStyle.valueOf((short) 1));
        style.setWrapText(true);
        return style;
    }


    /**
     * 获取xlsx文件
     *
     * @param file
     */
    public synchronized static Map<Integer, Map<String, String>> getExcelXlsx(File file) {
        if (!file.exists()) throw new RuntimeException("文件不存在:" + file.getPath());
        Map<Integer, Map<String, String>> rowMap = new LinkedHashMap<>();//所有行的总值
        Map<String, String> valuesMap;//每一行的总值
        try (InputStream is = new FileInputStream(file)) {
            Workbook xssfWorkbook;
            xssfWorkbook = new XSSFWorkbook(is);
            // 获取每一个工作薄
            // for (int numSheet = 0; numSheet <
            // xssfWorkbook.getNumberOfSheets(); numSheet++) {
            // XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            // if (xssfSheet == null) {
            // continue;
            // }
            //指定第一个工作表
            Sheet xssfSheet;
            xssfSheet = xssfWorkbook.getSheetAt(0);
            int Column = xssfSheet.getRow(0).getPhysicalNumberOfCells();// 获取所有的列
            int row = xssfSheet.getLastRowNum(); // 获取所有的行
            for (int rowIndex = 1; rowIndex <= row; rowIndex++) {
                valuesMap = new LinkedHashMap<>();
                for (int columnIndex = 0; columnIndex < Column; columnIndex++) {
                    valuesMap.put(getSpecifyRowsAndColumns(0, columnIndex, xssfSheet),
                            getSpecifyRowsAndColumns(rowIndex, columnIndex, xssfSheet));
                }
                rowMap.put(rowIndex - 1, valuesMap);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rowMap;
    }

    /**
     * 获取指定行和列的内容
     *
     * @param row
     * @param colum
     * @return
     */
    private static String getSpecifyRowsAndColumns(int row, int colum, Sheet sheet) {
        Row xssfRow = sheet.getRow(row);
        Cell xssfCell = xssfRow.getCell(colum);
        xssfCell.setCellType(CellType.STRING);
        return xssfCell.toString() != null ? xssfCell.toString() : "";
    }


}

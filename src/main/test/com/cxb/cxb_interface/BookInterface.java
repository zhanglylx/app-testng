package com.cxb.cxb_interface;



import com.cxb.cxb_object.Chapter;

import java.util.List;

public interface BookInterface {
    /**
     * 获取指定章节后的id有多少章
     *
     * @param chapterId
     * @return
     */
    public int getAssignChapterIdAfterNumber(long chapterId);


    /**
     * 获取第一章id，因为数据库中可能存在多个第一章
     * @return
     */
    public List<Long> getFirstChapterId();


    /**
     * 判断传入的第一章是否为书籍的第一章
     * @param chapterId
     * @return
     */
    public boolean firstChapterIdExist(long chapterId);
    /**
     * 获取最后一章id
     *
     * @return
     */
    public long getFinallyChapterId();

    /**
     * 获取一个随机章节
     *
     * @return
     */
    public long getRandomChapterId();


    /**
     * 获取指定的章节
     * @param chapterId
     * @return
     */
    public Chapter getSpecifyChapter(long chapterId);

    /**
     * 获取指定的章节下一章
     * @param chapterId
     * @return
     */
    public Chapter getSpecifyChapterNext(long chapterId);

    /**
     * 获取指定章节的上一章
     * @param chapterId
     * @return
     */
    public Chapter getSpecifyChapterPre(long chapterId);
}

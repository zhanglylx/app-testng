package com.cxb.cxb_object;

public class Chapter {
    private long id;
    private String name;
    private long wordCount;
    private String bookId;
    private int chapterIndex;
    private String content;
    private int contentStatus;
    private String flag;
    private int s3exist;
    private int version;
    private int isVip;
    private String cdnUrl;

    public Chapter() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWordCount() {
        return wordCount;
    }

    public void setWordCount(long wordCount) {
        this.wordCount = wordCount;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsVip() {
        return isVip;
    }

    public void setIsVip(int isVip) {
        this.isVip = isVip;
    }




    public int getContentStatus() {
        return contentStatus;
    }

    public void setContentStatus(int contentStatus) {
        this.contentStatus = contentStatus;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getS3exist() {
        return s3exist;
    }

    public void setS3exist(int s3exist) {
        this.s3exist = s3exist;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCdnUrl() {
        return cdnUrl;
    }

    public void setCdnUrl(String cdnUrl) {
        this.cdnUrl = cdnUrl;
    }

}

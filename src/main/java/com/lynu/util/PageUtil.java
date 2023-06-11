package com.lynu.util;

public class PageUtil {
    private static int pageSize=5;
    private static int pageIndex;
    private static int total;//总共有多少数据
    private static int pages;//总页数
    private static int pageNum;//当前页数
    private static int pageStart;//页面导航从哪开始
    private static int pageEnd;//页面导航到哪结束

    public static PageUtil createPage(int pnum,int count){
        return createPage(pnum, count,pageSize);
    }
    public static PageUtil createPage(int pnum,int count,int psize){
        PageUtil pageUtil = new PageUtil();
        pageUtil.pageNum = pnum;
        pageUtil.total = count;
        pageUtil.pageSize = psize;
        //起始下标
        pageUtil.pageIndex = (pnum-1)*psize;
        //总页数
        if (PageUtil.total%pageSize == 0){
            pageUtil.pages = count/pageSize;
        }else {
            pageUtil.pages = count/pageSize+1;
        }
        //根据总页数 计算导航
        if (pageUtil.pages < 5){
            pageUtil.pageStart = 1;
            pageUtil.pageEnd = pageUtil.pages;
        }else {
            if (pageUtil.pageNum-2 <= 0){
                pageUtil.pageStart = 1;
                pageUtil.pageEnd = 5;
            }else {
                //最少是第三页
                pageUtil.pageStart=pnum-2;
                //判断pnum+2的情况
                if(pageUtil.pageNum+2<=pageUtil.pages){
                    pageUtil.pageEnd=pnum+2;
                }else{
                    //pnum+2>总页数  强行结束区间=总页数
                    pageUtil.pageEnd=pageUtil.pages;
                    pageUtil.pageStart=pageUtil.pages-4;
                }
            }
        }
        return pageUtil;
    }

    //这个对象不能主动构建需要createPage调用
    private PageUtil(){}

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }
}

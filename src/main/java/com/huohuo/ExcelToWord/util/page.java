package com.huohuo.ExcelToWord.util;

public class page {
    //开始位置
    int start;
    //每页的数量
    int count;
    //总共多少数据
    int total;
    //
    String param;
    private static final int defaultCount = 5; //默认每页显示5条

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "page{" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total +
                ", param='" + param + '\'' +
                '}';
    }

    public page() {
        count=defaultCount;
    }

    public page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    //返回一共多少页
    public int getTotalPage(){
        int totalPage;
        if(0==total%count)
            totalPage=total/count;
        else
            totalPage=total/count+1;
        if(0==totalPage)
            totalPage=1;
        return totalPage;
    }
    //最后一页的第一个数
    public int getLast(){
        int last;
        if(0==total%count)
            last=total-count;
        else
            last=total-total/count;
        last=last<0?0:last;
        return last;
    }
    //是否有前一页
    public boolean isHasPreviouse(){
        if(start==0)
            return false;
        return true;
    }
    //是否有后一页
    public boolean isHasNext(){
        if(start==getLast())
            return false;
        return true;
    }


}

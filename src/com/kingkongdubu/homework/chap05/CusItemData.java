package com.kingkongdubu.homework.chap05;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13. 2. 4
 * Time: 오전 9:40
 * To change this template use File | Settings | File Templates.
 */
public class CusItemData {
    private  String titleText;
    private  String discriptionText;
    private  int imageResourceId;

    public  void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public  void setDiscriptionText(String discriptionText) {
        this.discriptionText = discriptionText;
    }

    public  void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }


    public  String getTitleText() {
        return titleText;
    }

    public  String getDiscriptionText() {
        return discriptionText;
    }

    public  int getImageResourceId() {
        return imageResourceId;
    }
}

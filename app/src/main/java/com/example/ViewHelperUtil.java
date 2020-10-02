package com.example;

import org.angmarch.views.NiceSpinner;

import java.util.LinkedList;
import java.util.List;

public class ViewHelperUtil {

    public  static  void show(List<String>dataList, NiceSpinner niceSpinner){
        dataList=new LinkedList<>();
        niceSpinner.attachDataSource(dataList);


    }
}

package com.huohuo.ExcelToWord.controller;


import com.huohuo.ExcelToWord.Service.ReaderExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class ReaderExcelController {
    @Autowired
    ReaderExcelService readerExcelService;
    @RequestMapping("ExcelList")
    public String ExcelList(){

    return "";
    }

}

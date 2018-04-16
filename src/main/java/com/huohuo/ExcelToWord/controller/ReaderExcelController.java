package com.huohuo.ExcelToWord.controller;


import com.huohuo.ExcelToWord.Service.ReaderExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;

@RequestMapping("")
@Controller
public class ReaderExcelController {
    @Autowired
    ReaderExcelService readerExcelService;
    @RequestMapping("ExcelList")
    public String ExcelList(Model model){

        LinkedList[] cs=readerExcelService.init();
        model.addAttribute("cs",cs);
    return "";
    }

}

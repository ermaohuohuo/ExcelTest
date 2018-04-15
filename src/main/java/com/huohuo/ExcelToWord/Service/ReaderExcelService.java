package com.huohuo.ExcelToWord.Service;

import org.apache.poi.ss.usermodel.Cell;

import java.util.LinkedList;

public interface ReaderExcelService {
    void loadExcel(String filePath);
    String getCellValue(Cell cell);
    LinkedList[] init();
    void show();

}

package com.huohuo.ExcelToWord.Service;

import org.apache.poi.ss.usermodel.Cell;

public interface readerExcelService {
    void loadExcel(String filePath);
    String getCellValue(Cell cell);
    void init();
    void show();

}

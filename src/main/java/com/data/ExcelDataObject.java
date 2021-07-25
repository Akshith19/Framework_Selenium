package com.data;

import com.base.BaseExcelDataObject;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

public class ExcelDataObject extends BaseExcelDataObject {
    @ExcelRow
    public int index;
    @ExcelCellName("Search")
    public String search;
}

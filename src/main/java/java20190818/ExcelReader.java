package java20190818;


import org.apache.bcel.generic.IF_ACMPEQ;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    private String filePath;
    private String sheetName;
    private Workbook workbook;
    private Sheet sheet;
    private List<String> columnHeaderList;
    private List<List<String>> listData;
    private List<Map<String,String>>mapData;
    private boolean flag;

    public ExcelReader(String filePath,String sheetName){
        this.filePath = filePath;
        this.sheetName = sheetName;
        this.flag = false;
        this.load();
    }

    private void load() {
        FileInputStream inStream= null;
        try {
            inStream = new FileInputStream(new File(filePath));
            workbook = WorkbookFactory.create(inStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCellVlue(Cell cell){
        String cellValue = "";
        DataFormatter formatter = new DataFormatter();
        if (cell != null) {
            switch (cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)){
                        cellValue = formatter.formatCellValue(cell);
                    }else {
                        double value = cell.getNumericCellValue();
                        int intValue = (int)value;
                        cellValue = value - intValue == 0? String.valueOf(intValue) : String.valueOf(value);
                    }
                    break;
                case Cell.CELL_TYPE_STRING:
//                    cellValue =
            }
        }
        return  null;
    }



















}

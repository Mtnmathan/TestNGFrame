package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderAndWriter {

    private String filePath;
    private Workbook workbook;
    private Sheet sheet;
    private Map<String, String> dataMap;
    
    public ExcelReaderAndWriter(String filePath) throws IOException {
        this.filePath = filePath;
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0); // Assuming first sheet for now
        fis.close();
        dataMap = new HashMap<>();
        loadData();
    }

    private void loadData() {
		
    	Row headerRow = sheet.getRow(0);
        Row dataRow = sheet.getRow(1);  // The second row contains the values

        for (Cell headerCell : headerRow) {
            int colIndex = headerCell.getColumnIndex();
            String header = headerCell.getStringCellValue();

            Cell dataCell = dataRow.getCell(colIndex);
            String value = "";

            // Check the cell type and handle accordingly
            if (dataCell.getCellType() == CellType.STRING) {
                value = dataCell.getStringCellValue();
            } else if (dataCell.getCellType() == CellType.NUMERIC) {
                value = String.valueOf((int) dataCell.getNumericCellValue()); // Convert numeric to String
            }

            dataMap.put(header, value);  // Map header to corresponding value
        }
	}

	public String getURL() {
		return dataMap.get("URL");  // Assuming URL is in row 1, column 1
    }

    public String getInputSearchTerm() {
    	return dataMap.get("SearchTerm");  // Assuming SearchTerm is in row 2, column 1
    }
    
    public String getIndex() {
    	return dataMap.get("Index");  // Assuming Index is in row 3, column 1
    }


    public void writeData(String key, String value) throws IOException {
        int lastRow = sheet.getLastRowNum() + 1;  // To append at the last row
        Row newRow = sheet.createRow(lastRow);
        newRow.createCell(0).setCellValue(key);   // Writing the key (e.g., "Price")
        newRow.createCell(1).setCellValue(value); // Writing the value (e.g., price)
        // Write back to the file
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
    }

    public void close() throws IOException {
        workbook.close();
    }
	

}

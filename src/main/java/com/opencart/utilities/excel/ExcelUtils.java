package com.opencart.utilities.excel;

import com.opencart.constants.Constant;
import com.opencart.utilities.logger.LogManagerUtils;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils implements AutoCloseable {

    private final Logger logger = LogManagerUtils.getLogger(ExcelUtils.class);
    private final InputStream excelFile;
    private final XSSFWorkbook workbook;
    private final XSSFSheet sheet;
    private static final DataFormatter formatter = new DataFormatter();

    public ExcelUtils(String fileName, String sheetName) {
        String excelFilePath = "testData/" + fileName + Constant.EXCEL_FILE_EXTENSION_XLSX;
        try {
            excelFile = ExcelUtils.class.getClassLoader().getResourceAsStream(excelFilePath);
            if (excelFile == null) {
                logger.debug("Invalid excel file: {}", excelFilePath);
                throw new RuntimeException("Invalid excel file: " + excelFilePath);
            }
            workbook = new XSSFWorkbook(excelFile);

            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                logger.debug("Invalid sheet name: {}", sheetName);
                throw new RuntimeException("Invalid sheet name: " + sheetName);
            }
        } catch (IOException e) {
            logger.debug("Error occurred while reading from excel file: ", e);
            throw new RuntimeException(e);
        }
    }

    public int getTotalRowCount() {
        return sheet.getLastRowNum();
    }

    public int getTotalColumnCount(int row) {
        return sheet.getRow(row).getLastCellNum();
    }

    public String getCellData(int rowNum, int columnNum) {
        XSSFCell cell = sheet.getRow(rowNum).getCell(columnNum);
        String formattedCellValue = formatter.formatCellValue(cell);
        if (cell == null || formattedCellValue.isBlank()) {
            logger.debug("Missing cell at row [{}] and column [{}]", (rowNum + 1), (columnNum + 1));
            return null;
        }

        return formattedCellValue;
    }

    public Object[][] getTable() {
        int totalRows = getTotalRowCount();
        int totalColumns = getTotalColumnCount(0);
        Object[][] table = new Object[totalRows][totalColumns];

        for (int i = 1; i <= totalRows; i++) {
            if (sheet.getRow(i) == null) {
                logger.debug("Missing data at row [{}]", (i + 1));
                continue;
            }
            for (int j = 0; j < totalColumns; j++) {
                table[i - 1][j] = getCellData(i, j);
            }
        }
        return table;
    }

    @Override
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            logger.warn("Failed to close excel workbook", e);
        }

        try {
            if (excelFile != null) {
                excelFile.close();
            }
        } catch (IOException e) {
            logger.warn("Failed to close input stream", e);
        }
    }
}
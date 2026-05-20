/*
 * Purpose:
 * - This class contains methods that return data in the form of 2D Object array
 * - Data can be returned from any external source (Excel file, Database, etc...)
 */

package com.opencart.dataprovider;

import com.opencart.utilities.excel.ExcelUtils;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "invalidLoginDataExcel")
    public Object[][] getInvalidLoginData() {
        try (ExcelUtils excelWorkbook = new ExcelUtils("LoginTestData", "Invalid-login-test-data")) {
            return excelWorkbook.getTable();
        }
    }
}
package excel;

import company.Company;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public ArrayList<Company> readFromExcel(File excelFile, int startRow, int endRow, int[] columns) throws IOException, InvalidFormatException {
        ArrayList<Company> listOfCompanies = new ArrayList<Company>();

        System.out.println("Retrieving excel data from " + excelFile.toString());
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook myExcelBook = new XSSFWorkbook(fis);
        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        // iterate all rows
        for (int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
            XSSFRow row = myExcelSheet.getRow(rowIndex);
            // iterate columns
            String clientName = row.getCell(columns[0]).getStringCellValue();
            String clientEmail= row.getCell(columns[1]).getStringCellValue();
            String cc_value = row.getCell(columns[2]).getStringCellValue(); 
            String emailSubject = row.getCell(columns[3]).getStringCellValue();
            String emailBody = row.getCell(columns[4]).getStringCellValue();
            Company co = new Company(clientName, clientEmail, cc_value, emailSubject, emailBody);
            listOfCompanies.add(co);
        }
        myExcelBook.close();
        return listOfCompanies;
    }
}

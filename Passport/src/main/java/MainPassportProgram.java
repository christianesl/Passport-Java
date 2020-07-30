import excel.ExcelReader;
import company.Company;
import attachment.Attachments;
import google.Email;

import java.io.File;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;


public class MainPassportProgram {

    public static void main(String args[]) throws Exception {
        /*******************************************************************
         * Data
         *******************************************************************/
        // account information
        String user = "christianesl";
        String password = "Mty10dark";
        String urlGSuite = "http://gmail.com"; // company site

        // excel data
        int startRow = 2;
        int endRow = 6;
        int[] columns = {0, 1, 2, 3, 4}; // clientName, clientEmail, cc, subject & body 
        File excelFile = new File("C:\\Users\\christian.saldana\\Downloads\\Passport\\Data for send emails.xlsx");

        // attachment path
        //String rootAttachments = "C:\\Users\\Chris\\Downloads\\rpaacnmyte";

        /*******************************************************************
         * Actions
         *******************************************************************/

        // step 1 - retrieve information from excel file
        ArrayList<Company> listOfCompanies = new ArrayList<Company>();
        ExcelReader excel = new ExcelReader();
        listOfCompanies = excel.readFromExcel(excelFile, startRow, endRow, columns);

        // step 2 - find attachments
        //Attachments attach = new Attachments();
        //attach.getAttachments(listOfCompanies, rootAttachments);

        // step 3 - create emails drafts
        Email gsuite = new Email();
        gsuite.createDrafts(listOfCompanies, user, password, urlGSuite);

//         display purpose only
        for(Company co : listOfCompanies){
            System.out.println("client: " + co.clientName + " email: " + co.clientEmail + " subject: " + co.subject + " attachment: " + co.attachment);
        }
    }


}

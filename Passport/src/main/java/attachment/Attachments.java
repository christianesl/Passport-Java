package attachment;

import company.Company;
import company.FiscalYear;

import java.util.Hashtable;
import java.util.ArrayList;
import java.io.File;


public class Attachments {

    

    private String getDate() {
        FiscalYear fy = new FiscalYear();
        return fy.getCurrentMonth() + "-" + fy.getCurrentYear();
    }

    private static void findByAttachment(String path, String clientName, String currentDate, Hashtable<String, String> attachment) {

        File root = new File(path);
        File[] files = root.listFiles();

        // base case
        if (files == null) {
            return;
        }

        for (File f : files) {

            if (f.isFile() && f.getName().contains(clientName) && f.getName().contains(currentDate)) {
                attachment.put("attachment", f.getAbsolutePath());
                return;
            }
        }

        for (File sub : files) {
            findByAttachment(sub.getAbsolutePath(), clientName, currentDate, attachment);
        }
    }

    public void getAttachments(ArrayList<Company> listOfCompanies, String attachmentRootPath) {
        String currentDate = getDate().toLowerCase();
        Hashtable<String, String> currentAttachment = new Hashtable<String, String>();

        // find attachments
        for (Company co : listOfCompanies) {

            currentAttachment.put("attachment", "");
            findByAttachment(attachmentRootPath, co.clientName.toLowerCase(), currentDate, currentAttachment);

            if (!currentAttachment.get("attachment").equals("")) {
                co.attachment = currentAttachment.get("attachment");
            }
        }
    }
}

package company;

public class Company {

    public String clientName;
    public String clientEmail;
    public String cc;
    public String subject;
    public String tbody;
    public String attachment;

    public Company(String client, String emailAddress, String cc_value, String subject, String body){
        this.clientName = client;
        this.clientEmail = emailAddress;
        this.cc = cc_value;
        this.subject = subject;
        this.tbody = body;
    }

}

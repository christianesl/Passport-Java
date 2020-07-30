package google;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GetAccountInformation {

    public String typeUser() {
        String user = "";
        JTextField tf = new JTextField();
        int okCxl = JOptionPane.showConfirmDialog(null, tf, "Please type your user id :", JOptionPane.OK_OPTION);
        if (okCxl == JOptionPane.OK_OPTION) {
            user = new String(tf.getText());
        } else {
            System.exit(1);
        }

        return (user);

    }

    public String typePassword() {
        String password = "";
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Please type your password :", JOptionPane.OK_OPTION);
        if (okCxl == JOptionPane.OK_OPTION) {
            password = new String(pf.getPassword());
        } else {
            System.exit(1);
        }

        return (password);

    }

}

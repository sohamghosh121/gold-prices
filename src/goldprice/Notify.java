/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goldprice;

/**
 *
 * @author Soham G
 */
import com.sendgrid.*;


public class Notify {

    public static int PRICE_INCREASE  = 0;
    public static int PRICE_DECREASE  = 0;

    private int notificationType;

    public Notify(int type)
    {
        this.notificationType = type;
    }
    public void emailNotification()
    {
        SendGrid sendgrid = new SendGrid("app28473885@heroku.com", "nqrasqhb");
        SendGrid.Email email = new SendGrid.Email();
        email.addTo("ghosh.soham@gmail.com");
        email.setFrom("goldprice-notify@noreply.com");

        if (notificationType == PRICE_INCREASE)
        {
            email.setSubject("Gold prices have risen!");
            email.setText("Gold prices have risen. You may want to SELL some Gold!!");
        }
        else if (notificationType == PRICE_DECREASE)
        {
            email.setSubject("Gold prices have fallen!");
            email.setText("Gold prices have fallen. You may want to BUY some Gold!!");
        }


        try {
          SendGrid.Response response = sendgrid.send(email);
          System.out.println(response.getMessage());
        }
        catch (SendGridException e) {
          System.err.println(e);
        }
    }
}

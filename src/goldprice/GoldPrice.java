/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goldprice;

/**
 *
 * @author Soham G
 */
public class GoldPrice {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        CurrentPrice p = new CurrentPrice();
        p.updatePrice();

        if (p.getPrice() > 51000)
        {
            Notify n = new Notify(Notify.PRICE_INCREASE);
            System.out.println("Notified about price increase. Price was "+p.getPrice());
        }
        else if (p.getPrice() < 51000)
        {
            Notify n = new Notify(Notify.PRICE_DECREASE);
            System.out.println("Notified about price decrease. Price was "+p.getPrice());
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goldprice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Soham G
 */
public class CurrentPrice {

    private int price;

    public int getPrice()
    {
        return this.price;
    }

    public  void updatePrice()
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String matchPattern = "<td><b>CAST BARS</b></td><td>SGD</td><td>1 KILOBAR</td><td>[0-9]{5}.[0-9]{2}</td><td>[0-9]{5}.[0-9]{2}</td>";
        String line;

        try {
            url = new URL("https://uniservices1.uobgroup.com/secure/online_rates/gold_and_silver_prices.jsp?s_cid=GS_rate_pg");
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                if (line.matches(matchPattern))
                {
                    price = Integer.parseInt(line.substring(line.length()-13, line.length()-8));
                }
            }
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (Exception e) {
                // nothing to see here
            }
        }
    }
}

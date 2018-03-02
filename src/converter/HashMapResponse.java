package converter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.HashMap;

/**
 * Created by naryniec on 9/16/2014.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HashMapResponse {
    protected HashMap<Double,String> Rates;

    // constructor
    public HashMapResponse() {
        Rates = new HashMap<Double,String>();
    }

    /**
     * @return HashMap<String,String>
     */
    public HashMap<Double,String> getRates() {
        if (Rates==null) {
            Rates = new HashMap<Double,String>();
        }
        return Rates;
    }

    /**
     * @param rate
     * @param curency
     */
    public void put(Double rate, String curency) {
        Rates.put(rate, curency);
    }
}
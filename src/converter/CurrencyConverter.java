package converter;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by naryniec on 9/15/2014.
 */
@WebService()
public class CurrencyConverter {
    public static enum Currency {
        HRK(0.5517),
        USD(3.2522),
        CZK(0.1523),
        EUR(4.2028),
        IND(5.3225);

        private final double rate;

        Currency(double rate) {
            this.rate = rate;
        }

        double returnRate() {
            return rate;
        }
    }

    @WebMethod
    public double getConversionRate(Currency currency1, Currency currency2) {
        double randomValue = 1;
        if (currency1 == Currency.IND)
            randomValue = 0.97d;
        return (double)Math.round(currency1.returnRate() / currency2.returnRate() * randomValue * 10000) / 10000;
    }

    @WebMethod
    public double convertBetweenCurrencies(Currency currency1, Currency currency2, double amount) {
        //some random value here
        return amount * getConversionRate(currency1, currency2);
    }

    @WebMethod
    public HashMapResponse getRates(Currency currency) {
        HashMapResponse Rates = new HashMapResponse();
        for (Currency c : Currency.values()) {
            double rate = (double)Math.round(c.returnRate()/currency.returnRate()* 10000) / 10000;
            Rates.put(rate, getCurrencyDescription(c));
        }
        return Rates;
    }

    @WebMethod
    public String getCurrencyDescription(Currency currency) {
        String desc = "Bug!";
        switch (currency) {
            case HRK:
                desc = "Croatian Kuna";
                break;
            case USD:
                desc = "U.S. Dollar";
            case CZK:
                desc = "Czech Koruna";
                break;
            case EUR:
                desc = "Euro";
                break;
            case IND:
                desc = "Indian Rupee";
                break;
        }
        return desc;
    }
}

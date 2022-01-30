package ayoholdings.com.metricconversion.api.service;

import ayoholdings.com.metricconversion.api.message.CurrencyResponse;

import java.math.BigDecimal;

/**
 * The interface ICurrencyService.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
public interface ICurrencyService {

    /**
     * Convert US dollar to rand .
     *
     * @param currencyValue      the currencyValue
     * @return the currency value in Rands
     */
    CurrencyResponse getRandCurrency(BigDecimal currencyValue) ;

    /**
     * convert rand to US dollar.
     *
     * @param currencyValue      the currencyValue
     * @return the currency value in US Dollar
     */
    CurrencyResponse getDollarCurrency(BigDecimal currencyValue);
}

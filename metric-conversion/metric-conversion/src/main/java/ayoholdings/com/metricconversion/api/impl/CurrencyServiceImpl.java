package ayoholdings.com.metricconversion.api.impl;

import ayoholdings.com.metricconversion.api.message.CurrencyResponse;
import ayoholdings.com.metricconversion.api.helper.MetricConversionConstants;
import ayoholdings.com.metricconversion.api.service.ICurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The implementation of ICurrencyService.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
@Service
public class CurrencyServiceImpl implements ICurrencyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);


    /**
     * Convert the dollar to rand value.
     *
     * @param currencyValue the dollar currencyValue
     * @return the value of rand after it was converted from dollar
     */
    @Override
    public CurrencyResponse getRandCurrency(BigDecimal currencyValue) {
        CurrencyResponse currencyResponse = new CurrencyResponse();

        try {
            BigDecimal randCurrency = currencyValue.multiply(MetricConversionConstants.CURRENCY_EXCHANGE_RATE);
            currencyResponse.setFrom("Dollar");
            currencyResponse.setTo("Rand");
            currencyResponse.setValue(randCurrency);
            currencyResponse.setResultMessage("Succsess");
        } catch (Exception ex) {
            LOGGER.error("Convertion from Dollor to Rand Failed : " + ex.getStackTrace());
            currencyResponse.setResultMessage(ex.getMessage());
        }

        return currencyResponse;
    }

    /**
     * Convert the rand to rand dollor.
     *
     * @param currencyValue the Rand currencyValue
     * @return the value of dollor after it was converted from rand
     */
    @Override
    public CurrencyResponse getDollarCurrency(BigDecimal currencyValue) {
        CurrencyResponse currencyResponse = new CurrencyResponse();

        try {
            BigDecimal dollorCurrency = currencyValue.divide(MetricConversionConstants.CURRENCY_EXCHANGE_RATE, 2, RoundingMode.HALF_UP);
            currencyResponse.setFrom("Rand");
            currencyResponse.setTo("Dollar");
            currencyResponse.setValue(dollorCurrency);
            currencyResponse.setResultMessage("Succsess");
        } catch (Exception ex) {
            LOGGER.error("Convertion from Rand to Dollor Failed : " + ex.getStackTrace());
            currencyResponse.setResultMessage(ex.getMessage());
        }

        return currencyResponse;
    }
}

package ayoholdings.com.metricconversion.api.impl;

import ayoholdings.com.metricconversion.api.message.CurrencyResponse;
import ayoholdings.com.metricconversion.api.service.ICurrencyService;
import org.junit.Test;
import org.hamcrest.Matchers;


import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * The test for CurrencyService Service.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
public class CurrencyServiceImplTest {

    @Test
    public void testRandCurrency() throws Exception {
        ICurrencyService currencyService = new CurrencyServiceImpl();
        CurrencyResponse currencyResponse = currencyService.getRandCurrency(BigDecimal.valueOf(5));
        assertThat(currencyResponse, is(notNullValue()));
        assertThat(currencyResponse.getValue(), is(equalTo(BigDecimal.valueOf(77.70).setScale(2, RoundingMode.HALF_UP))));
    }

    @Test
    public void testDollarCurrency() throws Exception {
        ICurrencyService currencyService = new CurrencyServiceImpl();
        CurrencyResponse currencyResponse = currencyService.getDollarCurrency(BigDecimal.valueOf(10));
        assertThat(currencyResponse, is(notNullValue()));
        assertThat(currencyResponse.getValue(), is(equalTo(BigDecimal.valueOf(0.64).setScale(2, RoundingMode.HALF_UP))));
    }
}

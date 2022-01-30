package ayoholdings.com.metricconversion.api.impl;

import ayoholdings.com.metricconversion.api.message.TemperatureResponse;
import ayoholdings.com.metricconversion.api.service.ITemperatureService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * The test for TemperatureService Service.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
public class TemperatureServiceImplTest {


    @Test
    public void testCelciusTemperature() throws Exception {
        ITemperatureService temperatureService = new TemperatureServiceImpl();
        TemperatureResponse temperatureResponse = temperatureService.getCelciusTemperature(10);
        assertThat(temperatureResponse, is(notNullValue()));
        assertThat(temperatureResponse.getValue(), is(-12.22));
    }

    @Test
    public void testFarenheitTemperature() throws Exception {
        ITemperatureService temperatureService = new TemperatureServiceImpl();
        TemperatureResponse temperatureResponse = temperatureService.getFarenheitTemperature(-12.22);
        assertThat(temperatureResponse, is(notNullValue()));
        assertThat(temperatureResponse.getValue(), is(10.0));
    }
}

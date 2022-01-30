package ayoholdings.com.metricconversion.api.impl;

import ayoholdings.com.metricconversion.api.message.TemperatureResponse;
import ayoholdings.com.metricconversion.api.service.ITemperatureService;
import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * The implementation of ITemperatureService.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
@Service
public class TemperatureServiceImpl implements ITemperatureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureServiceImpl.class);

    /**
     * Convert the Farenheit to Celcius value.
     *
     * @param temperatureValue the Farenheit temperatureValue
     * @return the value of Celcius after it was converted from Farenheit
     */
    @Override
    public TemperatureResponse getCelciusTemperature(double temperatureValue) {
        TemperatureResponse temperatureResponse = new TemperatureResponse();

        try {
            double celciusTemperature = (temperatureValue - 32) * 5 / 9;
            temperatureResponse.setFrom("Farenheit");
            temperatureResponse.setTo("Celcius");
            temperatureResponse.setValue(Precision.round(celciusTemperature,2));
            temperatureResponse.setResultMessage("SUCCESS");
        } catch (Exception ex) {
            LOGGER.error("Convertion from Farenheit to Celcius Failed : " + ex.getStackTrace());
            temperatureResponse.setResultMessage(ex.getMessage());
        }
        return temperatureResponse;
    }

    /**
     * Convert the Celcius to Farenheit value.
     *
     * @param temperatureValue the Celcius temperatureValue
     * @return the value of Farenheit after it was converted from Celcius
     */
    @Override
    public TemperatureResponse getFarenheitTemperature(double temperatureValue) {
        TemperatureResponse temperatureResponse = new TemperatureResponse();

        try {
            double farenheitTemperature = (temperatureValue * 9 / 5) + 32;
            temperatureResponse.setFrom("Celcius");
            temperatureResponse.setTo("Farenheit");
            temperatureResponse.setValue( Precision.round(farenheitTemperature,2));
            temperatureResponse.setResultMessage("SUCCESS");
        } catch (Exception ex) {
            LOGGER.error("Convertion from Celcius to Farenheit Failed : " + ex.getStackTrace());
            temperatureResponse.setResultMessage(ex.getMessage());
        }
        return temperatureResponse;
    }
}

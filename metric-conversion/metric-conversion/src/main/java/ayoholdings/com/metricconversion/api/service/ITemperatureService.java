package ayoholdings.com.metricconversion.api.service;

import ayoholdings.com.metricconversion.api.message.TemperatureResponse;

/**
 * The interface ITemperatureService.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
public interface ITemperatureService {

    /**
     * Convert Farenheit to Celcius .
     *
     * @param temperatureValue      the temperatureValue
     * @return the temperature value in Celcius
     */
    TemperatureResponse getCelciusTemperature(double temperatureValue);

    /**
     * convert Celcius to Farenheit.
     *
     * @param temperatureValue      the temperatureValue
     * @return the temperature value in Farenheit
     */
    TemperatureResponse getFarenheitTemperature(double temperatureValue);
}

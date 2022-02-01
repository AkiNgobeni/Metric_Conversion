package ayoholdings.com.metricconversion.api.controller;

import ayoholdings.com.metricconversion.api.message.CurrencyResponse;
import ayoholdings.com.metricconversion.api.message.DistanceResponse;
import ayoholdings.com.metricconversion.api.message.TemperatureResponse;
import ayoholdings.com.metricconversion.api.helper.MetricConversionConstants;
import ayoholdings.com.metricconversion.api.service.ICurrencyService;
import ayoholdings.com.metricconversion.api.service.IDistanceService;
import ayoholdings.com.metricconversion.api.service.ITemperatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controller for all the Metric conversion related operations. This is the public facing interface .
 *   @author Nyiko Ngobeni
 *   @since 2022-01-28
 */

@RestController
@RequestMapping("/metricContoller/v1/")
public class MetricConversionApplicationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricConversionApplicationController.class);

    @Autowired
    private ICurrencyService currencyService;

    @Autowired
    private IDistanceService distanceService;

    @Autowired
    private ITemperatureService temperatureService;

    @RequestMapping(value = "/fromTemperatureType/{fromTemperatureType}/temperatureValue/{temperatureValue}", method = GET)
    public HttpEntity<TemperatureResponse> getTemperature(@PathVariable("fromTemperatureType") String fromTemperatureType,
                                                          @PathVariable("temperatureValue") double temperatureValue) {

        if (fromTemperatureType.equalsIgnoreCase(MetricConversionConstants.FARENHEIT)) {
            return new ResponseEntity(temperatureService.getCelciusTemperature(temperatureValue), HttpStatus.OK);
        } else if (fromTemperatureType.equalsIgnoreCase(MetricConversionConstants.CELCIUS)) {
            return new ResponseEntity(temperatureService.getFarenheitTemperature(temperatureValue), HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("Invalid Temperature Type");
        }

    }


    @RequestMapping(value = "/fromDistanceType/{fromDistanceType}/distanceValue/{distanceValue}", method = GET)
    public HttpEntity<DistanceResponse> getDistance(@PathVariable("fromDistanceType") String fromDistanceType,
                                                    @PathVariable("distanceValue") double distanceValue) {

        if (fromDistanceType.equalsIgnoreCase(MetricConversionConstants.MILES)) {
            return new ResponseEntity(distanceService.getKilometresDistance(distanceValue), HttpStatus.OK);
        } else if (fromDistanceType.equalsIgnoreCase(MetricConversionConstants.KILOMETRES)) {
            return new ResponseEntity(distanceService.getMilesDistance(distanceValue), HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("Invalid Distance Type");
        }

    }

    @RequestMapping(value = "/fromCurrencyType/{fromCurrencyType}/currencyValue/{currencyValue}", method = GET)
    public HttpEntity<CurrencyResponse> getDistance(@PathVariable("fromCurrencyType") String fromCurrencyType,
                                                    @PathVariable("currencyValue") BigDecimal currencyValue) {

        if (fromCurrencyType.equalsIgnoreCase(MetricConversionConstants.DOLLAR)) {
            return new ResponseEntity(currencyService.getRandCurrency(currencyValue), HttpStatus.OK);
        } else if (fromCurrencyType.equalsIgnoreCase(MetricConversionConstants.RAND)) {
            return new ResponseEntity(currencyService.getDollarCurrency(currencyValue), HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("Invalid Currency Type");
        }

    }
}

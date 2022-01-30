package ayoholdings.com.metricconversion.api.impl;

import ayoholdings.com.metricconversion.api.message.DistanceResponse;
import ayoholdings.com.metricconversion.api.helper.MetricConversionConstants;
import ayoholdings.com.metricconversion.api.service.IDistanceService;
import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * The implementation of IDistanceService.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
@Service
public class DistanceServiceImpl implements IDistanceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceServiceImpl.class);

    /**
     * Convert the miles to kilometres value.
     *
     * @param distanceValue the Kilometres distanceValue
     * @return the value of Kilometres after it was converted from miles
     */
    @Override
    public DistanceResponse getKilometresDistance(double distanceValue) {
        DistanceResponse distanceResponse = new DistanceResponse();

        try {
            double kilometresDistance = distanceValue * MetricConversionConstants.DISTANCE_EXCHANGE_RATE_VALUE;
            distanceResponse.setFrom("Miles");
            distanceResponse.setTo("Kilometres");
            distanceResponse.setValue(Precision.round(kilometresDistance,2));
            distanceResponse.setResultMessage("SUCCESS");
        } catch (Exception ex) {
            LOGGER.error("Convertion from Miles to Kilometres Failed : " + ex.getStackTrace());
            distanceResponse.setResultMessage(ex.getMessage());
        }

        return distanceResponse;
    }

    /**
     * Convert the miles to miles value.
     *
     * @param distanceValue the miles distanceValue
     * @return the value of miles after it was converted from kilometres
     */
    @Override
    public DistanceResponse getMilesDistance(double distanceValue) {
        DistanceResponse distanceResponse = new DistanceResponse();

        try {
            double milesDistance = distanceValue / MetricConversionConstants.DISTANCE_EXCHANGE_RATE_VALUE;
            distanceResponse.setFrom("Kilometres");
            distanceResponse.setTo("Miles");
            distanceResponse.setValue(Precision.round(milesDistance,2));
            distanceResponse.setResultMessage("SUCCESS");
        } catch (Exception ex) {
            LOGGER.error("Convertion from Miles to Kilometres Failed : " + ex.getStackTrace());
            distanceResponse.setResultMessage(ex.getMessage());
        }

        return distanceResponse;
    }
}

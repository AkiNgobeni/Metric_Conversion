package ayoholdings.com.metricconversion.api.service;

import ayoholdings.com.metricconversion.api.message.DistanceResponse;

/**
 * The interface IDistanceService.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
public interface IDistanceService {

    /**
     * Convert Miles to Kilometres .
     *
     * @param distanceValue      the distanceValue
     * @return the distance value in Kilometres
     */
    DistanceResponse getKilometresDistance(double distanceValue);

    /**
     * convert Kilometres to Miles.
     *
     * @param distanceValue      the distanceValue
     * @return the distance value in Miles
     */
    DistanceResponse getMilesDistance(double distanceValue);
}

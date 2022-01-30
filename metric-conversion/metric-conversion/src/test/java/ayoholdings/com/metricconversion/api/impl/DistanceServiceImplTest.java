package ayoholdings.com.metricconversion.api.impl;


import ayoholdings.com.metricconversion.api.message.DistanceResponse;
import ayoholdings.com.metricconversion.api.service.IDistanceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * The test for DistanceService Service.
 *
 * @author Nyiko Ngobeni
 * @since 2022-01-28
 */
public class DistanceServiceImplTest {

    @Test
    public void testKilometresDistance() throws Exception {
        IDistanceService distanceService = new DistanceServiceImpl();
        DistanceResponse distanceResponse = distanceService.getKilometresDistance(6.21);
        assertThat(distanceResponse, is(notNullValue()));
        assertThat(distanceResponse.getValue(), is(10.0));
    }

    @Test
    public void testMilesDistance() throws Exception {
        IDistanceService distanceService = new DistanceServiceImpl();
        DistanceResponse distanceResponse = distanceService.getMilesDistance(10);
        assertThat(distanceResponse, is(notNullValue()));
        assertThat(distanceResponse.getValue(), is(6.21));
    }
}

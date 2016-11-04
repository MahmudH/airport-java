import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class AirportTest {

    public static final WeatherService GOOD_WEATHER = () -> false;
    public static final WeatherService STORMY_WEATHER = () -> true;
    private Airport airport;
    private int CAPACITY = 20;

    @Mock
    Plane plane;

    @Mock
    List<Plane> planes = new ArrayList<>();

    @Test
    public void shouldLandAPlane() throws AirportException {
        airport = new Airport(GOOD_WEATHER);
        airport.landPlane(plane);
        planes = airport.getPlanes();
        assertEquals(1, planes.size());
    }

    @Test
    public void shouldTakeOfPlane() throws AirportException {
        airport = new Airport(GOOD_WEATHER);
        airport.landPlane(plane);
        airport.takeOffPlane(plane);
        planes = airport.getPlanes();
        assertEquals(0, planes.size());
    }

    @Test(expected = AirportException.class)
    public void shouldNotTakeOffIfStormy() throws Exception {
        airport = new Airport(STORMY_WEATHER);
        airport.takeOffPlane(plane);
    }

    @Test(expected = AirportException.class)
    public void shouldNotLandPlaneIfStormy() throws Exception {
        airport = new Airport(STORMY_WEATHER);
        airport.landPlane(plane);
    }

    @Test(expected = AirportException.class)
    public void shouldPreventLandingWhenAirportIsFull() throws Exception {
        airport = new Airport(GOOD_WEATHER);
        for (int i = 0; i < CAPACITY; i++) {
            airport.landPlane(plane);
        }
        airport.landPlane(plane);
    }
}

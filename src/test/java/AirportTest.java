import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AirportTest {

    private Airport airport;

    @Mock
    Plane plane;

    @Mock
    List<Plane> planes = new ArrayList<Plane>();

    @Before
    public void setUp() throws Exception {
        airport = spy(new Airport());
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldLandAPlane() {
        airport.landPlane(plane);
        planes = airport.getPlanes();
        assertEquals(1, planes.size());
    }

    @Test
    public void shouldTakeOfPlane() throws AirportException {
        when(airport.stormyWeather()).thenReturn(false);
        airport.landPlane(plane);
        airport.takeOffPlane(plane);
        planes = airport.getPlanes();
        assertEquals(0, planes.size());
    }

    @Test(expected = AirportException.class)
    public void shouldNotTakeOffIfStormy() throws Exception {
        when(airport.stormyWeather()).thenReturn(true);
        airport.takeOffPlane(plane);
    }
}

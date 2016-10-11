import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class AirportTest {

    private Airport airport;

    @Mock
    Plane plane;

    @Before
    public void setUp() throws Exception {
        airport = new Airport();
    }

    @Test
    public void shouldLandAPlane() {
        String status = airport.landPlane(plane);
        assertEquals("Plane landed", status);
    }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class AirportTest {
    @Mock
    Plane plane;
    private Airport airport;

    @Before
    public void setUp() throws Exception {
        Airport airport = new Airport();
    }

    @Test
    public void shouldLandAPlane() {
        String status = airport.landPlane(plane);
        System.out.println(status);
//        Assert.assertThat(status, equalTo("Plane landed"));
    }
}

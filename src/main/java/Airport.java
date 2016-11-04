import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Airport {
    private List<Plane> planes;
    private int CAPACITY;
    private WeatherService weatherService;

    public List<Plane> getPlanes() {
        return Collections.unmodifiableList(planes);
    }

    public int getNumberOfPlanes() {
        return planes.size();
    }

    public Airport(WeatherService weatherService) {
        this.weatherService = weatherService;
        this.CAPACITY = 20;
        this.planes = new ArrayList<Plane>();
    }

    public void landPlane(Plane plane) {
        if (weatherService.stormyWeather()) {
            throw new AirportException("Too stormy to land");
        }
        if (getPlanes().size() >= CAPACITY) {
            throw new AirportException("Airport is full, cannot land");
        }
        planes.add(plane);

    }

    public void takeOffPlane(Plane plane) {
        if (weatherService.stormyWeather()) {
            throw new AirportException("Too stormy to fly");
        }
        planes.remove(plane);
    }
}

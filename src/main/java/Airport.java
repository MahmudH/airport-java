import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Plane> planes;

    public List<Plane> getPlanes() {
        return planes;
    }

    public Airport() {
        this.planes = new ArrayList<Plane>();
    }

    public void landPlane(Plane plane) throws AirportException {
        if (stormyWeather()) {
            throw new AirportException("Too stormy to land");
        }
        planes.add(plane);

    }

    public void takeOffPlane(Plane plane) throws AirportException {
        if (stormyWeather()) {
            throw new AirportException("Too stormy to fly");
        }
        planes.remove(plane);
    }

    public boolean stormyWeather() {
        return Math.random() > 0.5;
    }
}

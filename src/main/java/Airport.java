import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Plane> planes;
    private int CAPACITY;

    public List<Plane> getPlanes() {
        return planes;
    }

    public Airport() {
        this.CAPACITY = 20;
        this.planes = new ArrayList<Plane>();
    }

    public void landPlane(Plane plane) throws AirportException {
        if (stormyWeather()) {
            throw new AirportException("Too stormy to land");
        }
        if (getPlanes().size() > CAPACITY) {
            throw new AirportException("Airport is full, cannot land");
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

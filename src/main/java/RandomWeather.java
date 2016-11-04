public class RandomWeather implements WeatherService {
    @Override
    public boolean stormyWeather() {
        return Math.random() > 0.5;
    }
}

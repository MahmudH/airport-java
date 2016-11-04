public class Main {
    public static void main(String args[]) {
        Plane plane = new Plane();
        RandomWeather weatherService = new RandomWeather();
        Airport airport = new Airport(weatherService);
        System.out.println(weatherService.stormyWeather());
    }
}

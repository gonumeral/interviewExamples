import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherData {
    public static void main(String[] args) {
        String openWeatherKey = "MY_API_KEY";
        String geoTagUrl = "http://api.openweathermap.org/geo/1.0/direct?q=San Francisco&appid=" + openWeatherKey;
        try {
            URL url = new URL(geoTagUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JSONArray data = new JSONArray(response.toString());
                double lon = data.getJSONObject(0).getDouble("lon");
                double lat = data.getJSONObject(0).getDouble("lat");
                String weatherUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&units=imperial&appid=" + openWeatherKey;
                url = new URL(weatherUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    JSONObject weatherData = new JSONObject(response.toString());
                    double temperature = weatherData.getJSONObject("main").getDouble("temp");
                    System.out.println("Temperature: " + temperature);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package ofthought.mechanics.locationtest;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIRequestTest extends AsyncTask<Double, Void, String> {
    private static final String API_BASE = "http://52.56.139.103/location/";

    @Override
    protected String doInBackground(Double... strings) {
        double longit = strings[0];
        double latit = strings[1];

        try {
            String urlString = API_BASE + longit + "/" + latit;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            return connection.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

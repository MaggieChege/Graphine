package graphine.shikooh.example.com.graphineeastafrica;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by shikooh on 4/25/18.
 */

public class HTTPDataHandler {
    static  String stream=null;

    public HTTPDataHandler() {

    }
    public  String GetHTTPData(String urlString){
        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection =(HttpURLConnection)url.openConnection();
//check connection status
            if(urlConnection.getResponseCode() == 200){
//if response code = 200 ~ HTTP.OK

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//Read BUfferedINoutStream
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while((line =r.readLine()) !=null)
                    sb.append(line);
                stream = sb.toString();
                urlConnection.disconnect();
            }
            else{

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

     public void PostHTTData(String urlString, String json){
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
               urlConnection.setRequestMethod("POST");
               urlConnection.setDoOutput(true);
            byte[] out = json.getBytes(StandardCharsets.UTF_8);

            int length = out.length;
               urlConnection.setFixedLengthStreamingMode(length);
               urlConnection.setRequestProperty("Content-Type","application/json; charset-UTF-8");
               urlConnection.connect();
               try (OutputStream os = urlConnection.getOutputStream()){
                   os.write(out);
               }
               InputStream response = urlConnection.getInputStream();


                } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PutHTTData(String urlString, String newValue){
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("PUT");
            urlConnection.setDoOutput(true);
            byte[] out = newValue.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            urlConnection.setFixedLengthStreamingMode(length);
            urlConnection.setRequestProperty("Content-Type","application/json; charset-UTF-8");
            urlConnection.connect();
            try (OutputStream os = urlConnection.getOutputStream()){
                os.write(out);
            }
            InputStream response = urlConnection.getInputStream();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void DeleteHTTPData(String urlString, String json)  {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("DELETE");
            urlConnection.setDoOutput(true);
            byte[] out = json.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            urlConnection.setFixedLengthStreamingMode(length);
            urlConnection.setRequestProperty("Content-Type","application/json; charset-UTF-8");
            urlConnection.connect();
            try (OutputStream os = urlConnection.getOutputStream()){
                os.write(out);
            }
            InputStream response = urlConnection.getInputStream();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

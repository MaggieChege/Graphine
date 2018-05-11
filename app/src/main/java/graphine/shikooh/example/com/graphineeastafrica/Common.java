package graphine.shikooh.example.com.graphineeastafrica;

import graphine.shikooh.example.com.graphineeastafrica.Class.Users;

/**
 * Created by shikooh on 4/25/18.
 */

public class Common {
    private static String DB_NAME ="users";
    private static String COLLECTION_NAME ="newcontact";
    public  static String API_KEY ="Thl93Lu66ml9vzcdjoH0DJBiHNwisWJl";
    public  static String getAddressSingle(Users users){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("/"+users.get_id().getOid()+"?apiKey="+API_KEY);
        return  stringBuilder.toString();
    }

    public  static String getAddressAPI(){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return  stringBuilder.toString();
    }
}

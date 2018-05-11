package graphine.shikooh.example.com.graphineeastafrica;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import graphine.shikooh.example.com.graphineeastafrica.Class.Users;

public class MaintenanceRequestActivity extends AppCompatActivity {
ListView lstView;
Button submit;
EditText date,county,name,town,address,phone,email,content;
Users usersSelected = null;
List<Users> users = new ArrayList<Users>( );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_request);
    lstView = (ListView)findViewById(R.id.lstView);
    submit= (Button)findViewById(R.id.submit);
        date=(EditText)findViewById(R.id.date);
        county=(EditText)findViewById(R.id.county);
        name=(EditText)findViewById(R.id.name);
        town=(EditText)findViewById(R.id.town);
        address=(EditText)findViewById(R.id.address);
        phone =(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        content=(EditText)findViewById(R.id.content);
//        Load data when app is opened
//        new GetData().execute(Common.getAddressAPI());

//Onclick Button event
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new PostData(county.getText().toString(),name.getText().toString()).execute(Common.getAddressAPI());
//    new PostData(county.getText().toString(),name.getText().toString()).execute(Common.getAddressAPI());
     new PostData(date.getText().toString(),county.getText().toString(),name.getText().toString(),town.getText().toString(),address.getText().toString(),phone.getText().toString(),email.getText().toString(),content.getText().toString()).execute(Common.getAddressAPI());
            }
        });
    }
//    Function process data
    class GetData extends AsyncTask<String, Void, String>{
    ProgressDialog pd = new ProgressDialog(MaintenanceRequestActivity.this);

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//  preprocess
        pd.setTitle("Please wait.....");
        pd.show();
    }



    @Override
    protected String doInBackground(String... params) {
//        Running Process
        String stream=null;
        String urlString = params[0];
        HTTPDataHandler http = new HTTPDataHandler();
        stream = http.GetHTTPData(urlString);
        return  stream;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        Done process

//        Use Gson to parse Json to class
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Users>>(){}.getType();
        users=gson.fromJson(s,listType);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),users);
        lstView.setAdapter(adapter);
        pd.dismiss();
    }
}

//Add new request
    class PostData extends AsyncTask<String,String,String>{
    ProgressDialog pd = new ProgressDialog(MaintenanceRequestActivity.this);
    String date,county,name,town,address,phone,email,content;



    public PostData( String date,String county, String name, String town, String address, String phone, String email, String content) {
        this.date = date;
        this.county = county;
        this.name = name;
        this.town = town;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.content = content;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd.setTitle("Please wait....");
        pd.show();
    }

    @Override
    protected String doInBackground(String... params) {
        String urlString =params[0];
        HTTPDataHandler hh = new HTTPDataHandler();
        String json = "{\"date\":\"" +date+"\",\"county\":\"" + county + "\",\"name\":\"" + name + "\",\"town\":\"" + town + "\",\"address\":\"" + address + "\",\"phone\":\"" + phone + "\",\"email\":\"" + email + "\",\"content\":\"" + content + "\"}";

        hh.PostHTTData(urlString,json);
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        Refresh Data
        new GetData().execute(Common.getAddressAPI());
        pd.dismiss();
    }


    }

}
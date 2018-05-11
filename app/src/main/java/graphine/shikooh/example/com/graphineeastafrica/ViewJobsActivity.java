package graphine.shikooh.example.com.graphineeastafrica;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import graphine.shikooh.example.com.graphineeastafrica.Class.Users;

public class ViewJobsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    List<Users> users = new ArrayList<>();
    ListView lstView;
    SearchView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jobs);
        search = (SearchView)findViewById(R.id.search);
        lstView = (ListView)findViewById(R.id.lstView);
    new GetData().execute(Common.getAddressAPI());
        lstView.setTextFilterEnabled(true);
        setupSearchView();


    }

    private void setupSearchView() {
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setSubmitButtonEnabled(true);
        search.setQueryHint("Search Here");
    }
    @Override
    public boolean onQueryTextChange(String s) {
        if(TextUtils.isEmpty(s)){
            lstView.clearTextFilter();
        }else{
            lstView.setFilterText(s);
        }

        return true;
    }
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }



    //    Function process data
    class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog pd = new ProgressDialog(ViewJobsActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

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
}


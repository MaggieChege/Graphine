package graphine.shikooh.example.com.graphineeastafrica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MaintainceOptionsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintaince_options);

       ListView list_options = (ListView) findViewById(R.id.list_options);

        String[] items = { "Repair Electronics", "Maintenance", "Repair Generators", " Kitchen Appliances", "Green Energy Solutions" };

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        list_options.setAdapter(adapter);
        list_options.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView temp=(TextView) view;
        String Value = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), Value, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MaintainceOptionsActivity.this, MaintenanceRequestActivity.class));
    }
}

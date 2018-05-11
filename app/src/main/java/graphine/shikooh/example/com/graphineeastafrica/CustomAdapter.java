package graphine.shikooh.example.com.graphineeastafrica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import graphine.shikooh.example.com.graphineeastafrica.Class.Users;

/**
 * Created by shikooh on 4/25/18.
 */

public class CustomAdapter extends BaseAdapter{
    private Context mContext;
    private List<Users> lstUsers;

    public CustomAdapter(Context mContext, List<Users> lstUsers) {
        this.mContext = mContext;
        this.lstUsers = lstUsers;
    }

    public CustomAdapter(List<Users> users, int items_list, Context applicationContext) {
    }

    @Override
    public int getCount() {
        return lstUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return lstUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row,null);
        TextView  txt_date = (TextView)view.findViewById(R.id.txt_date);
        txt_date.setText(lstUsers.get(position).getDate());

        TextView  txt_county= (TextView)view.findViewById(R.id.txt_county);
        txt_county.setText(lstUsers.get(position).getCounty());

        TextView  txt_name = (TextView)view.findViewById(R.id.txt_name);
        txt_name.setText(lstUsers.get(position).getName());

        TextView  txt_town = (TextView)view.findViewById(R.id.txt_town);
        txt_town.setText(lstUsers.get(position).getTown());

        TextView  txt_address = (TextView)view.findViewById(R.id.txt_address);
        txt_address.setText(lstUsers.get(position).getAddress());

        TextView  txt_phone = (TextView)view.findViewById(R.id.txt_phone);
        txt_phone.setText(lstUsers.get(position).getPhone());

        TextView  txt_email = (TextView)view.findViewById(R.id.txt_email);
        txt_email.setText(lstUsers.get(position).getEmail());

        TextView  txt_content = (TextView)view.findViewById(R.id.txt_content);
        txt_content.setText(lstUsers.get(position).getContent());

        return view;
    }
}

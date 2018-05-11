package graphine.shikooh.example.com.graphineeastafrica;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
Button btn_rqstmaintenance,btn_viewjobs,btn_signout;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_rqstmaintenance = (Button) findViewById(R.id.btn_rqstmaintenance);
        btn_rqstmaintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MaintainceOptionsActivity.class));

            }
        });
        btn_viewjobs =(Button) findViewById(R.id.btn_viewjobs);
        btn_viewjobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewJobsActivity.class));

            }
        });
//        btn_signout =(Button) findViewById(R.id.sign_out);
//        btn_signout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                auth = FirebaseAuth.getInstance();
//
//                auth.signOut();
//
//// this listener will be called when there is change in firebase user session
//                FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
//                    @Override
//                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                        FirebaseUser user = firebaseAuth.getCurrentUser();
//                        if (user == null) {
//                            // user auth state is changed - user is null
//                            // launch login activity
//                            startActivity(new Intent(MainActivity.this, SplashActivity.class));
//                            finish();
//                        }
//                    }
//                };
//            }
//        });



    }
//    public void signout(){
//        auth = FirebaseAuth.getInstance();
//        auth.signOut();
//
//// this listener will be called when there is change in firebase user session
//        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user == null) {
//                    // user auth state is changed - user is null
//                    // launch login activity
//                    startActivity(new Intent(MainActivity.this, SplashActivity.class));
//                    finish();
//                }
//            }
//        };
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sign_out:
//                signout();
        }
        return super.onOptionsItemSelected(item);
    }
}

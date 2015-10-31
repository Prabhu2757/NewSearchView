package com.makeinfo.flowerpi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.makeinfo.flowerpi.API.GitHubService;
import com.makeinfo.flowerpi.model.Login;
import com.makeinfo.flowerpi.model.User;
import com.squareup.okhttp.ResponseBody;
import com.vpnews24.newspaper.R;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends ActionBarActivity {

    Button click;
    TextView tv;
    EditText edit_user;
    ProgressBar pbar;
    String API = "https://lystnow.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        click = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.tv);
        edit_user = (EditText) findViewById(R.id.edit);
        pbar = (ProgressBar) findViewById(R.id.pb);
        pbar.setVisibility(View.INVISIBLE);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edit_user.getText().toString();
                pbar.setVisibility(View.VISIBLE);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Map<String, String> params = new HashMap<String, String>();
                params.put("X-API-KEY", "MindBeam");
                params.put("email", "prabhu.vedappan@zcodia.in");
                params.put("password", "V.P6@bhu");


                GitHubService git = retrofit.create(GitHubService.class);
                Call call = git.getLogin(params);
                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Response<Login> response) {
                        Log.e("response", ""+response.body());
                        Login model = response.body();

                        if (model==null) {
                            //404 or the response cannot be converted to User.
                            ResponseBody responseBody = response.errorBody();
                            if (responseBody!=null) {
                                try {
                                    tv.setText("responseBody = "+responseBody.string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                tv.setText("responseBody = null");
                            }
                        } else {
                            //200
                            tv.setText("Github Name :"+model.getFirst_name()+"\nWebsite :"+model.getLast_name()+"\nCompany Name :"+model.getId());
                        }
                        pbar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        tv.setText("t = "+t.getMessage());
                        pbar.setVisibility(View.INVISIBLE);
                    }
                });

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

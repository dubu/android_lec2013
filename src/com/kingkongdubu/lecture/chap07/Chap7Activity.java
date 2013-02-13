package com.kingkongdubu.lecture.chap07;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.kingkongdubu.R;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13. 2. 13
 * Time: 오전 9:12
 * To change this template use File | Settings | File Templates.
 */
public class Chap7Activity extends Activity {
    TextView idEditText;
    TextView pwEditText;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_chap07);


        idEditText = (TextView) findViewById(R.id.class_chap7_idText);
        pwEditText = (TextView) findViewById(R.id.class_chap7_passwordText);
        submitBtn = (Button) findViewById(R.id.class_chap7_submitButton);

        /*
        String id_text = id.getText();
        String passwor = password.getText();
        */

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idEditText.getText().toString();
                String pw = pwEditText.getText().toString();

                //To change body of implemented methods use File | Settings | File Templates.
                login(id, pw);
            }
        });

    }

    private void login(String id, String pw) {
        String url = "https://logins.daum.net/accounts/mobile.do?url=(*)";
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost request = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("id", id));
        params.add(new BasicNameValuePair("pw", pw));


        HttpEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(params, "UTF-8");
            request.setEntity(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (response != null) {
            int statusCode = response.getStatusLine().getStatusCode();
            Log.d("TEST", "Code id " + statusCode);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);    //To change body of overridden methods use File | Settings | File Templates.
        // getMenuInflater().inflate(R.menu.activity_main, menu);  //????
        return true;
    }
}

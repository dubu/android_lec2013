package com.kingkongdubu.lecture.chap07;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.kingkongdubu.R;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 13. 2. 13
 * Time: 오전 9:12
 */
public class Chap7Activity extends Activity {
    TextView idEditText;
    TextView pwEditText;
    Button submitBtn;
    TextView resultTextView;
    CookieStore cookieStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_chap07);


        idEditText = (TextView) findViewById(R.id.class_chap7_idText);
        pwEditText = (TextView) findViewById(R.id.class_chap7_passwordText);

        resultTextView = (TextView) findViewById(R.id.class_chap7_textView);

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

    private void login(final String id, final String pw) {

        final Handler handler = new Handler();

        // case3. background에서 수행하도록 함.
        AsyncTask task = new AsyncTask<Object,Object,String>() {
            @Override
            protected String doInBackground(Object... objects) {
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
                    final int statusCode = response.getStatusLine().getStatusCode();
                    //Log.d("TEST", "Code id " + statusCode);

                    cookieStore = client.getCookieStore();
                    //return     String.valueOf(cookieStore)      ;
                    return getFileList();


                    /*
                    //main Thread 에 껴들어 적용 못한다.
                    //android.view.ViewRoot$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.

                    resultTextView.setText("Code id " + statusCode);


                    ///  case1 핸들러 사용
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //To change body of implemented methods use File | Settings | File Templates.
                            resultTextView.setText("Code id " + statusCode);
                        }
                    });

                    //  ///  case2    runOnUiThread 사용
                    Chap7Activity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            resultTextView.setText("Code id " + statusCode);
                        }
                    });
                    */
                }
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            protected void onPostExecute(String result) {
                if(result == null) {
                    resultTextView.setText("failed!");
                }else{
                    resultTextView.setText(result);
                }
                super.onPostExecute(result);    //To change body of overridden methods use File | Settings | File Templates.
            }
        };

        task.execute();
        //비동기 적용
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                /*
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
                    final int statusCode = response.getStatusLine().getStatusCode();
                    //Log.d("TEST", "Code id " + statusCode);


                    //main Thread 에 껴들어 적용 못한다.
                    //android.view.ViewRoot$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.

                    resultTextView.setText("Code id " + statusCode);


                    ///  case1 핸들러 사용
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //To change body of implemented methods use File | Settings | File Templates.
                            resultTextView.setText("Code id " + statusCode);
                        }
                    });

                    //  ///  case2    runOnUiThread 사용
                    Chap7Activity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            resultTextView.setText("Code id " + statusCode);
                        }
                    });
                }

                     */
            }
        });
        thread.start();


        /*
        // thread 로  이동
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
        */

    }

    private String getFileList() {
        // 쿠ㄱ키를 잘 킵한다.
         DefaultHttpClient client    = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://cloud.daum.net/disk/root.json")   ;
        client.setCookieStore(cookieStore);


        HttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        HttpEntity entity = response.getEntity() ;
        try {
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

         return null   ;

        // 이하 숙제 할때 필요함,
        //JSONObject o = new JSONObject(result);
        //o.getJSONObject(name)



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);    //To change body of overridden methods use File | Settings | File Templates.
        // getMenuInflater().inflate(R.menu.activity_main, menu);  //????
        return true;
    }
}

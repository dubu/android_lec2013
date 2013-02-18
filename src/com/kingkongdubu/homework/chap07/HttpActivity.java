package com.kingkongdubu.homework.chap07;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 13. 2. 13
 * Time: 오후 7:26
 */
public class HttpActivity extends Activity {
    TextView idEditText;
    TextView pwEditText;
    Button submitBtn;
    CookieStore cookieStore;
    ListView listView;
    ArrayList<RowData> itemlist;

    Activity activity;

    public HttpActivity() {
        super();
        this.activity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_chap07);


        idEditText = (TextView) findViewById(R.id.homework_chap07_idText);
        pwEditText = (TextView) findViewById(R.id.homework_chap07_passwordText);

        listView = (ListView) findViewById(R.id.homework_chap07_listView);

        submitBtn = (Button) findViewById(R.id.homework_chap07_submitButton);

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

        AsyncTask task = new AsyncTask<Object, Object, String>() {
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
                    e.printStackTrace();
                }

                HttpResponse response = null;
                try {
                    response = client.execute(request);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response != null) {
                    cookieStore = client.getCookieStore();
                    return getFileList();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                JSONObject o ;
                if (result == null) {
                    //resultTextView.setText("failed!");
                } else {
                    //resultTextView.setText(result);


                    //afjladsjflasjdlf

                    // 이하 숙제 할때 필요함,
                    itemlist = new ArrayList<RowData>();

                    try {
                        o = new JSONObject(result);

                        JSONObject data = o.getJSONObject("data").getJSONObject("metaInfo");
                        JSONArray rows =    data.getJSONArray("contents");
                        for (int i = 0 ; i < rows.length() ; i++){
                            RowData itemData = new RowData();
                            itemData.setName(rows.getJSONObject(i).getString("name").toString());
                            itemData.setCreated(rows.getJSONObject(i).getString("created").toString());
                            itemlist.add(itemData);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }

                    // data/ contends // name // created

                    listView = (ListView) findViewById(R.id.homework_chap07_listView);
                    listView.setAdapter(new SampleAdapter(itemlist,activity));




                }
                super.onPostExecute(result);    //To change body of overridden methods use File | Settings | File Templates.
            }
        };

        task.execute();

    }

    private String getFileList() {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://cloud.daum.net/disk/root.json");
        client.setCookieStore(cookieStore);
        HttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpEntity entity = response.getEntity();
        try {
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return null;




    }


}

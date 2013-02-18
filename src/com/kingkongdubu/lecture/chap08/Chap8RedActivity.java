package com.kingkongdubu.lecture.chap08;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import com.kingkongdubu.R;

/**
 * Date: 13. 2. 13
 * Time: 오전 9:12
 */
public class Chap8RedActivity extends Activity {

    private final Activity actity;

    public Chap8RedActivity() {
        super();
        this.actity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_chap08_red);

        Button redBtn = (Button) findViewById(R.id.class_chap8_redButton);


        int icon = R.drawable.dubu; // 아이콘을 지정
        CharSequence tickerText = "Hello"; // 티커 메시지
        long when = System.currentTimeMillis(); // 노티피케이션의 시간을 지정
        Context context = getApplicationContext(); // 어플리케이션의 컨텍스트를 얻음
        CharSequence contentTitle = "My notification"; // 타이틀 메시지
        CharSequence contentText = "Hello World!"; // 텍스트 메시지
        Intent notificationIntent = new Intent(this, Chap8RedActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        // 노티피케이션을 초기화 하고, 노티피케이션 사용을 위해 설정
        Notification notification = new Notification(icon, tickerText, when);
        notification.setLatestEventInfo(context, contentTitle, contentText,
                contentIntent);
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);

        redBtn.setText("5초 뒤 blue 이동");
        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // 5초후 이동 알람
                Intent intent = new Intent(getApplicationContext(), Chap8BlueActivity.class);
                AlarmManager manager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                PendingIntent sender = PendingIntent.getActivity(getApplicationContext(), 0, intent, 1);
                long triggerTime = SystemClock.elapsedRealtime() + 1000 * 5;
                manager.set(AlarmManager.ELAPSED_REALTIME, triggerTime, sender);



                /*
                Intent intent = new Intent(actity, Chap8BlueActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // 히스토리를 남기지 않는다
                startActivity(intent);
                */

            }
        });


    }


}

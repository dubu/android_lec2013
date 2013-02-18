package com.kingkongdubu.homework.chap02;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kingkongdubu.R;

/**
 * User: Administrator
 * Date: 13. 1. 25
 * Time: 오후 6:07
 */
public class PhoneCallActivity extends Activity {
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_chap02);

        //set right button
        Button buttonLoadImage = (Button) findViewById(R.id.btn_right);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }

    public void onClickCallBtn(View view) {
        try {
            Intent callIntenet = new Intent(Intent.ACTION_CALL);
            TextView phoneNumber = (TextView) findViewById(R.id.txt_phone);
            String callNumber = "tel:" + phoneNumber.getText();
            Log.e("call number == ", callNumber);
            callIntenet.setData(Uri.parse(callNumber));
            startActivity(callIntenet);
        } catch (ActivityNotFoundException act) {
            Log.e("Log", "phone call ERROR ");
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }


}

package com.kingkongdubu.lecture.chap09;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.kingkongdubu.R;

/**
 * User: Administrator
 * Date: 13. 2. 8
 * Time: 오전 9:00
 */
public class Chap9Activity extends Activity {

    private static int ID_BUTTON01 = 0x00000001;
    private static int ID_BUTTON02 = 0x00000002;
    private static int ID_BUTTON03 = 0x00000003;
    private static int ID_BUTTON04 = 0x00000004;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(onCreateContextView());

        DipUtils.getInstance().init(this);

        int pixel = DipUtils.getInstance().DpToPixel(100);
        float dp = DipUtils.getInstance().PixelToDp(100);

        int xhdpi = DipUtils.getInstance().fromExtraHightDensityPixel(100);
        int hdpi = DipUtils.getInstance().fromHightDensityPixel(100);
        int mdpi = DipUtils.getInstance().fromMediumDensityPixel(100);
        int ldpi = DipUtils.getInstance().fromLowDensityPixel(100);

        Log.e("TEST dubu pixel", String.format("pixel = %d", pixel));
        Log.e("TEST dubu dp", String.format("dp = %f", dp));

        Log.e("TEST dubu xhdpi", String.format("xhdpi = %d", xhdpi));
        Log.e("TEST dubu hdpi ", String.format("hdpi = %d", hdpi));
        Log.e("TEST dubu mdpi", String.format("mdpi = %d", mdpi));
        Log.e("TEST dubu ldpi", String.format("ldpi = %d", ldpi));
    }


    private View onCreateContextView() {
        RelativeLayout root = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
        root.setLayoutParams(params);

        Button button01 = new Button(this);
        params = new RelativeLayout.LayoutParams(DipUtils.getInstance().fromMediumDensityPixel(100)
                , DipUtils.getInstance().fromMediumDensityPixel(100));
        button01.setLayoutParams(params);
        button01.setId(ID_BUTTON01);
        button01.setText("fromMedium 100px");

        Button button02 = new Button(this);
        params = new RelativeLayout.LayoutParams(DipUtils.getInstance().fromHightDensityPixel(100)
                , DipUtils.getInstance().fromHightDensityPixel(100));
        params.addRule(RelativeLayout.RIGHT_OF, ID_BUTTON01);
        button02.setLayoutParams(params);
        button02.setId(ID_BUTTON02);
        button02.setText("fromHight 100px");

        Button button03 = new Button(this);
        params = new RelativeLayout.LayoutParams(DipUtils.getInstance().fromLowDensityPixel(100)
                , DipUtils.getInstance().fromLowDensityPixel(100));
        params.addRule(RelativeLayout.RIGHT_OF, ID_BUTTON02);
        button03.setId(ID_BUTTON03);
        button03.setLayoutParams(params);
        button03.setText("fromLow 100px");

        root.addView(button01);
        root.addView(button02);
        root.addView(button03);
        return root;
    }
}

package com.kingkongdubu.lecture.chap09;

import android.app.Activity;
import android.util.Log;

import java.lang.String;


/**
 * User: Administrator
 * Date: 13. 2. 8
 * Time: 오전 9:35
 */
public class DipUtils {

    // example Optimus G
    // density 320

    private float density;
    private static DipUtils instance;

    public static DipUtils getInstance(){
        if(instance == null){
            instance = new DipUtils();
        }
        return instance ;

    }

    public  void init(Activity activity){
         density = activity.getResources().getDisplayMetrics().density;
        int dpi = activity.getResources().getDisplayMetrics().densityDpi;
        Log.e("TEST dubu" , String.format("density = %f, dpi = %d",density,dpi));
    }

    public int DpToPixel(float dp){
        return (int)(dp *  density);
    }

    public float PixelToDp(int pixel) {

        return pixel/ density  ;
    }

    // 갤럭시 노트
    public int fromExtraHightDensityPixel(int pixel) {
        return (int)(pixel / (320/160.0f) * density) ;
    }

    // 갤럭시 S 1,2
    public int fromHightDensityPixel(int pixel) {
        return (int)(pixel / (240/160.0f) * density) ;
    }

    // 옵티머스 원
    public int fromMediumDensityPixel(int pixel) {
        return (int)(pixel / (160/160.0f) * density) ;
    }

    public int fromLowDensityPixel(int pixel) {
        return (int)(pixel / (120/160.0f) * density) ;
    }
}

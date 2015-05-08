package com.eibriel.reddot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.Date;
import java.util.Random;

public class DrawDot extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
    float centerX;
    float centerY;
    //float radius;

    public DrawDot(Context context) {
        super(context);
        paint.setColor(Color.RED);
        paint2.setColor(Color.rgb(150, 0, 0));
        //paint3.setColor(Color.rgb(80, 0, 0));
    }


    @Override
    public void onSizeChanged (int w, int h, int oldw, int oldh) {
        centerX = w/2;
        centerY = h/2;
    }


    private float timeToRadius(long milliTime) {
        long milliseconds4 = (milliTime % 1000000) / 100;
        double milli4_float = (milliseconds4 / 10000.0) * (6 * Math.PI) ;

        long milliseconds3 = (milliTime % 100000) / 10;
        double milli3_float = (milliseconds3 / 10000.0) * (6 * Math.PI) ;

        long milliseconds2 = milliTime % 10000;
        double milli2_float = (milliseconds2 / 10000.0) * (6 * Math.PI) ;

        long milliseconds = milliTime % 1000;
        double milli_float = (milliseconds / 1000.0) * (6 * Math.PI) ;

        double sine1 = Math.sin(milli_float);
        //sine1 = 0;
        double sine2 = Math.sin(milli2_float);
        double sine3 = Math.sin(milli3_float);
        double sine4 = Math.sin(milli4_float);

        double sine4_peak = sine4 - 0.5;
        if (sine4_peak < 0.0) {
            sine4_peak = 0.0;
        }

        float radius_ = 100 +
                ((float) sine1 * (3 * ((float)sine4_peak*10))) +
                ((float) sine2 * 5) +
                ((float) sine3 * 10) +
                ((float) sine4 * 30);
        //float radius_ = 100 + ((float)sine3 * 50 );

        //Log.d("TimerExample", "Going for... " + sine4_peak);
        return radius_;
    }



    @Override
    public void onDraw(Canvas canvas) {
        //canvas.drawLine(0, 0, 20, 20, paint);
        //canvas.drawLine(20, 0, 0, 20, paint);
        Random diceRoller = new Random();
        //radius = diceRoller.nextInt(100) + 100;

        Date time = new Date();
        //long rest = 14310300 * 100000;
        float radius = timeToRadius(time.getTime());
        //float radius2 = timeToRadius( time.getTime()-500);
        //float radius3 = timeToRadius( time.getTime()-1000);

        //Log.d("TimerExample", "Going for... " + milli2_float);
        //canvas.drawCircle(centerX, centerY, radius3, paint3);
        //canvas.drawCircle(centerX, centerY, radius2, paint2);
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

}
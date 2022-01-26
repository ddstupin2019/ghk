package com.example.paint20;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    static class DrawView extends View {
        ArrayList<Pathj> ref=new ArrayList<>();
        ArrayList<Path> ref1=new ArrayList<>();
        Float x1=0f, y1=0f;
        Float x, y ,tolshina=30f;
        Integer color=Color.RED;
        But but=new But();
        Paint paint;
        RectF rectf;
        Path path1;
        Path path2=new Path();
      static   Boolean v=false, last=false;
        public DrawView(Context context) {
            super(context);
            paint = new Paint();
            path1=new Path();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.YELLOW);
            canvas.drawCircle(100, 100, 90, paint);
            paint.setColor(Color.RED);
            canvas.drawCircle(300, 100, 90, paint);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(500, 100, 90, paint);
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(60);
            canvas.drawLine(700, 40, 700,170, paint);
            paint.setStrokeWidth(120);
            canvas.drawLine(900, 40, 900,170, paint);
            paint.setStrokeWidth(180);
            canvas.drawLine(1100, 40, 1100,170, paint);
            canvas.drawLine(1300, 40, 1300,140, paint);
            paint.setColor(Color.BLUE);
            canvas.drawLine(1300, 140, 1300,170, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(tolshina);
            paint.setColor(color);
            for (int i = 0; i < ref.size(); i++) {
               String a = ref.get(i).toString();
                Log.d("ty",a);
                Log.d("ty","оно работает");
                paint.setStrokeWidth(ref.get(i).tolshina);
                paint.setColor(ref.get(i).color);
               canvas.drawPath(ref.get(i).path,paint);
            }
            paint.setStrokeWidth(tolshina);
            paint.setColor(color);
            canvas.drawPath(path1,paint);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX();
            y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    color = but.color(x, y, color);
                    tolshina = but.Tolshina(x, y, tolshina);

                    if (!but.draw()) {
                        path1.moveTo(x, y);
                        path1.lineTo(x, y);
                        invalidate();
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (!v) {
                        Log.d("y", "1");
                        v = true;
                        path1.moveTo(x,y);
                    } else {
                        path1.lineTo(x, y);
                    }
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    Pathj pashj = new Pathj(color,tolshina,path1);
                    ref.add(pashj);
                    Log.d("ty","оно ");
                    v=false;
                    path1.reset();
                    break;
            }
        return true;
        }
    }
}
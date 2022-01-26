package com.example.paint20;

import android.graphics.Color;
import android.graphics.Path;
import android.provider.DocumentsContract;
import android.util.Log;

import java.security.PublicKey;

public class But {
static Boolean b=false;

    public static int color(float x, float y, int e) {
        if ((x - 100) * (x - 100) + (y - 100) * (y - 100) <= 8100) {
            Log.d("f", "yellow");
            b=true;
            return Color.YELLOW;
        } else if ((x - 300) * (x - 300) + (y - 100) * (y - 100) <= 8100) {
            b=true;
            return Color.RED;
        } else if ((x - 500) * (x - 500) + (y - 100) * (y - 100) <= 8100) {
            Log.d("f", "blue");
            b=true;
            return Color.BLUE;
        }
        if (x < 1390 && x > 1210 && y < 170 && y > 40) {
            b=true;
            return Color.WHITE;
        }
        b=false;
        return e;
    }

    public static float Tolshina(float x, float y, float e) {
        if (x < 730 && x > 670 && y < 170 && y > 40) {
            b=true;
            return 30;
        } else if (x < 960 && x > 840 && y < 170 && y > 40) {
            b=true;
            return 60;
        } else if (x < 1190 && x > 1010 && y < 170 && y > 40) {
            b=true;
            return 90;
        }
        b=false;
        return e;

    }
    public static boolean draw(){
        return b;
    }
}



package com.example.paint20;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Pathj {
    int color;
    float tolshina;
    Path path;

    public Pathj(int color, float tolshina, Path path) {
        this.color = color;
        this.tolshina = tolshina;
        this.path = path;
    }
    public Pathj(Pathj p) {
        p.color = color;
        p.tolshina = tolshina;
        p.path = path;
    }

    @Override
    public String toString() {
        return "Pathj{" +
                "color=" + color +
                ", tolshina=" + tolshina +
                ", path=" + path +
                '}';
    }
}

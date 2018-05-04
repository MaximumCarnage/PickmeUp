package com.bruton.pickmeup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Enemy {
    //TODO: clean up, add base class

    private Bitmap sprite;
    private int x,y;
    private int vx,vy;

    private final int GRAVITY = -60;

    private int minY;
    private int maxY;

    private int minX;
    private int maxX;

    private int speed = 1;

    public Enemy(Context context, int screenW,int screenH){
        sprite = BitmapFactory.decodeResource(context.getResources(), R.drawable.toastplayer);

        minX = 0;
        maxX = screenW;

        minY = 0;
        maxY = screenH - sprite.getHeight() - 70;

        x = maxX;
        y = maxY;

        if(y >maxY) {
            y = maxY;
        }

    }

    public void update(){
        y -= GRAVITY;

        if(y >maxY) {
            y = maxY;
        }

        if(x > minX - sprite.getWidth()){
            x = x - speed;
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Bitmap getSprite(){
        return sprite;
    }
}

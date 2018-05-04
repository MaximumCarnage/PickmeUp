package com.bruton.pickmeup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public abstract class GameObject {

    private Vector2D m_worldLocation;
    private float m_width;
    private float m_height;

    private boolean m_active = true;
    private boolean m_wisible = true;

    private int m_animFrameCount = 1;
    private char m_type;

    private String m_spriteName;

    public abstract void update(long fps, float gravity);

    public String getSpriteName(){
        return m_spriteName;
    }

    public Bitmap prepareSprite(Context context, String spriteName, int speed){
        int resID = context.getResources().getIdentifier(spriteName, "drawable", context.getPackageName());

        Bitmap sprite = BitmapFactory.decodeResource(context.getResources(),resID);

        return sprite;
    }

    public Vector2D getWorldlocation(){
        return m_worldLocation;
    }

    public void setworldLocation(float x, float y, int z){
        m_worldLocation = new Vector2D();
        m_worldLocation.x = x;
        m_worldLocation.y = y;
        m_worldLocation.z = z;

    }

    public void setSpriteName(String spriteName){
        m_spriteName = spriteName;
    }

    public float getWidth(){
        return m_width;
    }

    public void setWidth(float width){
        m_width = width;
    }

    public float getHeight(){
        return m_height;
    }

    public void setHeight(float height){
        m_height = height;
    }

    public boolean isActive(){
        return m_active;
    }
    public void setActive(boolean active){
        m_active = active;
    }


    public boolean isVisible(){
        return m_wisible;
    }
    public void setVisible(boolean visible){
         m_wisible = visible;
    }

    public char getType(){
        return m_type;
    }

    public void setType(char type){
         m_type = type;
    }





}

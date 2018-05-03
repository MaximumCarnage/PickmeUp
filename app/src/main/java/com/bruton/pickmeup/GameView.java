package com.bruton.pickmeup;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {
    private volatile boolean m_playing;
    private Thread m_gameThread = null;

    public GameView(Context context){
        super(context);
    }

    @Override
    public void run(){
        while(m_playing){
            update();
            draw();
            control();
        }

    }

    private void update(){

    }

    private void draw(){

    }
    private void control(){

    }


    public void pause(){
        m_playing = false;
        try {
            m_gameThread.join();
        } catch(InterruptedException e){
           Log.d("error in GameView.Java - Pause", e.getMessage());
        }
    }
    public void resume(){
        m_playing = true;
        m_gameThread = new Thread(this);
        m_gameThread.start();
    }
}

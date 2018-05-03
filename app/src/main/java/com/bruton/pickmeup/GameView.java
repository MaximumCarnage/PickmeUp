package com.bruton.pickmeup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    private volatile boolean m_playing;
    private Thread m_gameThread = null;
    private Player m_player;

    private Paint m_paint;
    private Canvas m_canvas;
    private SurfaceHolder m_holder;

    public GameView(Context context){
        super(context);

        m_holder = getHolder();
        m_paint = new Paint();

        m_player = new Player(context);
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
        m_player.update();
    }

    private void draw(){
        if(m_holder.getSurface().isValid()) {
            m_canvas = m_holder.lockCanvas();

            m_canvas.drawColor(Color.argb(255,0,0,0));

            m_canvas.drawBitmap(m_player.getSprite(), m_player.getX(),m_player.getY(),m_paint);

            m_holder.unlockCanvasAndPost(m_canvas);
        }
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

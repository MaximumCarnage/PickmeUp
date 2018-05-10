package com.bruton.pickmeup;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;


public class SoundManager {

    private SoundPool m_soundPool;
    int m_jumpSound = -1;

    public void loadSounds(Context context) {
        m_soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0 );
        try {
            AssetManager assetManager = context.getAssets();
            AssetFileDescriptor descriptor;

            descriptor = assetManager.openFd("jump.ogg");
            m_jumpSound = m_soundPool.load(descriptor, 0);

        } catch(IOException e){
            Log.e("error", "Failed to load sound" );

        }
    }

    public void playSound(String sound){
        switch(sound){
            case "jump":
                m_soundPool.play(m_jumpSound,1,1,0,0,0);
                break;
        }
    }
}

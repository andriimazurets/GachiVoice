package com.mazurets.gachivoice

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonIds = (1..21).map { resources.getIdentifier("button_voice$it", "id", packageName) }
        val mediaPlayerIds = (1..21).map { resources.getIdentifier("volume$it", "raw", packageName) }
        val buttons = buttonIds.map { findViewById<Button>(it) }
        val mediaPlayers = mediaPlayerIds.map { MediaPlayer.create(this, it) }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                mediaPlayers[index].start()
            }
        }

    }
}


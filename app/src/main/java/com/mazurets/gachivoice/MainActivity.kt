package com.mazurets.gachivoice

import android.graphics.Color
import android.media.MediaPlayer
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.mazurets.gachivoice.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val buttonIds = (1..21).map { resources.getIdentifier("button_voice$it", "id", packageName) }
        val mediaPlayerIds = (1..21).map { resources.getIdentifier("volume$it", "raw", packageName) }
        val buttons = buttonIds.map { findViewById<Button>(it) }
        val mediaPlayers = mediaPlayerIds.map { MediaPlayer.create(this, it) }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                mediaPlayers[index].start()
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                binding.textMainText.text = "G"
                delay(1000L)
                binding.textMainText.text = "GA"
                delay(1000L)
                binding.textMainText.text = "GAC"
                delay(1000L)
                binding.textMainText.text = "GACH"
                delay(1000L)
                binding.textMainText.text = "GACHI"
                delay(1000L)
                binding.textMainText.text = "GACHI V"
                delay(1000L)
                binding.textMainText.text = "GACHI VO"
                delay(1000L)
                binding.textMainText.text = "GACHI VOI"
                delay(1000L)
                binding.textMainText.text = "GACHI VOIC"
                delay(1000L)
                binding.textMainText.text = "GACHI VOICE"
                delay(1000L)
                binding.textMainText.text = ""
            }
        }
    }
}


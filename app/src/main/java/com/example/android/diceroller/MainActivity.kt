/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var imagenMoneda : ImageView
    private lateinit var coinAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagenMoneda = findViewById<ImageView>(R.id.imagenDado).apply {
            setBackgroundResource(R.drawable.ic_goldbitcoin)
        }

        val botontirar : Button = findViewById(R.id.boton_tirar)
        botontirar.setOnClickListener {
            imagenMoneda = findViewById<ImageView>(R.id.imagenDado).apply {
                setBackgroundResource(flipCoin())
                coinAnimation = background as AnimationDrawable
            }
            coinAnimation.stop()
            coinAnimation.start()
        }
    }
    override fun onRestart() {
        super.onRestart()
        imagenMoneda = findViewById<ImageView>(R.id.imagenDado).apply {
            setBackgroundResource(R.drawable.ic_goldbitcoin)
        }
    }


    private fun flipCoin(): Int {
        val recursoImagen = when (Random().nextInt(2) + 1) {
            1 -> R.drawable.coin_animation_down
            else -> R.drawable.coin_animation_up
        }
        return recursoImagen
    }


}

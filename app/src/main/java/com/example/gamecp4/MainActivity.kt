package com.example.gamecp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var batu1 : ImageView
    lateinit var batu2 : ImageView
    lateinit var kertas1 : ImageView
    lateinit var kertas2 : ImageView
    lateinit var gunting1 : ImageView
    lateinit var gunting2 : ImageView
    lateinit var hasilSuit : ImageView

    // -1 kosong, 0 batu, 1 kertas, 2 gunting
    var Terpilih1 = -1
    var Terpilih2 = -1

    val batu = 0
    val kertas = 1
    val gunting = 2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batu1 = findViewById<ImageView>(R.id.batu1)
        batu2 = findViewById<ImageView>(R.id.batu2)
        kertas1 = findViewById<ImageView>(R.id.kertas1)
        kertas2 = findViewById<ImageView>(R.id.kertas2)
        gunting1 = findViewById<ImageView>(R.id.gunting1)
        gunting2 = findViewById<ImageView>(R.id.gunting2)

        hasilSuit = findViewById<ImageView>(R.id.tlstengah)

        val refresh = findViewById<ImageView>(R.id.refresh)

        batu1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Batu 1 Terpilih")
            selectViewPertama(batu1, pilihan = 0)
        }

        kertas1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Kertas 1 Terpilih")
            selectViewPertama(kertas1, pilihan = 1)
        }

        gunting1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Gunting 1 Terpilih")
            selectViewPertama(gunting1, pilihan = 2)
        }

        batu2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Batu 2 Terpilih")
            selectViewKedua(batu2, pilihan = 0)
        }

        kertas2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Kertas 2 Terpilih")
            selectViewKedua(kertas2, pilihan = 1)
        }

        gunting2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Gunting 2 Terpilih")
            selectViewKedua(gunting2, pilihan = 2)
        }

        refresh.setOnClickListener {
            clearVIewPertama()
            clearVIewKedua()
            hasilSuit.setBackgroundResource(R.drawable.vs)
        }
    }

    private fun selectViewPertama(view: ImageView, pilihan: Int) {
        Terpilih1 = pilihan
        clearVIewPertama()
        view.setImageResource(R.drawable.ic_check)
        hasilSuit()
    }
    private fun selectViewKedua(view: ImageView, pilihan: Int) {
        Terpilih2 = pilihan
        clearVIewKedua()
        view.setImageResource(R.drawable.ic_check)
        hasilSuit()
    }
    private fun clearVIewPertama() {
        batu1.setImageResource(0)
        kertas1.setImageResource(0)
        gunting1.setImageResource(0)
    }
    private fun clearVIewKedua() {
        batu2.setImageResource(0)
        kertas2.setImageResource(0)
        gunting2.setImageResource(0)

    }

    private fun hasilSuit() {
        if(Terpilih1 >=0 && Terpilih2 >=0) {
            if (Terpilih1 == batu && Terpilih2 == gunting || Terpilih1 == kertas && Terpilih2 == batu || Terpilih1 == gunting && Terpilih2 == kertas) {
                hasilSuit.setBackgroundResource(R.drawable.p1menang);
            } else if (Terpilih1 == batu && Terpilih2 == kertas || Terpilih1 == kertas && Terpilih2 == gunting || Terpilih1 == gunting && Terpilih2 == batu) {
                hasilSuit.setBackgroundResource(R.drawable.p2menang);
            } else if (Terpilih1 == batu && Terpilih2 == batu || Terpilih1 == kertas && Terpilih2 == kertas || Terpilih1 == gunting && Terpilih2 == gunting) {
                hasilSuit.setBackgroundResource(R.drawable.draw);
            }
        }
    }
}
package kr.ac.kopo.buttonevent0314

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btn : Button
    lateinit var btnHome : Button
    lateinit var btn911 : Button
    lateinit var btnGallery : Button
    lateinit var btnFinish : Button
    lateinit var btnListner : View.OnClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        btn=findViewById(R.id.button)
        btnHome=findViewById(R.id.buttonHome)
        btn911=findViewById(R.id.button911)
        btnGallery=findViewById(R.id.buttonGallery)
        btnFinish=findViewById(R.id.buttonFinish)
        btnListner=View.OnClickListener{
            when(it.id){
                R.id.buttonHome -> intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kopo.ac.kr/jungsu/index.do"))
                R.id.button911 ->   intent=Intent(Intent.ACTION_VIEW, Uri.parse("   tel:/911"))
                R.id.buttonGallery ->intent=Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"))
            }
            startActivity(intent)
        }
        btnHome.setOnClickListener { btnListner }
        btn911.setOnClickListener { btnListner }
        btnGallery.setOnClickListener { btnListner }

        btnFinish.setOnClickListener {
          finish()
        }


        btn.setOnClickListener {
            Toast.makeText(applicationContext,"기분좋은 오후입니다.",Toast.LENGTH_SHORT).show()
        }
    }
}
package a.fp.first

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private fun goToNextActivity(){
        val intent = Intent(this, NextActivity::class.java)
        Handler().postDelayed({ startActivity(intent) }, 200)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RxView
                .clicks(nextBtn)
                .throttleFirst(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { goToNextActivity() }

        loadBtn.setOnClickListener {
            Thread.sleep(10000)
            textView.text = "ロードしたつもり"
        }

        resetBtn.setOnClickListener{
            textView.text = "リセットした"
        }

    }
}

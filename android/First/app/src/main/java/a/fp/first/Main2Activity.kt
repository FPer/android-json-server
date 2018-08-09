package a.fp.first

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.concurrent.TimeUnit

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        /*
            .throttleFirstと.throttleLastの違いを体感しよう！
         */
        RxBottomNavigationView
                .itemSelections(navigation)
                .throttleFirst(1000, TimeUnit.MILLISECONDS)
//                .throttleLast(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    when (it.itemId) {
                        R.id.navigation_home -> {
                            message.setText(R.string.title_home)
                        }
                        R.id.navigation_dashboard -> {
                            message.setText(R.string.title_dashboard)
                        }
                        R.id.navigation_notifications -> {
                            message.setText(R.string.title_notifications)
                        }
                    }
                }

    }
}

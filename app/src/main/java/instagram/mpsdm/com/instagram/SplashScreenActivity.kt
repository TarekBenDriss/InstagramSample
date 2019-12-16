package instagram.mpsdm.com.instagram

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.WindowManager
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class SplashScreenActivity : AppCompatActivity() {


    private var preferences: SharedPreferences? = null

    internal var mSharedPreference: SharedPreferences? = null


    private val SPLASH_DISPLAY_LENGTH = 2500


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        setContentView(R.layout.activity_splash_screen)

        preferences = PreferenceManager.getDefaultSharedPreferences(this)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        Handler().postDelayed({
            /* Create an Intent that will start the landing-Activity. */
            val mainIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            val loginIntent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            //val patientIntent = Intent(this@SplashScreenActivity, PatientMainActivity::class.java)
            //val medecinIntent = Intent(this@SplashScreenActivity, MedecinDashboardActivity::class.java)

            startActivity(mainIntent)
            /*
            if (preferences!!.getBoolean(Constants.IS_LOGGED_IN, false) == false)
                this@SplashScreenActivity.startActivity(mainIntent)
            else {
                if (preferences!!.getString(Constants.ROLE, "") == Constants.PATIENT)
                    this@SplashScreenActivity.startActivity(patientIntent)
                else
                    this@SplashScreenActivity.startActivity(medecinIntent)
            }
             */
            this.finish()
            //this@SplashScreenActivity.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())


    }


}

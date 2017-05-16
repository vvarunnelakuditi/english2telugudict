package com.example.venkatavarun.english2telugu;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;


public class SplashScreen extends Activity {
    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Make sure this is before calling super.onCreate
       // setTheme(R.style.splashScreenTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        new BackgroundSplashTask().execute();
//        final Handler handler = new Handler();
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent mainIntent = new Intent(SplashActivity.this,
//                        Login.class);
//                SplashActivity.this.startActivity(mainIntent);
//                SplashActivity.this.finish();
//                handler.removeCallbacks(this);
//            }
//        }, SPLASH_DISPLAY_LENGTH);

    }

    private class BackgroundSplashTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                Thread.sleep(SPLASH_DISPLAY_LENGTH);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Intent i = new Intent(SplashScreen.this,MainActivity.class);
            // any info loaded can during splash_show
            // can be passed to main activity using
            // below
            i.putExtra("loaded_info", " ");
            startActivity(i);
//            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

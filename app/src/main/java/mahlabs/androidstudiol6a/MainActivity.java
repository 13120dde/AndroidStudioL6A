package mahlabs.androidstudiol6a;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvColor, tvColor2;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiateComponents();
        addListener();

    }

    private void addListener() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ColorChanger().execute();
            }
        });
    }

    private void instantiateComponents() {
        tvColor = (TextView) findViewById(R.id.tvColor);
        tvColor2 = (TextView) findViewById(R.id.tvColor2);
        btnStart= (Button) findViewById(R.id.btnStart);

    }

    private class ColorChanger extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... integers) {

            Random rng = new Random();
            int color = Color.argb(255, rng.nextInt(256),rng.nextInt(256),rng.nextInt(256));
            publishProgress(color);
            try {
                Thread.sleep(3000);
                publishProgress(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            changeBackground(values);
            super.onProgressUpdate(values);
        }


    }

    private void changeBackground(Integer[] values) {
        tvColor.setBackgroundColor(values[0]);
        tvColor2.setBackgroundColor(values[0]);
    }


}

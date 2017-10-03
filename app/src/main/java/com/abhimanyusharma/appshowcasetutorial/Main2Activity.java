package com.abhimanyusharma.appshowcasetutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class Main2Activity extends AppCompatActivity {

    Button button4, button5;
    ShowcaseView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button4 = (Button) findViewById(R.id.b4);
        button5 = (Button) findViewById(R.id.b5);

        Target target4 = new ViewTarget(R.id.b4, this);

        sv = new ShowcaseView.Builder(this)
                .setTarget(target4)
                .setContentTitle("Save and add more")
                .setContentText("Click to save data and add more")
                //.hideOnTouchOutside()//this will hide the tutorial on touch outsuide
                .build();
        sv.setStyle(R.style.CustomShowcaseTheme5);
        sv.setButtonText("Next");

        final Target target5 = new ViewTarget(R.id.b5, this);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        sv.overrideButtonClick(new View.OnClickListener() {
            int count1 = 0;

            @Override
            public void onClick(View v) {
                count1++;
                switch (count1) {

                    case 1:
                        sv.setTarget(target5);
                        sv.setContentTitle("Save and Exit");
                        sv.setStyle(R.style.CustomShowcaseTheme6);
                        sv.setContentText("Click to save data and exit to main menu");
                        sv.setButtonText("Finish");
                        break;

                    case 2:

                        sv.hide();
                        break;

                }
            }
        });
    }

}

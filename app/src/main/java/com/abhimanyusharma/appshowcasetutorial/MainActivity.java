package com.abhimanyusharma.appshowcasetutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3;
    private TextView t1;
    private ShowcaseView scv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.b1);
        button2 = (Button) findViewById(R.id.b2);
        button3 = (Button) findViewById(R.id.b3);
        t1 = (TextView) findViewById(R.id.textView);

        showcaseDialogTutorial();

//        Target target1 = new ViewTarget(R.id.b1, this);
//
//        new ShowcaseView.Builder(this)
//                .setTarget(target1)
//                .setContentTitle("Button1")
//                .setContentText("Tap here to Logout")
//                .hideOnTouchOutside()
//                .build();
//
//        Target target2 = new ViewTarget(R.id.b2, this);
//
//        new ShowcaseView.Builder(this)
//                .setTarget(target2)
//                .setContentTitle("Button 2")
//                .setContentText("Tap here to create")
//                .hideOnTouchOutside()
//                .build();
//
//        Target target3 = new ViewTarget(R.id.b3, this);
//
//        new ShowcaseView.Builder(this)
//                .setTarget(target3)
//                .setContentTitle("Button 3")
//                .setContentText("Tap here for fun")
//                .hideOnTouchOutside()
//                .build();
//
//
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                //finish();
            }
        });
    }

    private void showcaseDialogTutorial() {
        final SharedPreferences tutorialShowcases = getSharedPreferences("showcaseTutorial", MODE_PRIVATE);

        boolean run;

        run = tutorialShowcases.getBoolean("run?", true);

        if (run) {//If the buyer already went through the showcases it won't do it again.
            final Target  v1= new ViewTarget(R.id.b1, this);//Variable holds the item that the showcase will focus on.
            final ViewTarget  v2= new ViewTarget(R.id.b2, this);
            final ViewTarget  v3= new ViewTarget(R.id.b3, this);
            final Target  v4= new ViewTarget(R.id.textView, this);
//            final ViewTarget  v5= new ViewTarget(R.id., this);
//            final ViewTarget  = new ViewTarget(R.id., this);
//            final ViewTarget  = new ViewTarget(R.id., this);
//            final ViewTarget  = new ViewTarget(R.id., this);
//            final ViewTarget  = new ViewTarget(R.id., this);
//            final ViewTarget  = new ViewTarget(R.id., this);
//            final ViewTarget  = new ViewTarget(R.id., this);


//            //This code creates a new layout parameter so the button in the showcase can move to a new spot.
//            final RelativeLayout.LayoutParams lps = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            // This aligns button to the bottom left side of screen
//            lps.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//            lps.addRule(RelativeLayout.CENTER_IN_PARENT);
//            // Set margins to the button, we add 16dp margins here
//            int margin = ((Number) (getResources().getDisplayMetrics().density * 16)).intValue();
//            lps.setMargins(margin, margin, margin, margin);

            //This creates the first showcase.
            scv = new ShowcaseView.Builder(this)
                    .setTarget(v1)
                    .setContentTitle("Button 1")
                    .setContentText("Sample Demo Button")
                    .build();
            scv.setStyle(R.style.CustomShowcaseTheme3);
            scv.setButtonText("next");


            //When the button is clicked then the switch statement will check the counter and make the new showcase.
            scv.overrideButtonClick(new View.OnClickListener() {
                int count1 = 0;

                @Override
                public void onClick(View v) {
                    count1++;
                    switch (count1) {

                        case 1:
                            scv.setTarget(v2);
                            scv.setContentTitle("Button 2");
                            scv.setStyle(R.style.CustomShowcaseTheme);
                            scv.setContentText("Sample Demo Button");
                            scv.setButtonText("next");
                            break;

                        case 2:
                            scv.setTarget(v3);
                            scv.setContentTitle("Button 3");
                            scv.setStyle(R.style.CustomShowcaseTheme2);
                            scv.setContentText("Sample Demo Button");
                            scv.setButtonText("next");
                            break;

                        case 3:
                            scv.setTarget(v4);
                            scv.setContentTitle("Button 4");
                            scv.setStyle(R.style.CustomShowcaseTheme3);
                            scv.setContentText("Sample Demo Button");
                            scv.setButtonText("finish");

                            break;
                        case 4:
                            SharedPreferences.Editor tutorialShowcasesEdit = tutorialShowcases.edit();
                            tutorialShowcasesEdit.putBoolean("run?", false);
                            tutorialShowcasesEdit.apply();

                            scv.hide();
                            break;

                    }
                }
            });
        }
    }
}
//ShowcaseView ShowCase = new ShowcaseView.Builder(this)
//        .withMaterialShowcase()
//        .setTarget()
//        .setContentTitle("")
//        .setContentText("")
//        .setStyle(R.style.CustomShowcaseTheme2)
//        .build();
//        ShowCase.setButtonText("next");
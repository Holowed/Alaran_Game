package pl.alaran.pe.summon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import pl.alaran.pe.R;

public class SummonActivity extends AppCompatActivity {
    private ImageView wrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_summon);

        Button basicSummon = findViewById(R.id.basicSummon);
        Button premiumSummon = findViewById(R.id.premiumSummon);
        Button multiSummon = findViewById(R.id.multiSummon);
        wrapper = findViewById(R.id.wrapper);

        basicSummon.setOnClickListener(v -> {
            addText();
        });
        premiumSummon.setOnClickListener(v -> {
            addText();
        });
        multiSummon.setOnClickListener(v -> {
            addText();
        });
    }

    private void addText() {
        /* Get random item summon and get its picture id */
        int rand = new Random().nextInt(4)+1;
        ImageView picture = findViewById(R.id.wrapper);
        String pic_name = (String)("item_"+rand);
        Resources resources = this.getResources();
        int pic_id = resources.getIdentifier(pic_name.toLowerCase(), "drawable",this.getPackageName());

        wrapper.setImageResource(pic_id);

        ConstraintLayout layout = findViewById(R.id.summonActivity);
        ArrayList<View> layoutButtons = layout.getTouchables();
        /* Disable buttons */

        for(View v : layoutButtons){
            if( v instanceof Button ) {
                v.setEnabled(false);
            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wrapper.setImageResource(0);
                for(View v : layoutButtons){
                    if( v instanceof Button ) {
                        v.setEnabled(true);
                    }
                }
            }
        }, 2000);
    }
}
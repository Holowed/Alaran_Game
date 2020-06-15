package pl.alaran.pe.team;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pl.alaran.pe.GameRoomDatabase;
import pl.alaran.pe.R;
import pl.alaran.pe.character.Character;
import pl.alaran.pe.character.CharacterViewModel;

public class TeamActivity extends AppCompatActivity {

    private CharacterViewModel characterViewModel;
    private Character[] characters;
    private int curr_char;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_team);

        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel.class);
        characters = characterViewModel.getAllCharacters();
        curr_char=0;
        setCharacterVals(0);
        ImageButton next = findViewById(R.id.button_next);
        ImageButton prev = findViewById(R.id.button_prev);
        next.setOnClickListener( v -> {
            setCharacterVals(curr_char+1);
        });
        prev.setOnClickListener( v-> {
            setCharacterVals(curr_char-1);
        });
    }

    @SuppressLint("SetTextI18n")
    private void setCharacterVals(int id) {
        if(id>characters.length-1) id=0;
        else if(id<0) id=characters.length-1;
        curr_char = id;
        ImageView picture = findViewById(R.id.character_preview);
        String pic_name = (String)(characters[id].getName()+"_"+characters[id].getForm());
        Resources resources = this.getResources();
        int pic_id = resources.getIdentifier(pic_name.toLowerCase(), "drawable",this.getPackageName());
        picture.setImageResource(pic_id);
        Log.i("OBRAZEK",pic_name);
        TextView name = findViewById(R.id.character_stats_name);
        TextView level = findViewById(R.id.character_stats_level);
        TextView exp = findViewById(R.id.character_stats_exp);
        TextView form = findViewById(R.id.character_stats_form);
        TextView attack = findViewById(R.id.character_stats_attack);
        TextView defense = findViewById(R.id.character_stats_defense);
        TextView health = findViewById(R.id.character_stats_health);
        TextView accuracy = findViewById(R.id.character_stats_accuracy);
        TextView dodge = findViewById(R.id.character_stats_dodge);
        TextView critical_hit = findViewById(R.id.character_stats_critical_hit);
        name.setText(characters[id].getName());
        level.setText(Integer.toString(characters[id].getLevel()));
        exp.setText(Integer.toString(characters[id].getExp()));
        form.setText(Integer.toString(characters[id].getForm()));
        attack.setText(Integer.toString(characters[id].getAttack()));
        defense.setText(Integer.toString(characters[id].getDefense()));
        health.setText(Integer.toString(characters[id].getHealth()));
        accuracy.setText((int) characters[id].getAccuracy()*100 +" %");
        dodge.setText((int) characters[id].getDodge()*100 +" %");
        critical_hit.setText((int) characters[id].getCritical_chance()*100 +" %");
    }

}
package pl.alaran.pe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import pl.alaran.pe.character.Character;
import pl.alaran.pe.character.CharacterViewModel;
import pl.alaran.pe.fight.FightActivity;
import pl.alaran.pe.summon.SummonActivity;
import pl.alaran.pe.team.TeamActivity;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();
    private CharacterViewModel characterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button summon_button = findViewById(R.id.summon);
        Button fight_button = findViewById(R.id.fight);
        Button team_button = findViewById(R.id.team);
        ImageButton settings_button = findViewById(R.id.settings);
    /*
        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel.class);


        Character character = new Character(null,true,"Cynthia",5,10,7,50,200,40,0.8,0.3,0.3,1.6);
        characterViewModel.insert(character);
        character = new Character(null,true,"Mira",1,5,1,40,250,30,0.9,0.5,0.7,1.9);
        characterViewModel.insert(character);
        character = new Character(null,true,"Cantarella",2,40,5,70,300,50,0.4,0.6,0.3,1.1);
        characterViewModel.insert(character);
        character = new Character(null,false,"Armin",1,10,3,50,400,70,0.5,0.8,0.2,1.2);
        characterViewModel.insert(character);
*/

        summon_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, SummonActivity.class);
            startActivity(intent);
        });
        fight_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, FightActivity.class);
            startActivity(intent);
        });
        team_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, TeamActivity.class);
            startActivity(intent);
        });
        settings_button.setOnClickListener(v -> {
            ImageView leader = findViewById(R.id.leader);
            leader.setImageResource(R.drawable.armin_2);
        });
    }
}
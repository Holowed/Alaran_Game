package pl.alaran.pe.fight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.alaran.pe.R;
import pl.alaran.pe.character.Character;
import pl.alaran.pe.character.CharacterViewModel;

public class FightActivity extends AppCompatActivity {

    private CharacterViewModel characterViewModel;
    private Character character;
    private int[] monster;
    private int Character_current_health;
    private int Monster_current_health;
    List<String> logs;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fight);

        logs = new ArrayList<String>();
        monster = new int[3];
        arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, logs);
        ListView fight_log = findViewById(R.id.fight_log);
        fight_log.setAdapter(arrayAdapter);
        fight_log.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel.class);
        character = characterViewModel.getCharacter(1);
        setCharacterVals();
        generateMonster();

    }


    @SuppressLint("SetTextI18n")
    private void generateMonster() {
        TextView health = findViewById(R.id.monster_stats_health);
        TextView attack = findViewById(R.id.monster_stats_attack);
        TextView defense = findViewById(R.id.monster_stats_defense);
        final int min = 20;
        final int max = 50;
        monster[0] = new Random().nextInt(max) + min;
        monster[1] = new Random().nextInt(max) + min;
        monster[2] = new Random().nextInt(max) + min;
        health.setText(Integer.toString(monster[0]));
        attack.setText(Integer.toString(monster[1]));
        defense.setText(Integer.toString(monster[2]));
    }
    private void turn() {
        do{
            if(attack(1)==2)
            {
                arrayAdapter.add("Gracz zwyciężył!");
                break;
            }
            if(attack(-1)==1)
            {
                arrayAdapter.add("Gracz przegrał!");
                break;
            }
        }while(Monster_current_health>0 && Character_current_health>0);


    }
    private int attack(int side) {
        if(side==1) {
            Monster_current_health = Monster_current_health-(Math.abs(character.getAttack()-monster[2]));
            arrayAdapter.add("Gracz zadał Goblinowi "+(Math.abs(character.getAttack()-monster[2])+" obrażen!"));
        } else {
            Character_current_health = Character_current_health-(Math.abs(monster[1]-character.getDefense()));
            arrayAdapter.add("Goblin zadał Graczowi "+(Math.abs(monster[1]-character.getDefense())) + " obrażen!");
        }
        if(Character_current_health<=0) return 1;
        else if(Monster_current_health<=0) return 2;
        return 0;
    }
    public void startFight(View view) {
        generateMonster();
        Character_current_health = character.getHealth();
        Monster_current_health = monster[0];
        Button start_fight = findViewById(R.id.start_fight);
        start_fight.setEnabled(false);
        arrayAdapter.add("<--- POCZĄTEK WALKI --->");
        turn();
        arrayAdapter.add("<--- KONIEC WALKI --->");


        start_fight.setEnabled(true);
    }
    @SuppressLint("SetTextI18n")
    private void setCharacterVals() {
        TextView name = findViewById(R.id.fight_character_name);
        TextView level = findViewById(R.id.fight_character_level);
        TextView health = findViewById(R.id.fight_character_health);
        TextView attack = findViewById(R.id.fight_character_attack);
        TextView defense = findViewById(R.id.fight_character_defense);
        name.setText(character.getName());
        level.setText(Integer.toString(character.getLevel()));
        attack.setText(Integer.toString(character.getAttack()));
        defense.setText(Integer.toString(character.getDefense()));
        health.setText(Integer.toString(character.getHealth()));
    }
}
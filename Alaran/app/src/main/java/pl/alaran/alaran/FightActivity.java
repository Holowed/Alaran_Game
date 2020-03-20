package pl.alaran.alaran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import pl.alaran.alaran.Character;

public class FightActivity extends AppCompatActivity {
    TextView FightLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        FightLog = (TextView) findViewById(R.id.Log);
        FightLog.setMovementMethod(new ScrollingMovementMethod());
    }

    public void Fight(View v){
        FightLog.setText("");
        Integer Eina[10] = {
            toInteger().findViewById(R.id.Attacker_lvl),

        };



        FightLog.append("---- ROZPOCZĘTO WALKĘ ----- \n");
        int i = 0;
        while(Defender.get(1)>0 && Attacker.get(1)>0)
        {
            FightLog.append("Runda " + i+1 + " \n");
            attack(Attacker,Defender);
            if(Defender.get(1)<0 || Attacker.get(1)<0) break;
            attack(Defender,Attacker);
            i++;
        }

        FightLog.append("---- ZAKONCZONO WALKĘ ----- \n");
        //FightLog.append("" + rand_res);
    }
    private void attack(List<Integer> Attacker, List<Integer> Defender)
    {
        Random generator = new Random();
        int rand_res;
        rand_res = generator.nextInt(100) + 1;
        String att;
        String def;
        if(Attacker.get(5) == 1)
        {
            att = "Eina";
            def = "Hanta";
        }
        else
        {
            att = "Hanta";
            def = "Eina";
        }
        if(Attacker.get(4) >= rand_res)
        {
            rand_res = generator.nextInt(100) + 1;
            if(Defender.get(3) >= rand_res)
            {
                FightLog.append(def + " wykonał unik! \n");
            }
            else
            {
                int Def_HP = Defender.get(1);
                int Def_DEF = Defender.get(2);
                int Att_AT = Attacker.get(0);

                Def_HP = Def_HP-(Att_AT-Def_DEF);
                Defender.set(1,Def_HP);
                FightLog.append(att + " zadał " + (Att_AT-Def_DEF) + " obrazeń! \n");
                FightLog.append(def + " pozostało " + Def_HP + " punktów życia! \n");
            }
        }
        else
        {
            FightLog.append(att + " spudłował! \n");
        }
    }
    private int getInt(int id)
    {
        EditText temp = findViewById(id);
        String ts =  temp.getText().toString();
        int value=0;
        if (!ts.isEmpty()){
        value=Integer.parseInt(ts);
        }
        return value;
    }
}

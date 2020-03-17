package pl.alaran.alaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void SummonActivitiy(View v){
        startActivity(new Intent(MainActivity.this, SummonActivity.class));
    }
    public void FightActivity(View v){
        startActivity(new Intent(MainActivity.this, FightActivity.class));
    }
}

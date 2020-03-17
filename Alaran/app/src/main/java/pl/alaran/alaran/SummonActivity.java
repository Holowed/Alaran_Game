package pl.alaran.alaran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summon);

        /* BUTTONS LISTENERS */
        final Button summon = (Button)findViewById(R.id.summon_Lysy);
        final Button summon2 = (Button)findViewById(R.id.summon_Ari);
        summon.setOnClickListener(new View.OnClickListener()
        {
            int res_arr[] = {0,0,0,0,0};
            int counter = 0;
            @Override
            public void onClick(View v)
            {
                counter++;
                TextView result = (TextView)findViewById(R.id.result_Lysy);
                TextView one = (TextView)findViewById(R.id.one_Lysy);
                TextView two = (TextView)findViewById(R.id.two_Lysy);
                TextView three = (TextView)findViewById(R.id.three_Lysy);
                TextView four = (TextView)findViewById(R.id.four_Lysy);
                TextView five = (TextView)findViewById(R.id.five_Lysy);
                TextView times = (TextView)findViewById(R.id.counter_Lysy);
                Random temp = new Random();
                int res = temp.Generate(1);

                switch (res)
                {
                    case 1:
                        res_arr[0]++;
                        break;
                    case 2:
                        res_arr[1]++;
                        break;
                    case 3:
                        res_arr[2]++;
                        break;
                    case 4:
                        res_arr[3]++;
                        break;
                    case 5:
                        res_arr[4]++;
                        break;
                }
                one.setText("1*: " + Integer.toString(res_arr[0]));
                two.setText("2*: " +Integer.toString(res_arr[1]));
                three.setText("3*: " +Integer.toString(res_arr[2]));
                four.setText("4*: " + Integer.toString(res_arr[3]));
                five.setText("5*: " + Integer.toString(res_arr[4]));
                times.setText("Counter: " + Integer.toString(counter));
                result.setText(Integer.toString(res));
            }
        });
        summon2.setOnClickListener(new View.OnClickListener()
        {
            int res_arr[] = {0,0,0,0,0};
            int counter = 0;
            @Override
            public void onClick(View v)
            {
                counter++;
                TextView result = (TextView)findViewById(R.id.result_Ari);
                TextView one = (TextView)findViewById(R.id.one_Ari);
                TextView two = (TextView)findViewById(R.id.two_Ari);
                TextView three = (TextView)findViewById(R.id.three_Ari);
                TextView four = (TextView)findViewById(R.id.four_Ari);
                TextView five = (TextView)findViewById(R.id.five_Ari);
                TextView times = (TextView)findViewById(R.id.counter_Ari);
                Random temp = new Random();
                int res = temp.Generate(2);

                switch (res)
                {
                    case 1:
                        res_arr[0]++;
                        break;
                    case 2:
                        res_arr[1]++;
                        break;
                    case 3:
                        res_arr[2]++;
                        break;
                    case 4:
                        res_arr[3]++;
                        break;
                    case 5:
                        res_arr[4]++;
                        break;
                }
                one.setText("1*: " + Integer.toString(res_arr[0]));
                two.setText("2*: " +Integer.toString(res_arr[1]));
                three.setText("3*: " +Integer.toString(res_arr[2]));
                four.setText("4*: " + Integer.toString(res_arr[3]));
                five.setText("5*: " + Integer.toString(res_arr[4]));
                times.setText("Counter: " + Integer.toString(counter));
                result.setText(Integer.toString(res));
            }
        });

    }

}

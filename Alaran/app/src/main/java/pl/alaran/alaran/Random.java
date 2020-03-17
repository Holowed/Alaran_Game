package pl.alaran.alaran;

public class Random {
    Random()
    {

    }
    int Generate(int type)
    {
        double rates[] = {0,0,0,0,0};
        if(type == 1)
        {
            rates[0] = 0.4;
            rates[1] = 0.3;
            rates[2] = 0.2;
            rates[3] = 0.08;
            rates[4] = 0.01;

        }
        else
        {
            rates[0] = 0.7;
            rates[1] = 0.5;
            rates[2] = 0.15;
            rates[3] = 0.1;
            rates[4] = 0.02;
        }

        int result = 0;
        double rand = 0.0;
        do{
            rand = Math.random();
            if( rand >= rates[0]) result = 1;
            else if( rand >= rates[1]) result = 2;
            else if( rand >= rates[2]) result = 3;
            else if( rand >= rates[3]) result = 4;
            else if ( rand >= rates[4]) result = 5;
        }while(rand<rates[4]);



        return result;
    }
}

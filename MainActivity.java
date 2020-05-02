package sg.edu.np.whackamole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Whack-A-Mole";
    private TextView Result;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private List<Button> ButtonList = new ArrayList<>();
    int count = 0;


    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Result = (TextView)findViewById(R.id.Result);
        Button1 = (Button)findViewById(R.id.Button1);
        Button2 = (Button)findViewById(R.id.Button2);
        Button3 = (Button)findViewById(R.id.Button3);
        ButtonList.add(Button1);
        ButtonList.add(Button2);
        ButtonList.add(Button3);

        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        Button3.setOnClickListener(this);


        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        for (Button i : ButtonList){
            i.setText("o"); //reset mole
        }
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        Button random = ButtonList.get(randomLocation);
        random.setText("*");

    }

    @Override
    public void onClick(View v) {
        Button temp = (Button)v;
        switch(v.getId()){
            case R.id.Button1:
                Log.v(TAG,"Button Left Clicked!");
                break;
            case R.id.Button2:
                Log.v(TAG,"Button Middle Clicked!");
                break;
            case R.id.Button3:
                Log.v(TAG,"Button Right Clicked");
                break;
    }

    if (temp.getText()=="*"){
        count +=1;
        String numAsString = String.valueOf(count);
        Result.setText(numAsString);
        Log.v(TAG,"Hit, score added!");
        setNewMole();
    }
    else{
        count-=1;
        if (count<0){
            count = 0;
        }
        String numAsString = String.valueOf(count);
        Result.setText(numAsString);
        Log.v(TAG,"Missed, score deducted!");
        setNewMole();

    }


    }
}

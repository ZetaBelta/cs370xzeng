package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText Amount;
    EditText partySize;
    Button Compute;
    Button Reset;
    TextView fifteenPercentTip;
    TextView twentyPercentTip;
    TextView twentyFPercentTip;
    TextView fifteenPercentTotal;
    TextView twentyPercentTotal;
    TextView twentyFPercentTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Amount = findViewById(R.id.checkAmountValue);
        partySize = findViewById(R.id.partySizeValue);
        Compute = findViewById(R.id.buttonCompute);
        Reset = findViewById(R.id.buttonReset);
        fifteenPercentTip = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTip = findViewById(R.id.twentyPercentTipValue);
        twentyFPercentTip = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotal = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotal = findViewById(R.id.twentyPercentTotalValue);
        twentyFPercentTotal = findViewById(R.id.twentyfivePercentTotalValue);
        Reset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Amount.setText("");
                partySize.setText("");
            }
        });
        Compute.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(Amount.length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter amount.",Toast.LENGTH_SHORT).show();
                } else if(partySize.length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter the size of party.",Toast.LENGTH_SHORT).show();
                } else{
                    double amount = Double.parseDouble(Amount.getText().toString());
                    int size = Integer.parseInt(partySize.getText().toString());
                    computeTips(amount, size);
                }
            }
        });

    }

    public void computeTips(double amount, int size){
        int fifteenPercent1 = (int) Math.round(amount / 4 * 0.15);
        int fifteenPercent2 = (int) Math.round(amount /4) + fifteenPercent1;
        int twentyPercent1 = (int) Math.round(amount / 4 * 0.2);
        int twentyPercent2 = (int) Math.round(amount /4) + twentyPercent1;
        int twentyFPercent1 = (int) Math.round(amount / 4 * 0.25);
        int twentyFPercent2 = (int) Math.round(amount /4) + twentyFPercent1;
        fifteenPercentTip.setText(String.valueOf(fifteenPercent1));
        twentyPercentTip.setText(String.valueOf(twentyPercent1));
        twentyFPercentTip.setText(String.valueOf(twentyFPercent1));
        fifteenPercentTotal.setText(String.valueOf(fifteenPercent2));
        twentyPercentTotal.setText(String.valueOf(twentyPercent2));
        twentyFPercentTotal.setText(String.valueOf(twentyFPercent2));
    }
}
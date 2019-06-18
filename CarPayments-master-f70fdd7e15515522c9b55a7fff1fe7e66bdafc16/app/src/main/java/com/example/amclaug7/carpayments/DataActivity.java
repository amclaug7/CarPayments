package com.example.amclaug7.carpayments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity{
    public static final String DA = "MainActivity";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.w(DA,"Inside DataActivity:onCreate\n");
        setContentView(R.layout.activity_data);
        updateView();
    }

    public void updateView(){
        CarPayment carPayment = MainActivity.carPayment;

        EditText carValueET = findViewById(R.id.data_carValue);
        carValueET.setText("" + carPayment.getCarValue());
        EditText downPaymentValueET = findViewById(R.id.data_downPayment);
        downPaymentValueET.setText("" + carPayment.getDownPayment());
        EditText monthsET = findViewById(R.id.data_months);
        monthsET.setText("" + carPayment.getMonths());
        EditText leaseRateET = findViewById(R.id.data_leaseRate);
        leaseRateET.setText("" + carPayment.getLeaseRate());
    }

    public void updateMortgageObject(){
        CarPayment carPayment = MainActivity.carPayment;

        EditText carValueET = findViewById(R.id.data_carValue);
        String carValueString = carValueET.getText().toString();
        EditText downPaymentET = findViewById(R.id.data_downPayment);
        String downPaymentString = downPaymentET.getText().toString();
        EditText monthsET = findViewById(R.id.data_months);
        String monthsString = monthsET.getText().toString();
        EditText leaseRateET = findViewById(R.id.data_leaseRate);
        String leaseRateString = leaseRateET.getText().toString();

        try{
            float carValue = Float.parseFloat(carValueString);
            carPayment.setCarValue(carValue);
            float leaseRate = Float.parseFloat(leaseRateString);
            carPayment.setLeaseRate(leaseRate);
            float downPayment = Float.parseFloat(downPaymentString);
            carPayment.setDownPayment(downPayment);
            int months = Integer.parseInt(monthsString);
            carPayment.setMonths(months);
            carPayment.setPreferences(this);
        } catch (NumberFormatException nfe){
        }
    }

    public void goBack(View v){
        updateMortgageObject();
        this.finish();
        overridePendingTransition(R.anim.fade_in_and_scale, 0);
    }

    protected void onStart(){
        super.onStart();
        Log.w(DA,"Inside DataActivity:onStart\n");
    }

    protected void onRestart(){
        super.onRestart();
        Log.w(DA,"Inside DataActivity:onRestart\n");
    }

    protected void onResume(){
        super.onResume();
        Log.w(DA,"Inside DataActivity:onResume\n");
    }

    protected void onPause(){
        super.onPause();
        Log.w(DA,"Inside DataActivity:onPause\n");
    }

    protected void onStop(){
        super.onStop();
        Log.w(DA,"Inside DataActivity:onStop\n");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.w(DA,"Inside DataActivity:onDestroy\n");
    }
}

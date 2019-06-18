package com.example.amclaug7.carpayments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MA = "MainActivity";
    public static CarPayment carPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(MA,"Inside MainActivity:onCreate\n");
        carPayment = new CarPayment(this);
        setContentView(R.layout.activity_main);
    }

    public void modifyData(View v){
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }

    public void onStart(){
        super.onStart();
        Log.w(MA,"Inside MainActivity:onStart\n");
        updateView();
    }

    public void updateView(){
        TextView carValueTV = findViewById(R.id.carValue);
        carValueTV.setText(carPayment.getFormattedCarValue());
        TextView monthsTV = findViewById(R.id.months);
        monthsTV.setText("" + carPayment.getMonths());
        TextView leaseRateTV = findViewById(R.id.leaseRate);
        leaseRateTV.setText(100 * carPayment.getLeaseRate() + "%");
        TextView downPaymentTV = findViewById(R.id.downPayment);
        downPaymentTV.setText(carPayment.getFormattedDownPayment());
        TextView monthlyTV = findViewById(R.id.payment);
        monthlyTV.setText(carPayment.formattedMonthlyPayment());
    }

    protected void onRestart(){
        super.onRestart();
        Log.w(MA, "Inside MainActivity:onRestart\n");
    }

    protected void onResume(){
        super.onResume();
        Log.w(MA,"Inside MainActivity:onResume\n");
    }

    protected void onPause(){
        super.onPause();
        Log.w(MA,"Inside MainActivity:onPause\n");
    }

    protected void onStop(){
        super.onStop();
        Log.w(MA,"Inside MainActivity:onStop\n");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.w(MA,"Inside MainActivity:onDestroy\n");
    }
}



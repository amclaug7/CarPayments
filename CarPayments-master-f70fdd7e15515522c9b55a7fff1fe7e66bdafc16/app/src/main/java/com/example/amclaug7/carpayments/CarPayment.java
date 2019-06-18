package com.example.amclaug7.carpayments;

import java.text.DecimalFormat;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class CarPayment {
    public final DecimalFormat MONEY = new DecimalFormat("$#,##0.00");
    public static final String PREFERNECE_CARVALUE = "carValue";
    public static final String PREFERNECE_DOWNPAYMENT = "downPayment";
    public static final String PREFERNECE_MONTHS = "months";
    public static final String PREFERNECE_LEASERATE = "leaseRate";

    private float carValue;
    private float downPayment;
    private int months;
    private float leaseRate;

    public CarPayment(Context context){
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(context);
        setCarValue(pref.getFloat(PREFERNECE_CARVALUE, 100000.f));
        setDownPayment(pref.getFloat(PREFERNECE_DOWNPAYMENT, 1200.0f));
        setMonths(pref.getInt(PREFERNECE_MONTHS,30));
        setLeaseRate(pref.getFloat(PREFERNECE_LEASERATE, .035f));
    }

    public void setCarValue(float newCarValue){
        if(newCarValue > 0)
            carValue = newCarValue;
    }

    public void setDownPayment(float newDownPayment){
        if(newDownPayment > 0)
            downPayment = newDownPayment;
    }

    public void setMonths(int newMonths){
        if(newMonths >= 0)
            months = newMonths;
    }

    public void setLeaseRate(float newLeaseRate){
        if(newLeaseRate >= 0)
            leaseRate = newLeaseRate;
    }

    public float getCarValue(){
        return carValue;
    }

    public String getFormattedCarValue(){
        return MONEY.format(carValue);
    }

    public float getDownPayment(){
        return downPayment;
    }

    public String getFormattedDownPayment(){
        return MONEY.format(downPayment);
    }

    public int getMonths(){
        return months;
    }

    public float getLeaseRate(){
        return leaseRate;
    }

    public float monthlyPayment(){
        double temp = Math.pow(1 / (1 + leaseRate), months);
        return (carValue - downPayment) * leaseRate / (float) (1 - temp);
    }

    public String formattedMonthlyPayment(){
        return MONEY.format(monthlyPayment());
    }

    public void setPreferences(Context context){
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(PREFERNECE_CARVALUE, carValue);
        editor.putFloat(PREFERNECE_DOWNPAYMENT, downPayment);
        editor.putInt(PREFERNECE_MONTHS, months);
        editor.putFloat(PREFERNECE_LEASERATE, leaseRate);
    }

    /*public float totalPayment(){
        return monthlyPayment() * months;
    }

    public String formattedTotalPayment(){
        return MONEY.format(totalPayment());
    }
*/}

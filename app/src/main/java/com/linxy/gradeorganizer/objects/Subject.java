package com.linxy.gradeorganizer.objects;

import android.content.Context;
import android.database.Cursor;

import com.linxy.gradeorganizer.R;
import com.linxy.gradeorganizer.database_helpers.DatabaseHelper;
import com.linxy.gradeorganizer.utility.GradeMath;

import java.util.HashMap;

/**
 * Created by Linxy on 15/8/2015 at 19:38
 * Working on Grade Organizer in com.linxy.gradeorganizer.objects
 */
public class Subject {

    private Context context;
    private boolean round;

    private String name;
    private int subjectFactor;
    private double subjectAverage;

    public Subject(String name,int factor, boolean round, Context context){
        this.name = name;
        this.round = round;
        this.context = context;
        this.subjectFactor = factor;
        this.subjectAverage = computeAverage();
    }

    public String getName(){
        return name;
    }

    public double getAverage(){
        return subjectAverage;
    }

    /* Subject factor has no influence in this class,
     * however, it is useful information to store here
     * as it would require unecessary steps in the GradeMath
     * class to retrieve the said subject factor from the
     * database, so store it here for completeness.
     */
    public int getFactor(){
        return subjectFactor;
    }

    public int getColor(){
        return getColor(subjectAverage, context);
    }

    public double getInsufficient(){
        if(subjectAverage >= 4) return GradeMath.SUFFICIENT;
        return 4.0 - subjectAverage;
    }


    private double computeAverage(){ /* TODO THERE IS A POSSIBILITY THAT IF A FACTOR OF 0 IS ENTERED, IT WILL CAUSE A DIVIDE BY 0 ERROR */
        DatabaseHelper db = new DatabaseHelper(context);
        Cursor cursor = db.getAllData();

        double numerator = 0;
        double denominator = 0;

        while(cursor.moveToNext()){
            if(cursor.getString(1).equals(name)){
                numerator += (Integer.parseInt(cursor.getString(4)) / 100) * Double.parseDouble(cursor.getString(3));
                denominator += (Integer.parseInt(cursor.getString(4)) / 100);
            }
        }
        if(numerator == 0) return GradeMath.NO_AVERAGE; /* This is an Error Code */
        if(round) return GradeMath.roundToHalf(numerator / denominator);
        cursor.close();
        db.close();
        return numerator / denominator;
    }

    public static int getColor(double val, Context c){
        if(val >= 4.0) return c.getResources().getColor(R.color.ColorFlatGreen);
        if(val >= 3.75) return c.getResources().getColor(R.color.FlatOrange);
        return c.getResources().getColor(R.color.ColorFlatRed);
    }
}

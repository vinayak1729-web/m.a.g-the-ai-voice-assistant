package com.example.magapp;

import android.util.Log;

import java.util.Calendar;

public class function {
    public static String wishme(){
        String S = "";
        Calendar C = Calendar.getInstance();
        int time = C.get(Calendar.HOUR_OF_DAY);
        if( time >= 0 && time < 12){
            S = "Good Morning Sir ";
        }else if (time >= 12 && time < 16){
            S = " Good Afternoon Sir";
        }else if (time >= 16 && time < 20){
            S = " Good Evening Sir";
        }else if(time >= 20 && time < 22 ){
            S = " Good Night sir";
        }else if(time >= 22 && time < 24 ) {
            S = " YOu need to  take rest Sir  ..... Its's to late !! ";
        }
        return S;

    }
    public static String fetchname(String msg){
        String name = "";
        boolean flag = false;
        String[] data = msg.split("");
        for (int i=0;i<data.length;i++){
            String d = data[i];
            if(d.equals("call")) {
                if (data[(i + 1)].equals("to")) {
                    flag = false;
                } else {
                    flag = true;
                }
            }else if(d.equals("and")||d.equals(".")) {
                 flag = false;
                }
            else if(data[(i-1)].equals("call")){
                if(d.equals("to")){
                    flag = true;
                }
            }
            if(flag){
                if(!d.equals("call")&&!d.equals("to")){
                    name= name.concat(" "+d);
                }
            }
        }
        Log.d( "Name",name);
        return name;
    }

}

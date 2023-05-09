package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.DecimalFormat;

/**
 * Package voc.net.tools.zgirls_tool.util was
 * Created by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2020 Xectorda 版權所有
 */
public class prettyCount {
    Number number;
    Context context;

   public String pretty(Number number, Context context){
       char[] suffix = {' ', 'K', 'M', 'G', 'T', 'P', 'E', 'Z', 'Y'};
       long numValue = number.longValue();
       int value = (int) Math.floor(Math.log10(numValue));
       int base = value / 3;
       SharedPreferences sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
       int decimal_num = sharedPreferences.getInt("decimal_num", 0);
       boolean decimal  = sharedPreferences.getBoolean("decimal", false);
       if (decimal == true){
           if (value >= 3 && base < suffix.length) {
               if (decimal_num == 0){
                   return new DecimalFormat("##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
               }
               if (decimal_num == 1){
                   return new DecimalFormat("##.#").format(numValue / Math.pow(10, base * 3)) + suffix[base];
               }
               if (decimal_num == 2){
                   return new DecimalFormat("##.##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
               }
               if (decimal_num == 3){
                   return new DecimalFormat("##.###").format(numValue / Math.pow(10, base * 3)) + suffix[base];
               }
               if (decimal_num == 4){
                   return new DecimalFormat("##.####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
               }
               if (decimal_num == 5){
                   return new DecimalFormat("##.#####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
               }
               // Muility
           } else {
               return new DecimalFormat("#,###").format(numValue);
           }}
       return new DecimalFormat("###,###,###,###,###").format(numValue);
   }
   }



package com.example.numerologynameapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button(View view) {
        TextView name1 = findViewById(R.id.editTextTextPersonName);
        int[] data = {1,2,3,4,5,8,3,5,1,1,2,3,4,5,7,8,1,2,3,4,6,6,6,5,1,7};
        String name = name1.toString();
        name = name.replaceAll("\\s", "");
        name = name.toUpperCase();
        int[] value = new int[name.length()];
        for(int i=0; i<name.length(); i++)
            System.out.print(name.charAt(i) + " ");
        System.out.print("\n");
        for(int i=0; i<name.length(); i++) {
            int temp = data[name.charAt(i) - 65];
            value[i] = (temp);
            System.out.print(temp + " ");
        }
        System.out.print("\n");
        stepByStep(value);
        }

        public static int[] stepByStep(int[] arr) {
            int[] arr1 = new int[arr.length-1];
            for (int i=0; i<arr.length-1; i++) {
                arr1[i] = add(arr[i], arr[i+1]);
                System.out.print(String.valueOf(arr1[i]) + " ");
            }
            System.out.println("\t");
            if(arr1.length!=1)
                arr1 = stepByStep(arr1);
            return arr1;
        }

        public static int add(int a, int b) {
            int val = a + b;
            if (val > 9)
                val = add(1, (val % 10));
            return val;
        }
}
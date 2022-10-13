package com.example.multithreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_async);
    }
    public void Click(View v){
        EditText input1 = findViewById(R.id.editTextFirst);
        EditText input2 = findViewById(R.id.editTextSecond);

        String text1 = input1.getText().toString();
        String text2 = input2.getText().toString();
        TextView output = findViewById(R.id.textViewOutput);
        output.setText("");
        if(text1.isEmpty() || text2.isEmpty()){
            Toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_SHORT).show();
            return;
        }
        AsynkTask firstTask = new AsynkTask(output);
        firstTask.executeOnExecutor(AsynkTask.THREAD_POOL_EXECUTOR,1,Integer.parseInt(text1));

        AsynkTask secondTask = new AsynkTask(output);
        secondTask.executeOnExecutor(AsynkTask.THREAD_POOL_EXECUTOR,2,Integer.parseInt(text2));
    }
    public void Click2(View v) {
        EditText inputFirst = findViewById(R.id.editTextFirst);
        EditText inputSecond = findViewById(R.id.editTextSecond);

        String textFirst = inputFirst.getText().toString();
        String textSecond = inputSecond.getText().toString();
        TextView output = findViewById(R.id.textViewOutput);
        output.setText("");
        if (textFirst.isEmpty() || textSecond.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_LONG).show();
            return;
        }

        for(int i = 1; i < Integer.parseInt(textFirst)+1; i++){
            try{
                Thread.sleep(200);
            } catch (InterruptedException e) {}
            output.setText(output.getText() + "Задача 1 прошла " + i + " запрос\n");

        }
        output.setText(output.getText() + "Задача 1 выполнена успешно\n");

        for(int i = 1; i < Integer.parseInt(textSecond)+1; i++){
            try{
                Thread.sleep(200);
            }
            catch (InterruptedException e) {}
            output.setText(output.getText() + "Задача 2 прошла " + i + " запрос\n");
        }
        output.setText(output.getText() + "Задача 2 выполнена успешно\n");
    }
}
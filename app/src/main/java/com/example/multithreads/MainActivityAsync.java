package com.example.multithreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityAsync extends AppCompatActivity {

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
        if(text1.isEmpty() || text2.isEmpty()){
            Toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_SHORT);
            return;
        }
        AsynkTask firstTask = new AsynkTask(output);
        firstTask.executeOnExecutor(AsynkTask.THREAD_POOL_EXECUTOR,1,Integer.parseInt(text1));

        AsynkTask secondTask = new AsynkTask(output);
        secondTask.executeOnExecutor(AsynkTask.THREAD_POOL_EXECUTOR,2,Integer.parseInt(text2));
    }
    public void Click2(View v){
        SetText(findViewById(R.id.editTextFirst),1);
        SetText(findViewById(R.id.editTextSecond),2);

    }
    public void SetText(EditText et, int j){

        TextView output = findViewById(R.id.textViewOutput);
        String text1 = et.getText().toString();
        StringBuilder out = null;

        for (int i = 0; i < Integer.parseInt(text1);i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){}
            out.append("Задача "+j+" прошла ").append(i).append(" запрос");
            output.setText(out);
        }
        out.append("Задача "+j+" успешно выполнена");
        output.setText(out);
    }
}
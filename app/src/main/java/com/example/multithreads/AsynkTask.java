package com.example.multithreads;

import android.os.AsyncTask;
import android.widget.TextView;

public class AsynkTask extends AsyncTask<Integer, String, String> {
    TextView textView;
    public AsynkTask(TextView tw){
        textView = tw;
    }

    @Override
    protected String doInBackground(Integer... integers){
        if (integers.length <2){
            return "Введите данные";
        }
        for (int i = 0; i < integers[1];i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){}
            publishProgress("Задача "+integers[0]+ " прошла "+i+" запрос");
        }
        return "Задача "+integers[0]+ " успешно выполнена";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(textView.getText()+"\n"+values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        textView.setText(textView.getText()+"\n"+s);
    }
}






















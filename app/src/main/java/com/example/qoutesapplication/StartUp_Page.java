package com.example.qoutesapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StartUp_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up__page);

        Thread myStart_UpThread;
        myStart_UpThread = new Thread(){
        @Override public void run(){
            try{
                synchronized (this){
                    wait(4000);
                }
            }catch(InterruptedException ignored){

            }
            finally {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }
        };
        myStart_UpThread.start();
    }
}

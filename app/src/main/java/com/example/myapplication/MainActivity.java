package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.models.AppRequestBody;
import com.example.myapplication.models.UserInfo;
import com.example.myapplication.network.ApiService;
import com.example.myapplication.network.RetrofitClient;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Timer timer;

    private static final long TIMER_VALUE = 3000;

    StringBuilder stringBuilder = new StringBuilder();

    private TextView textViewNameUser;
    private TextView textViewNamePosition;
    private TextView textViewNameUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int imageAvatarHeight = (int) (screenHeight * 0.25);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewNameUser = findViewById(R.id.textNameUser);
        textViewNamePosition = findViewById(R.id.textPositionUser);
        textViewNameUnit = findViewById(R.id.textUnitUser);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                navigatorNextScreen();
//                Intent intent = new Intent(MainActivity.this, ShowADSActivity.class);
//                startActivity(intent);
//                finish();
            }
        }, TIMER_VALUE);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (event.getKeyCode() != KeyEvent.KEYCODE_SHIFT_LEFT) {
                char pressedKey = (char) event.getUnicodeChar();
                stringBuilder.append(pressedKey);
            }

            if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                Log.d("onKeyUp is: ", stringBuilder.toString());
                getInfoUser(stringBuilder.toString().replaceAll("\n", ""));
                stringBuilder.setLength(0);
//                navigatorNextScreen();
            }
        }

        return super.dispatchKeyEvent(event);
    }

    public void navigatorNextScreen() {
        Intent intent = new Intent(MainActivity.this, ShowADSActivity.class);
        startActivity(intent);
        finish();
    }

    public void getInfoUser(String valueQRCode){
        AppRequestBody appRequestBody = new AppRequestBody("2024-03-04 09:00:00","POS01");
        RetrofitClient.getClient().create(ApiService.class).getInfoUser(valueQRCode, appRequestBody).enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(@NonNull Call<UserInfo> call, @NonNull Response<UserInfo> response) {
                if(response.isSuccessful()){
                    UserInfo data = response.body();
                    if(data != null){
                        textViewNameUser.setText(data.getName());
                        textViewNamePosition.setText(data.getPosition());
                        textViewNameUnit.setText(data.getBranch());
                    } else {
                        Log.e("Get info user", "data null");
                    }
                } else {
                    Log.e("Get info user", "onResponse failure");
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserInfo> call, @NonNull Throwable t) {
                Log.e("Get info user", "onResponse failure, try again");
            }
        });
    }

//    public static String convertDateTime(){
//        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//        return dateTimeFormat.format();
//    }
}
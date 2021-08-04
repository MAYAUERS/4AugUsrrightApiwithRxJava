package com.example.a4augusrrightapiwithrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    Button button;
    TextView textView;

    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.btnClick);
        textView=findViewById(R.id.txt_res);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAPI();
            }
        });
    }

    private void CallAPI() {

        JSONObject jsonObject=new JSONObject();

        JSONObject jsonObject1 =new JSONObject();
        JsonObject gson=new JsonObject();
//{"p_in_obj":{"stringval34":"INSTAB","stringval30":"9.29","stringval1":"358525086570839"}}
        try {
            jsonObject1.put("stringval34","INSTAB");
            jsonObject1.put("stringval30","9.29");
            jsonObject1.put("stringval1","358525086570839");

            jsonObject.put("p_in_obj",jsonObject1);

            JsonParser jsonParser=new JsonParser();
            gson=(JsonObject)jsonParser.parse(jsonObject.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ApiInterface apiInterface=ApiClient.getAPIClient().create(ApiInterface.class);


        compositeDisposable.add(apiInterface.getAllAPIResponse(gson)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Consumer<SucessResponse>() {
            @Override
            public void accept(SucessResponse sucessResponse) throws Exception {
                textView.setText(sucessResponse.getpInObj().getStringval10().toString());
            }
        })
        );
    }
}

package com.example.provincialcitystreet;


import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ProvincialCityStreetActivity extends AppCompatActivity {
    //以下跟选择地址有关
    private AreaPickerView areaPickerView;
    private List<AddressBean> addressBeans;
    private int[] i;
    private String villageId;
    private Context context;
    private ProvincialCityStreetCallBack areaPickerViewCallback;
    public ProvincialCityStreetActivity(@NonNull Context context) {
        super();
        this.context=context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();


//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showListDialogvillage();
//            }
//        });
    }

    private void initView() {
        i=null;
        Gson gson = new Gson();
        addressBeans = gson.fromJson(getJsonFromAssets(context), new TypeToken<List<AddressBean>>() {}.getType());
        areaPickerView = new AreaPickerView(context, R.style.Dialog, addressBeans);
        areaPickerView.setAreaPickerViewCallback(new AreaPickerView.AreaPickerViewCallback() {
            @Override
            public void callback(int... value) {
                i=value;
                if (value.length == 4) {
//                    textView.setText(addressBeans.get(value[0]).getLabel() + "-" + addressBeans.get(value[0]).getChildren().get(value[1]).getLabel() + "-" + addressBeans.get(value[0]).getChildren().get(value[1]).getChildren().get(value[2]).getLabel()+"-"+ addressBeans.get(value[0]).getChildren().get(value[1]).getChildren().get(value[2]).getChildren().get(value[3]).getLabel());
                    villageId=addressBeans.get(value[0]).getChildren().get(value[1]).getChildren().get(value[2]).getChildren().get(value[3]).getCode();
                    areaPickerViewCallback.callback(addressBeans.get(value[0]).getName(),addressBeans.get(value[0]).getChildren().get(value[1]).getName(),addressBeans.get(value[0]).getChildren().get(value[1]).getChildren().get(value[2]).getName(),addressBeans.get(value[0]).getChildren().get(value[1]).getChildren().get(value[2]).getChildren().get(value[3]).getName(),villageId);

                } else{

                }
            }
        });
    }

    public void setProvincialCityStreetCallBack(ProvincialCityStreetCallBack areaPickerViewCallback) {
        this.areaPickerViewCallback = areaPickerViewCallback;
    }

    public interface ProvincialCityStreetCallBack {
        void callback(String province,String city,String area,String street,String code);
    }

    public static void showProvincial(){
        Log.d("Main","----->");
    }

    public void showListDialogvillage() {
        initView();
        areaPickerView.setSelect(i);
        areaPickerView.show();
    }


    public static String getJsonFromAssets(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open("city.json")));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}

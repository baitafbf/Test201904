package com.example.jsjx.testprovincecitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Spinner provSpinner,citySpinner;
TextView tv_show;
ArrayAdapter<String>provAdapter,cityAdapter;
String[]provinces={"山西省","陕西省"};
String[][]citys={{"太原市","晋中市","晋城市"},{"西安市","宝鸡市","咸阳市"}};
int provincePostion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        provAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,provinces);
        provSpinner.setAdapter(provAdapter);
        provSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,citys[position]);
                provincePostion=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // tv_show.setText(provinces[provincePostion]+citys[provincePostion][position]);
                tv_show.setText(provAdapter.getItem(provincePostion)+cityAdapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initView() {
        provSpinner=findViewById(R.id.province_spinner);
        citySpinner=findViewById(R.id.city_spinner);
        tv_show=findViewById(R.id.tv_show);
    }

}

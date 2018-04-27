package com.example.lemon.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageIds = new int[]{
            R.drawable.lion,R.drawable.tiger,R.drawable.monkey
            ,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> ListItems = new ArrayList<Map<String,Object>>();
        for (int i = 0;i < names.length;i++){
            Map<String,Object> ListItem =  new HashMap<String, Object>();
            ListItem.put("AnimalName",names[i]);
            ListItem.put("AnimalImage",imageIds[i]);
            ListItems.add(ListItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,ListItems,R.layout.simple_item
                ,new String[]{"AnimalName","AnimalImage",},new int[]{R.id.animalname,R.id.animalImage});
        ListView List = (ListView) findViewById(R.id.myList);
        List.setAdapter(simpleAdapter);
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast=Toast.makeText(MainActivity.this,names[i]+"被点击了", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}

package com.example.listdisplay4_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private String[] from;
    private final String ATTRIBUTE_TITLE_TEXT = "title";
    private final String ATTRIBUTE_SUBTITLE_TEXT = "subtitle";

    int[] to = {R.id.textView_text_1, R.id.textView_text_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //массив данных
        String[] values = prepareContent();

        ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>(values.length);
        Map<String, String> mapText;

        for (int i = 0; i < values.length; i++) {
            mapText = new HashMap<>();

            mapText.put(ATTRIBUTE_TITLE_TEXT, values[i]);
            mapText.put(ATTRIBUTE_SUBTITLE_TEXT, "" + values[i].length());
            data.add(mapText);
        }

        from = new String[]{ATTRIBUTE_TITLE_TEXT, ATTRIBUTE_SUBTITLE_TEXT};

        BaseAdapter listContentAdapter = createAdapter(data);
        listView.setAdapter(listContentAdapter);

    }

    private void initViews() { //инициализация
        listView = findViewById(R.id.listView_text_1);

    }

    private BaseAdapter createAdapter(List<Map<String, String>> data) {
        return new SimpleAdapter(this, data, R.layout.item,
                from, to);
    }

    private String[] prepareContent() {
        return getString(R.string.large_text).split("\n\n");
    }
}

package programmer.lp.list_recycler_view.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import programmer.lp.list_recycler_view.R;
import programmer.lp.list_recycler_view.model.Datas;
import programmer.lp.list_recycler_view.model.Fruit;

public class ListViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = findViewById(R.id.list_view);
        List<Fruit> fruits = Datas.fruits2();
        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.activity_list_view_item, fruits);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, fruits.get(i).getFruitName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
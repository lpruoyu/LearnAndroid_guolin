package programmer.lp.list_recycler_view.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import programmer.lp.list_recycler_view.R;
import programmer.lp.list_recycler_view.model.Datas;
import programmer.lp.list_recycler_view.model.Fruit;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        staggeredGrid();
//        vertical();
//        horizontal();
    }

    private void staggeredGrid() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        List<Fruit> fruits = Datas.fruits1();
        fruits.stream()
                .map(new Function<Fruit, Fruit>() {
                    @Override
                    public Fruit apply(Fruit fruit) {
                        fruit.setFruitName(getRandomLengthName());
                        return fruit;
                    }
                })
                .collect(Collectors.toList());
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(R.layout.activity_recycler_view_item_staggeredgrid, fruits);
        recyclerView.setAdapter(adapter);
    }

    private String getRandomLengthName() {
        // Math.random() -> [0, 1) // (int)Math.random()永远为0
        double random = Math.random();
        int maxLength = 60;
        int finalLength = (int) (maxLength * random) + 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finalLength; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    private void horizontal() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<Fruit> fruits = Datas.fruits2();
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(R.layout.activity_recycler_view_item_horizontal, fruits);
        recyclerView.setAdapter(adapter);
    }

    private void vertical() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<Fruit> fruits = Datas.fruits2();
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(R.layout.activity_recycler_view_item_vertical, fruits);
        recyclerView.setAdapter(adapter);
    }

}
package programmer.lp.list_recycler_view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import programmer.lp.list_recycler_view.R;
import programmer.lp.list_recycler_view.model.Fruit;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private int resource;
    private List<Fruit> fruits;

    public MyRecyclerViewAdapter(int resource, List<Fruit> fruits) {
        this.resource = resource;
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(resource, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.imageView.getContext(), fruit.getFruitName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView.setText(fruit.getFruitName());
        holder.imageView.setImageResource(fruit.getImageId());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    protected static final class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.list_view_item_text);
            imageView = itemView.findViewById(R.id.list_view_item_image);
        }
    }
}

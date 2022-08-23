package programmer.lp.list_recycler_view.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import programmer.lp.list_recycler_view.R;
import programmer.lp.list_recycler_view.model.Fruit;


public class ListViewAdapter extends ArrayAdapter<Fruit> {
    private int resource;
    private List<Fruit> fruits;

    public ListViewAdapter(@NonNull Context context, int resource,
                           @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.fruits = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View layoutView = null;
        ViewHolder viewHolder = null;
        if (convertView == null) {
            layoutView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
            viewHolder = new ViewHolder(layoutView.findViewById(R.id.list_view_item_text), layoutView.findViewById(R.id.list_view_item_image));
            layoutView.setTag(viewHolder);
        } else {
            layoutView = convertView;
            viewHolder = (ViewHolder) layoutView.getTag();
        }

        Fruit fruit = fruits.get(position);
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getFruitName());
        return layoutView;
    }

    private static final class ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(TextView textView, ImageView imageView) {
            this.textView = textView;
            this.imageView = imageView;
        }
    }
}

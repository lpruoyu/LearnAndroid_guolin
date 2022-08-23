package programmer.lp.list_recycler_view.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import programmer.lp.list_recycler_view.R;

public class Datas {
    public static List<Fruit> fruits1() {
        List<Fruit> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Fruit(R.drawable.apple_pic, "apple"));
            list.add(new Fruit(R.drawable.banana_pic, "banana"));
            list.add(new Fruit(R.drawable.cherry_pic, "cherry"));
            list.add(new Fruit(R.drawable.grape_pic, "grape"));
            list.add(new Fruit(R.drawable.mango_pic, "mango"));
            list.add(new Fruit(R.drawable.orange_pic, "orange"));
            list.add(new Fruit(R.drawable.pear_pic, "pear"));
            list.add(new Fruit(R.drawable.pineapple_pic, "pineapple"));
            list.add(new Fruit(R.drawable.strawberry_pic, "strawberry"));
            list.add(new Fruit(R.drawable.watermelon_pic, "watermelon"));
        }
        return list;
    }

    public static List<Fruit> fruits2() {
        return Arrays.asList(
                        new Fruit(R.drawable.apple_pic, "apple"),
                        new Fruit(R.drawable.banana_pic, "banana"),
                        new Fruit(R.drawable.cherry_pic, "cherry"),
                        new Fruit(R.drawable.grape_pic, "grape"),
                        new Fruit(R.drawable.mango_pic, "mango"),
                        new Fruit(R.drawable.orange_pic, "orange"),
                        new Fruit(R.drawable.pear_pic, "pear"),
                        new Fruit(R.drawable.pineapple_pic, "pineapple"),
                        new Fruit(R.drawable.strawberry_pic, "strawberry"),
                        new Fruit(R.drawable.watermelon_pic, "watermelon")
                ).stream()
                .map(fruit -> {
                    Fruit[] fruits = new Fruit[10];
                    for (int i = 0; i < 10; i++) {
                        fruits[i] = new Fruit(fruit.getImageId(), fruit.getFruitName() + UUID.randomUUID());
                    }
                    return fruits;
                })
                .flatMap(new Function<Fruit[], Stream<Fruit>>() {
                    @Override
                    public Stream<Fruit> apply(Fruit[] fruits) {
                        return Arrays.stream(fruits);
                    }
                })
                .collect(Collectors.toList());
    }
}

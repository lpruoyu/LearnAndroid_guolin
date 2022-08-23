package programmer.lp.list_recycler_view.model;

public class Fruit {
    private int imageId;
    private String fruitName;

    public Fruit(int imageId, String fruitName) {
        this.imageId = imageId;
        this.fruitName = fruitName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}

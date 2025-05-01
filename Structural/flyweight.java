import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class TreeType{
    private String type;
    private String color;
    private String texture;

    public TreeType(String type, String color, String texture) {
        this.type = type;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + type + " tree at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}

class Tree{
    int x;
    int y;
    TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    public void draw() {
        type.draw(x, y);
    }
}

class TreeFactory{
    private static Map<String,TreeType> trees = new HashMap<>();

    public static TreeType getTreeType(String type, String color, String texture) {
        String key = type+'-'+color+'-'+texture;
        if(!trees.containsKey(key)){
            System.out.println("Creating new tree type: " + key);
            trees.put(key, new TreeType(type, color, texture));
        }
        return trees.get(key);
    }
}
public class flyweight {
    public static void main(String[] args) {
        List<Tree> trees = new ArrayList<>();

        trees.add(new Tree(1, 2, TreeFactory.getTreeType("Oak", "Green", "Rough")));
        trees.add(new Tree(3, 4, TreeFactory.getTreeType("Pine", "Dark Green", "Smooth")));
        trees.add(new Tree(5, 6, TreeFactory.getTreeType("Oak", "Green", "Rough")));
        trees.add(new Tree(7, 8, TreeFactory.getTreeType("Oak", "Green", "Rough")));

        for(Tree tree : trees) {
            tree.draw();
        }
    }   
}

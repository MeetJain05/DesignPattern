import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface Shape {
    void draw(Graphics g, int x, int y, int size, Color color);
}

class Line implements Shape {
    @Override
    public void draw(Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        g.drawLine(x, y, x + size, y + size);
    }
}

class Rectangle implements Shape {
    @Override
    public void draw(Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        g.fillRect(x, y, size, size + 20); 
    }
}

class Square implements Shape {
    @Override
    public void draw(Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        g.fillRect(x, y, size, size); 
    }
}

class Circle implements Shape {
    @Override
    public void draw(Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        g.fillOval(x, y, size, size); 
    }
}

class ShapeFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(String type) {
        Shape shape = shapeMap.get(type);

        if (shape == null) {
            switch (type) {
                case "LINE" -> shape = new Line();
                case "RECTANGLE" -> shape = new Rectangle();
                case "SQUARE" -> shape = new Square();
                case "CIRCLE" -> shape = new Circle();
            }
            shapeMap.put(type, shape);
        }
        return shape;
    }
}

public class DrawingApp extends JFrame {
    private final Random random = new Random();

    public DrawingApp() {
        setTitle("Flyweight Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Graphics g = canvas.getGraphics();
                String[] shapes = {"LINE", "RECTANGLE", "SQUARE", "CIRCLE"};
                String shapeType = shapes[random.nextInt(shapes.length)];
                Shape shape = ShapeFactory.getShape(shapeType);

                int size = random.nextInt(50) + 20; 
                Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

                shape.draw(g, e.getX(), e.getY(), size, color);
            }
        });

        add(canvas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawingApp().setVisible(true));
    }
}

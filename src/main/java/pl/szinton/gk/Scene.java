package pl.szinton.gk;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene {

    private final List<Model3D> objects;

    public Scene() {
        this.objects = new ArrayList<>();
    }

    public void addObject(Model3D obj) {
        objects.add(obj);
    }

    public void render(Graphics g, Camera3D camera) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        for (Model3D obj : objects) {
            obj.render(g2d, camera);
        }
    }
}

package pl.szinton.gk;

import java.awt.Graphics;
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
        for (Model3D obj : objects) {
            obj.render(g, camera);
        }
    }
}

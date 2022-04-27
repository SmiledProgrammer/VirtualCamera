package pl.szinton.gk;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Scene {

    private final List<Model3D> objects;
    private final Camera3D camera;

    public Scene(Camera3D camera) {
        this.objects = new ArrayList<>();
        this.camera = camera;
    }

    public void addObject(Model3D obj) {
        objects.add(obj);
    }

    public void render(Graphics g) {
        for (Model3D obj : objects) {
            obj.render(g, camera);
        }
    }

    public void updateFrameSize(Vector2i frameSize) {
        camera.setFrameSize(frameSize);
    }
}

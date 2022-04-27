package pl.szinton.gk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application extends JFrame implements KeyListener {

    protected final static int DEFAULT_WIDTH = 800;
    protected final static int DEFAULT_HEIGHT = 600;

    protected final Camera3D camera;
    protected final Scene scene;

    public Application(Camera3D camera, Scene scene) {
        this.camera = camera;
        this.scene = scene;
        this.setTitle("Virtual Camera");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Component component = (Component) e.getSource();
                camera.setFrameSize(new Vector2i(component.getWidth(), component.getHeight()));
            }
        });
    }

    public void run() {
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        scene.render(g, camera);
    }

    public static void main(String[] args) {
        Vector3f initialPosition = new Vector3f(2f, 1f, -3f);
        Vector2i frameSize = new Vector2i(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        Camera3D camera = new Camera3D(frameSize, initialPosition);

        Scene scene = new Scene();
        scene.addObject(Utils.createCuboidModel(new Vector3f(4f, 0f, 6f), new Vector3f(1f, 3f, 1f)));
        scene.addObject(Utils.createCuboidModel(new Vector3f(4f, 0f, 8f), new Vector3f(1f, 5f, 1f)));
        scene.addObject(Utils.createCuboidModel(new Vector3f(6f, 0f, 6f), new Vector3f(1f, 4f, 1f)));
        scene.addObject(Utils.createCuboidModel(new Vector3f(6f, 0f, 8f), new Vector3f(1f, 6f, 1f)));

        Application app = new Application(camera, scene);
        app.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

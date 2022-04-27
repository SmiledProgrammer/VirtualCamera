package pl.szinton.gk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Application extends JFrame {

    protected final static int DEFAULT_WIDTH = 800;
    protected final static int DEFAULT_HEIGHT = 600;

    protected final Scene scene;

    public Application(Scene scene) {
        this.scene = scene;
        this.setTitle("Virtual Camera");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Component component = (Component) e.getSource();
                scene.updateFrameSize(new Vector2i(component.getWidth(), component.getHeight()));
            }
        });
    }

    public void run() {
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        scene.render(g);
    }

    public static void main(String[] args) {
        Vector3f initialPosition = new Vector3f(2f, 1f, 3f);
        Vector2i frameSize = new Vector2i(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Camera3D camera = new Camera3D(frameSize, initialPosition);
        Scene scene = new Scene(camera);

        scene.addObject(Utils.createCuboidModel(new Vector3f(4f, 0f, 6f), new Vector3f(1f, 3f, 1f)));
        scene.addObject(Utils.createCuboidModel(new Vector3f(4f, 0f, 8f), new Vector3f(1f, 5f, 1f)));
        scene.addObject(Utils.createCuboidModel(new Vector3f(6f, 0f, 6f), new Vector3f(1f, 4f, 1f)));
        scene.addObject(Utils.createCuboidModel(new Vector3f(6f, 0f, 8f), new Vector3f(1f, 6f, 1f)));

        Application app = new Application(scene);
        app.run();
    }
}

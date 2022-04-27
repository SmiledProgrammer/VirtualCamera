package pl.szinton.gk;

public class Camera3D {

    private Vector2i frameSize;
    private Vector3f position;
    private Vector3f rotation;
    private float nearPlane;
    private float farPlane;

    public Camera3D(Vector2i frameSize, Vector3f position) {
        this.frameSize = frameSize;
        this.position = position;
        this.rotation = new Vector3f();
        this.nearPlane = 1f;
        this.farPlane = 100f;
    }

    public Vector2i projectPoint(Vector3f point) {
        // TODO
        return null; // tmp
    }

    public void setFrameSize(Vector2i frameSize) {
        this.frameSize = frameSize;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public void setNearPlane(float nearPlane) {
        this.nearPlane = nearPlane;
    }

    public void setFarPlane(float farPlane) {
        this.farPlane = farPlane;
    }
}

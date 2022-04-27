package pl.szinton.gk;

public class Vector3f {

    private float x;
    private float y;
    private float z;

    public Vector3f() {
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f negative() {
        return new Vector3f(-x, -y, -z);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}

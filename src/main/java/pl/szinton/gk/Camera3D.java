package pl.szinton.gk;

import org.ejml.simple.SimpleMatrix;

public class Camera3D {

    private Vector2i frameSize;
    private Vector3f position;
    private Vector3f rotation;
    private float zoom;
    private SimpleMatrix transformationMatrix;

    public Camera3D(Vector2i frameSize, Vector3f position) {
        this.frameSize = frameSize;
        this.position = position;
        this.rotation = new Vector3f();
        this.zoom = 10f;
        updateTransformationMatrix();
    }

    public Vector2i projectPoint(Vector3f point) {
        SimpleMatrix pointVector = new SimpleMatrix(4, 1, true, new float[]{
                point.getX(), point.getY(), point.getZ(), 1f
        });
        SimpleMatrix transformedVector = transformationMatrix.mult(pointVector);
        Vector3f normalizedVector = Utils.normalizeVectorFromMatrix(transformedVector);

//        System.out.println(transformedVector);
//        System.out.println(normalizedVector.getX() + "  " + normalizedVector.getY() + "  " + normalizedVector.getZ());

        int x = (int) (normalizedVector.getX() * frameSize.getX());
        int y = (int) (normalizedVector.getY() * frameSize.getY());

        return new Vector2i(x, y);
    }

    public void setFrameSize(Vector2i frameSize) {
        this.frameSize = frameSize;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
        updateTransformationMatrix();
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
        updateTransformationMatrix();
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
        updateTransformationMatrix();
    }

    private void updateTransformationMatrix() {
        transformationMatrix = Matrix.projection(zoom).mult(
                Matrix.rotationZ(rotation.getZ()).mult(
                        Matrix.rotationY(rotation.getY()).mult(
                                Matrix.rotationX(rotation.getX()).mult(
                                        Matrix.translation(position.negative())
                                )
                        )
                )
        );
    }
}

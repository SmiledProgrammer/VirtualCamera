package pl.szinton.gk;

import org.ejml.simple.SimpleMatrix;

public class Matrix {

    public static SimpleMatrix translation(Vector3f vector) {
        return new SimpleMatrix(4, 4, false, new float[] {
                1f, 0f, 0f, vector.getX(),
                0f, 1f, 0f, vector.getY(),
                0f, 0f, 1f, vector.getZ(),
                0f, 0f, 0f, 1f
        });
    }
}

/**
 * Copyright (c) 1999-2014. All Rights Reserved.
 */
package com.logicgame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <class>Matrix</class> class presents 3D matrix movement: right rotation and right shifting.
 * Date: 6/30/2014
 * Time: 9:21 PM
 *
 * @author barbarous
 */
public class Matrix {

    /**
     * dimension
     */
    private final int D;
    protected int[][][] matrix;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    Matrix(int[][][] m) {
        D = m.length;
        matrix = m;
    }

    int[][][] get3DArray() {
        return matrix;
    }

    /**
     * right 90 degree matrix rotation
     * invert Z to Y
     */
    public void rotateX() {
        int [][][] _matrix = new int [D][D][D];
        for (int x = 0; x < D; x++ ) {
            for (int y = 0; y < D; y++) {
                for(int i = 0; i < D; i++)
                    _matrix[i][x][D-1-y] = matrix[y][x][i];
            }
        }
        matrix = _matrix;
    }

    /**
     * right 90 degree matrix rotation
     * invert Z to X
     */
    public void rotateY() {
        int [][][] _matrix = new int [D][D][D];
        for (int y = 0; y < D; y++ ) {
            for (int x = 0; x < D; x++) {
                for(int i = 0; i < D; i++)
                    _matrix[y][D -1-i][x] = matrix[y][x][i];
            }
        }
        matrix = _matrix;
    }

    /**
     * right 90 degree matrix rotation
     * invert X to Y
     */
    public void rotateZ() {
        int [][][] _matrix = new int [D][D][D];
        int d = matrix.length;
        for (int z = 0; z < d; z++ ) {
            for (int x = 0; x < d; x++) {
                for(int i = 0; i < d; i++)
                    _matrix[d-1-i][x][z] = matrix[x][i][z];
            }
        }
        matrix = _matrix;

    }

    /**
     * X axis right shift
     * @return true if shift is possible
     */
    public boolean shiftX(){
        for (int y = 0; y < D; y++ ) {
            if (IntStream.of(matrix[y][D-1]).sum() > 0)
                return false;
        }
        int [][][] _matrix = new int [D][D][D];
        for (int y = 0; y < D; y++ ) {
            for (int x = 0; x < D; x++) {
                _matrix[y][x+1] = matrix[y][x];
            }
        }
        matrix = _matrix;
        return true;
    }

    /**
     * Y axis right shift
     * @return true if shift is possible
     */
    public boolean shiftY(){
        for (int x = 0; x < D; x++ ) {
            if (IntStream.of(matrix[D-1][x]).sum() > 0)
                return false;
        }
        int [][][] _matrix = new int [D][D][D];
        for (int x = 0; x < D; x++ ) {
            for (int y = 0; y < D; y++) {
                _matrix[y+1][x] = matrix[y][x];
            }
        }
        matrix = _matrix;
        return true;
    }

    public Matrix sum(Matrix m) {
        int[][][]m_arr = m.get3DArray();
        int[][][] sum = new int[D][D][D];
        for (int x = 0; x < matrix.length; x++) {
            int[][] row = matrix[x];
            for (int y = 0; y < row.length; y++) {
                int[] zs = row[y];
                for (int z = 0; z < zs.length; z++) {
                    sum[x][y][z] = matrix[x][y][z] + m_arr[x][y][z];
                }
            }
        }
        return new Matrix(sum);
    }

    /**
     * True, if matrix contains only 1.
     * @return true if array has zero
     */
    public boolean hasOnlyOne() {
        List<Integer> flatten = flatten3D(matrix);
        return !(flatten.contains(0) || flatten.contains(2));
    }


    /**
     * True, if matrix contains only 1.
     * @return true if array has zero
     */
    public boolean has2() {
        List<Integer> flatten = flatten3D(matrix);
        return flatten.contains(2);
    }


    public static ArrayList<Integer> flatten3D(int[][][] matrix) {
        ArrayList<Integer> flatten = new ArrayList<>();
        for (int[][] row : matrix) {
            for (int[] column : row) {
                for (int atom : column)
                    flatten.add(atom);
            }
        }
        return flatten;
    }
}

/**
 * Copyright (c) 1999-2014. All Rights Reserved.
 */
package com.freespeech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <class>Shape</class> class is a wrapper of the Matrix class.
 * Date: 6/30/2014
 * Time: 3:04 PM
 *
 * @author Si
 */
public class Shape {
    Matrix matrix;
    private final String name;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    Shape(String name, Matrix m){
        this.matrix = m;
        this.name = name;
    }

    public Matrix getMatrix(){
        return matrix;
    }

    public String print(){
        StringBuilder out = new StringBuilder();
        out.append("\n");
        for (int[][] row : matrix.get3DArray()) {
            for (int[] zs : row) {
                for (Integer z : zs) {
                    out.append(z).append(" ");
                }
                out.append("   ");
            }
            out.append("\n");
        }
        return out.deleteCharAt(out.length() - 1).toString();
    }

    public void rotateX(){
        logger.debug("90 degree X-axis shape '{}' rotation: {}", name, print());
        matrix.rotateX();
    }

    public void rotateY(){
        logger.debug("90 degree Y-axis shape '{}' rotation: {}", name, print());
        matrix.rotateY();
    }

    public void rotateZ(){
        logger.debug("90 degree Z-axis shape '{}' rotation: {}", name, print());
        matrix.rotateZ();
    }

    public Shape join(Shape shape){
        logger.debug("join shapes");
        return new Shape("sum", matrix.sum(shape.getMatrix()));
    }

    public boolean isAssembled(){
        return matrix.hasOnlyOne();
    }
    public boolean hasOverlappedBlock(){
        return matrix.has2();
    }
}

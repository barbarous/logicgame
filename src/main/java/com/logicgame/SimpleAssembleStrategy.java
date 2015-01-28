/**
 * Copyright (c) 1999-2014. All Rights Reserved.
 */
package com.logicgame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * <class>SimpleCombinativeStrategy</class> class.
 * Date: 8/6/2014
 * Time: 9:07 PM
 *
 * @author barbarous
 */
public class SimpleAssembleStrategy {
    protected final static Logger logger = LoggerFactory.getLogger(SimpleAssembleStrategy.class);
    private ArrayList<Shape> shapes = new ArrayList<>();

    /**
     * add new shape
     * @param shape that will be assembled to this one
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }

    /**
     * assemble assembling join
     */
    public void assemble(){
        asm();
    }
    protected void asm(){

    }

    /**
     * recursive joining of shapes
     * @param shape this shape is the summed shape.
     * @param i index of the next shape that has not been joined yet.
     */
    protected boolean join(Shape shape, int i){
       return false;
    }


}

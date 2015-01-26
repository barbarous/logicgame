/**
 * Copyright (c) 1999-2014. All Rights Reserved.
 */
package com.freespeech;

/**
 * <class>ShapeFactory</class> class.
 * Date: 7/1/2014
 * Time: 10:24 PM
 *
 * @author Si
 */
public class ShapeFactory {

    public static Shape simpleShape1(String name){
        return new Shape(name, new Matrix(
                new int [][][]{
                        {{1, 1}, {1, 0}},
                        {{1, 0}, {0, 0}}
                }
        ));
    }

    public static Shape simpleShape2(String name){
        return new Shape(name, new Matrix(
                new int [][][]{
                        {{0, 1, 1}, {1, 1, 1}, {1, 1, 1}},
                        {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
                        {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}
                }
        ));
    }

    public static Shape simpleShape3(String name){
        return new Shape(name, new Matrix(
                new int [][][]{
                        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}}
                }
        ));
    }

}

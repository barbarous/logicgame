/**
 * Copyright (c) 1999-2014. All Rights Reserved.
 */
package com.logicgame.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <class>Main</class> class.
 * Date: 6/30/2014
 * Time: 3:36 PM
 *
 * @author barbarous
 */
public class Main{
    protected final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.simpleShape2("static");
        Shape shape2 = ShapeFactory.simpleShape3("rotated");


        SimpleAssembleStrategy strategy = new SimpleAssembleStrategy();
        strategy.addShape(shape1);
        strategy.addShape(shape2);

        Date start = new Timestamp(new Date().getTime());
        strategy.assemble();
        Date end = new Timestamp(new Date().getTime());
        logger.info("Time (ms.): {}", String.valueOf(TimeUnit.MILLISECONDS.toMillis(end.getTime() - start.getTime())));
    }
}

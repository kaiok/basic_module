package com.kais.crazy_java.chapter09.summary_9_3;

import lombok.var;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kais
 * @date 2022.08.22. 13:26
 */
public class Canvas {
    //	// 同时在画布上绘制多个形状
//	public void drawAll(List<Shape> shapes)
//	{
//		for (Shape s : shapes)
//		{
//			s.draw(this);
//		}
//	}
    // 同时在画布上绘制多个形状，使用被限制的泛型通配符
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw(this);
        }
    }
    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        List<Rectangle> rectangles = new ArrayList<>();
        var c = new Canvas();
        c.drawAll(rectangles);
        // 由于List<Circle>并不是List<Shape>的子类型,
        // 所以下面代码引发编译错误
        c.drawAll(circleList);
    }
}
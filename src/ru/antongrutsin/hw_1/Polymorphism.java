package ru.antongrutsin.hw_1;

import java.util.ArrayList;

interface Drawable {
    void draw();
}

interface Movable {
    void move();
}

abstract class Shape implements Drawable, Movable{
    public void action(){
        draw();
        move();
    }
}

class Circle extends Shape{
    private Integer radius;
    private Float vector;

    public Circle(Integer radius, Float vector) {
        this.radius = radius;
        this.vector = vector;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем с заданным радиусом");
    }

    @Override
    public void move() {
        System.out.println("Двигаем с заданым ветором");
    }
}

class Square extends Shape{
    private Integer edge;
    private Float vector;

    public Square(Integer edge, Float vector) {
        this.edge = edge;
        this.vector = vector;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем с заданным ребром");
    }

    @Override
    public void move() {
        System.out.println("Двигаем с заданым ветором");
    }
}

class Triangle extends Shape{
    private Integer edgeOne;
    private Integer edgeTwo;
    private Integer edgeThree;
    private Float vector;

    public Triangle(Integer edgeOne, Integer edgeTwo, Integer edgeThree, Float vector) {
        this.edgeOne = edgeOne;
        this.edgeTwo = edgeTwo;
        this.edgeThree = edgeThree;
        this.vector = vector;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем с заданными ребрами");
    }

    @Override
    public void move() {
        System.out.println("Двигаем с заданым ветором");
    }
}

public class Polymorphism {
    public static void main(String[] args){
        ArrayList<Shape> list_of_shapes = new ArrayList();

        list_of_shapes.add(new Circle(10, 5F));
        list_of_shapes.add(new Triangle(1,2,3,8f));
        list_of_shapes.add(new Square(2, 2F));

        for (Shape shape : list_of_shapes) {
            shape.action();
        }
    }

}

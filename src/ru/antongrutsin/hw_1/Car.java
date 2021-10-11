package ru.antongrutsin.hw_1;

interface Moveable {
    void move();
}

interface Stopable {
    void stop();
}

//для оптимизации имплементировать интерфейс Moveable
//public abstract class Car {
public abstract class Car implements Moveable{

    //заменить уровень доступа на private
    //public Engine engine;
    private Engine engine;
    private String color;
    private String name;

    protected void start(){
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Engine {
}

//Можно убрать имплементацию Moveable
//public class LightWeightCar extends Car implements Moveable{
class LightWeightCar extends Car{

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

//нельзя расширять Интерфейс, его можно только имплементировать
//Можно убрать имплементацию Moveable
//public class Lorry extends Car, Moveable, Stopable{
class Lorry extends Car implements Stopable{

    //требуется реализовать метод open
    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
}
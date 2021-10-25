package ru.antongrutsin.hw_4;

public class Main {

    private static final SQLManager request = new SQLManager();

    public static void main(String[] args) {
        System.out.println(request.getQuery1());
//        System.out.println(request.getQuery2());
        System.out.println(request.getQuery3());
    }
}

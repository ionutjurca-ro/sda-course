package com.sda.homework;

public class Main {
    public static void main(String[] args) {
        Car car = getCar();
        car.setBrand("audi");
        System.out.println(car.getBrand());
        calculate(123);
    }

    private static Car getCar() {
        return new Car();
    }

    private static Integer calculate(Integer text) {
        return text;
    }
}

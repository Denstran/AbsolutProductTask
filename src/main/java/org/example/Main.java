package org.example;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("тесто");
        Product p2 = new Product("Мука");
        Product p3 = new Product("Яйца");
        Product p4 = new Product("Пшеница");
        Product p5 = new Product("Вода");

        System.out.println(p1.addProduct(p2));  // true
        System.out.println(p1.addProduct(p3));  // true
        System.out.println(p2.addProduct(p4));  // true
        System.out.println(p2.addProduct(p1));  // false (цикл: "Мука" -> "тесто")
        System.out.println(p1.addProduct(p5));  // true
        System.out.println(p1.addProduct(p1));  // false (нельзя добавить самого себя)
    }
}
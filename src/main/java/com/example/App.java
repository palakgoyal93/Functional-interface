package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setProductName("Iphone14");
        product1.setPrice(100000);
        product1.setStock(6);


        Product product2 = new Product();
        product2.setProductName("Body Lotion Nivea 200ml");
        product2.setPrice(140);
        product2.setStock(50);

        Product product3 = new Product();
        product3.setProductName("Coke 1l");
        product3.setPrice(135);
        product3.setStock(100);

        Product product4 = new Product();
        product4.setProductName("Hair Clip");
        product4.setPrice(8);
        product4.setStock(30);

        Product product5 = new Product();
        product5.setProductName("Marabou chocolate");
        product5.setPrice(180);
        product5.setStock(0);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);


        actionAndCondition(productList, product -> product.getStock() == 0, product -> System.out.println(product));
        System.out.println("---------------");


        actionAndCondition(productList, product -> product.getProductName().startsWith("B"), product -> System.out.println(product));
        System.out.println("-----------------");

        actionAndCondition(productList, product -> product.getPrice() > 100 && product.getPrice() < 150, product -> System.out.println(product));

        System.out.println("----------------------");


        actionAndCondition(productList, product-> product.getStock() < 10 && product.getStock() > 0, product ->
        {
            product.setPrice(product.getPrice()+ product.getPrice()/2 );
            System.out.println(product);}
        );
    }

    public static void actionAndCondition(List<Product> allProducts, Conditional conditional, Action action) {

        for (Product product : allProducts) {
            if (conditional.test(product)) {
                action.execute(product);
            }
        }
    }

}

package org.example.proxy;

public class Lenovo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("pay "+money);
        return "电脑";
    }

    @Override
    public void show() {
        System.out.println("show...");
    }
}

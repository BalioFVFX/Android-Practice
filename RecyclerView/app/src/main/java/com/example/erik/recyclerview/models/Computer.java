package com.example.erik.recyclerview.models;

public class Computer {
    private String name;
    private String cpu;
    private String ram;
    private Double price;

    public Computer(String name, String cpu, String ram, Double price) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

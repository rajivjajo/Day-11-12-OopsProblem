package com.bridgelabz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    private String name;
    private int shares;
    private double price;

    public Stock(String name, int shares, double price) {
        this.name = name;
        this.shares = shares;
        this.price = price;
    }

    public double value() {
        return shares * price;
    }

    public String getName() {
        return name;
    }

    public int getShares() {
        return shares;
    }

    public double getPrice() {
        return price;
    }
}

class Portfolio {
    ArrayList<Stock> stocks;

    public Portfolio() {
        stocks = new ArrayList<Stock>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double totalValue() {
        double total = 0;
        for (Stock stock : stocks) {
            total += stock.value();
        }
        return total;
    }
}

public class StockAccountManagement {

    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();

        // read in stock data from file
        try {
            Scanner fileScanner = new Scanner(new File("stock_data.txt"));
            while (fileScanner.hasNextLine()) {
                String[] line = fileScanner.nextLine().split(",");
                String name = line[0];
                int shares = Integer.parseInt(line[1]);
                double price = Double.parseDouble(line[2]);
                Stock stock = new Stock(name, shares, price);
                portfolio.addStock(stock);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // print stock report
        System.out.println("Stock Report:");
        for (Stock stock : portfolio.stocks) {
            System.out.println("Stock: " + stock.getName());
            System.out.println("Shares: " + stock.getShares());
            System.out.println("Price: " + stock.getPrice());
            System.out.println("Value: " + stock.value());
        }

        System.out.println("Total value of stocks: " + portfolio.totalValue());
    }
}
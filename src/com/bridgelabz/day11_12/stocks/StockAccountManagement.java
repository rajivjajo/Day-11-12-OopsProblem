package com.bridgelabz.day11_12.stocks;
import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String name;
    int numberOfShares;
    double sharePrice;
    double value;

    public Stock(String name, int numberOfShares, double sharePrice) {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
        this.value = numberOfShares * sharePrice;
    }
}

class StockPortfolio {
    ArrayList<Stock> stocks;
    double totalValue;

    public StockPortfolio() {
        stocks = new ArrayList<Stock>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void calculateTotalValue() {
        totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.value;
        }
    }
}

public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.println("Enter number of stocks:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter stock name:");
            String name = sc.nextLine();
            System.out.println("Enter number of shares:");
            int numberOfShares = sc.nextInt();
            System.out.println("Enter share price:");
            double sharePrice = sc.nextDouble();
            sc.nextLine();

            Stock stock = new Stock(name, numberOfShares, sharePrice);
            portfolio.addStock(stock);
        }

        portfolio.calculateTotalValue();

        System.out.println("Stock Report:");
        for (Stock stock : portfolio.stocks) {
            System.out.println(stock.name + " - Value: " + stock.value);
        }
        System.out.println("Total Value: " + portfolio.totalValue);
    }
}

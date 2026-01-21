public class Stock {
    private double currentVal;
    private final String abbr;
    private final String fullTitle;
    private int shares;
    private final int index;
    private static int stockNum = 0;
    public Stock(double start, String ab, String title){
        currentVal = start;
        abbr = ab;
        fullTitle = title;
        shares = 0;
        stockNum++;
        index = stockNum;
    }
    public static int getStockNum(){
        return stockNum;
    }
    public void playTheMarkets(){
        int bigChoice = (int)(Math.random() * 20) + 1;
        int lilChoice = (int)(Math.random() * 10) + 1;
        if (bigChoice == 1){
            switch (lilChoice){
                case 1 -> currentVal *= 0.01;
                case 2 -> currentVal *= 0.25;
                case 3 -> currentVal *= 0.4;
                case 4 -> currentVal *= 0.5;
                case 5,6 -> currentVal *= 0.6;
                case 7,8 -> currentVal *= 0.65;
                default -> currentVal *= 0.7;
            }
        }
        else if (bigChoice >= 2 && bigChoice <= 4){
            switch (lilChoice){
                case 1 -> currentVal *= 0.75;
                default -> currentVal *= 0.8;
                case 3,4 -> currentVal *= 0.85;
                case 5,6 -> currentVal *= 0.88;
                case 7,8 -> currentVal *= 0.9;
                case 9,10 -> currentVal *= 0.92;
            }
        }
        else if (bigChoice >= 5 && bigChoice <= 8){
            switch (lilChoice){
                case 1,2 -> currentVal *= 0.95;
                default -> currentVal *= 0.96;
                case 5,6,7 -> currentVal *= 0.97;
                case 8,9,10 -> currentVal *= 0.98;
            }
        }
        else if (bigChoice >= 9 && bigChoice <= 12){
            switch (lilChoice){
                case 1,2,3 -> currentVal *= 0.99;
                default -> currentVal *= 1;
                case 8,9,10 -> currentVal *= 1.01;
            }

        }
        else if (bigChoice >= 13 && bigChoice <= 16){

            switch (lilChoice){
                case 1, 2, 3 -> currentVal *= 1.02;
                case 4, 5, 6 -> currentVal *= 1.03;
                case 7, 8 -> currentVal *= 1.04;
                default -> currentVal *= 1.05;

            }

        }
        else if (bigChoice >= 17 && bigChoice <= 19){
            switch (lilChoice){
                case 1, 2 -> currentVal *= 1.08;
                case 3, 4 -> currentVal *= 1.1;
                case 5, 6 -> currentVal *= 1.12;
                case 7, 8 -> currentVal *= 1.15;
                case 9 -> currentVal *= 1.2;
                default -> currentVal *= 1.25;
            }

        }
        else{
            switch (lilChoice){
                case 1, 2 -> currentVal *= 1.3;
                case 3, 4 -> currentVal *= 1.35;
                case 5, 6 -> currentVal *= 1.4;
                case 7 -> currentVal *= 1.5;
                case 8 -> currentVal *= 1.75;
                case 9 -> currentVal *= 2;
                default -> currentVal *= 2.5;
            }

        }
        StockHelper.rounder(currentVal, 3);
        if (currentVal <= 0.0000001){
            currentVal = 0.01;
        }
    }
    public int getIndex(){
     return index;   
    }
    public double buy (int amt){
        amt = Math.abs(amt);
       for (int i = 1; i <= amt; i++){
            shares++;
       }
       return -1 * (currentVal * amt);
    }
    public double sell (int amt){
        amt = Math.abs(amt);
        for (int i = 1; i <= amt; i++){
            if (shares > 0){
                shares --;  
            }
            else{
                return 0.0;
            }
        }
        return (currentVal * amt);
    }
    @Override
    public String toString(){
        return fullTitle + " (" + abbr + "): $" + currentVal + " (have "+ shares + " shares)";
    }
}
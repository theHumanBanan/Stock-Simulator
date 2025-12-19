import java.util.Scanner;

public class StockRunner{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gameChoice = 0;
        while (gameChoice != 1){
            System.out.println("Welcome to Stock Simulator! What do you want to do?\n1. Play!\n2. Credits\n3. Changelog\n");
            gameChoice = input.nextInt();
            switch (gameChoice) {
                case 1 -> run();
                case 2 -> StockHelper.credits();
                case 3 -> StockHelper.changeLog();
                default -> System.out.println("Alright buddy.");
            }
        }
    }
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many actions do you want the game to last?");
        int act = input.nextInt();
        if (act > 500){
            System.out.println("Oh brother, this guy STINKS!");
            return;
        }
        double money = 100;
        Stock oog = new Stock(10, "OOG", "Orbital Onion Games", 1);
        Stock midl = new Stock(50, "MIDL", "Midas ID Corp., LLC", 2);
        Stock gud = new Stock(200, "GUD", "Goorpen-Uutkar Development", 3);
        Stock woah = new Stock(1000, "WOAH", "We Open All Houses Sales", 4);
        for (int i = 1; i <= act; i++){
            System.out.println("\n" + oog);
                System.out.println(midl);
                System.out.println(gud);
                System.out.println(woah);
                System.out.println("\nAction " + i + " of " + act);
                System.out.println("\nYou have $" + money + "\nWhat stock do you want to take part in? (pick a number)\n1. OOG\n2. MIDL\n3. GUD\n4. WOAH\n5. Pass");
                int stockChoice = input.nextInt();
                if(stockChoice != 5){
                    System.out.println("Buy(1) or Sell(2)?");
                    int payChoice = input.nextInt();
                    input.nextLine();
                    System.out.println("How many?");
                    int buySellAmt = input.nextInt();
                    input.nextLine();
                    if (stockChoice == 1){
                        if (payChoice == 1){
                            money += oog.buy(buySellAmt);
                        }
                        else{
                            money += oog.sell(buySellAmt);
                        }
                    }
                    else if (stockChoice == 2){
                        if (payChoice == 1){
                            money += midl.buy(buySellAmt);
                        }
                        else{
                            money += midl.sell(buySellAmt);
                        }
                    
                        }
                    else if (stockChoice == 3){
                        if (payChoice == 1){
                            money += gud.buy(buySellAmt);
                        }
                        else{
                            money += gud.sell(buySellAmt);
                        }
                    
                        }    
                    else if (stockChoice == 4){
                        if (payChoice == 1){
                            money += woah.buy(buySellAmt);
                        }
                        else{
                            money += woah.sell(buySellAmt);
                        }
                    
                        }
                    else{
                        money = -1;
                    }
                    
                }
                else{
                    money += 0;
                }
                oog.playTheMarkets();
                midl.playTheMarkets();
                gud.playTheMarkets();
                woah.playTheMarkets();
                StockHelper.rounder(money, 2);
                if (money < 0){
                    System.out.println("DEBT!!!");
                    return;
                }


            }
            double avgPrft = ((double)(money - 100) / act);
        System.out.println("Congratulations! You played the game for " + act + " actions, and turned your $100 into about $" + (int)money + "! That's a profit of about " + ((int)money - 100) + " and an average profit of " + avgPrft + "! Press enter to continue.");
        input.nextLine();
        System.out.println("\nAre you enrolled in the ranked StockSim program?(yes/no)");
        String rnkQ = input.nextLine();
        if (rnkQ.equals("yes")){
            double xpBase = 10 * (avgPrft * (act / 15.0));
            int xp = (int)Math.round(xpBase);
            System.out.println("You have gained " + xp + " XP this run! \nScreenshot this and add it to your ranked doc! \nPeople's ranks update by 6 PM Eastern on days that I can update it.");
            //a 15 action game with a 0.5 average profit returns 5 XP
        }
        else if (rnkQ.equals("no")){
            System.out.println("Would you like to enroll?");
            String enrlQ = input.nextLine();
            if (enrlQ.equals("yes")){
                System.out.println("\nFollow these instructions:");
                System.out.println("Step 1. Create a new Google Doc.");
                System.out.println("Step 2. Add everyone with the link as a viewer.");
                System.out.println("Step 3. Link your document to the master document. Rename the link your name.");
                System.out.println("Master Document Link: https://docs.google.com/document/d/1Dbq3noAziL6wuEpmpAkoYeaQRUo0OXNWdQo9dL_hB54/edit?pli=1&tab=t.0");
                System.out.println("Step 4. Play games and climb the ranks!");
                
            }
            else{
                System.out.println("Okay, fine.");
            }
            System.out.println("Would you like to play again? (true/false)");
            boolean playAgain = input.nextBoolean();
            if (playAgain){
                run();
            }
        }
        else{
            System.out.println("Goober.");
        }
        System.out.println("Would you like to play again? (true/false)");
        boolean playAgain = input.nextBoolean();
        if (playAgain){
                run();
            }
        }    
        }    

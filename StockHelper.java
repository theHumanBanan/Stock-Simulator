public class StockHelper{
    public static void credits(){
        System.out.println("Stock Simulator v0.2a");
        System.out.println("Game developed by Liam O'Carra\n");
        System.out.println("Thanks, playtesters!");
    }
    public static void changeLog(){
        System.out.println("access previous code here - codehs.com/sandbox/liamocarra/stock-simulator-v01a");
        System.out.println("v0.1a - 15 Dec 2025 - \"ported\" to VSCode from CodeHS");
        System.out.println("v0.2a - 6 Jan 2026 - Added custom stock creation, other tweaks");
    }
    public static double rounder(double begin, int deci){
        if (deci >= 7){
            return begin;
        }
        double scale = Math.pow(10, deci);
        double bigNum = begin * scale;
        long rounded = Math.round(bigNum);
        double fnL = (double)rounded / scale;
        return fnL;
    }
}
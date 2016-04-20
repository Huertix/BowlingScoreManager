package com.dev.bowling;

public class Main {

    public static void main(String[] args){
        GameController gc = new GameController();

        if(args.length < 12 || args.length > 21) {
            System.out.println("Input Error: Please review arguments");
            System.out.println("E.g: java -jar BowlingGame.jar 5 2 8 1 10 3 2 10 10 1 6 10 2 6 10 4 5");
        } else {
            for (String arg: args) {
                gc.newThrow(Integer.parseInt(arg));
            }
            gc.printScores();
        }
    }
}
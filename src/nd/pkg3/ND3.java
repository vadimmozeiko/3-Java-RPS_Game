package nd.pkg3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ND3 {
private static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------Rock Paper Scissors Game-----------");
        System.out.println();
        System.out.println("Please choose game mode:");
        System.out.println();
        System.out.println("'1' - Player vs Computer");
        System.out.println();
        System.out.println("'2' - Computer vs Computer");
        System.out.println();
        int gameMode = sc.nextInt();

        if (gameMode == 1) {
            System.out.println("Please choose yours:");
            System.out.println();
            System.out.println("'1' for Rock");
            System.out.println("'2' for Paper");
            System.out.println("'3' for Scissors");
            System.out.println();
            System.out.println("'4' for statistics");
            System.out.println();
            System.out.println("'0' for exit");
            System.out.println();

            int input;
            int playerWon = 0;
            int computerWon = 0;
            int tie = 0;

            do {
                System.out.println("Enter your choice:");
                input = sc.nextInt();
                if (input > 4 || input < 0) {
                    System.out.println("Something went wrong...");
                } else if (input == 0 || input == 4) {
                    System.out.println();
                    System.out.println("-----------STATISTICS-----------");
                    System.out.println();
                    System.out.println("Player won: " + playerWon);
                    System.out.println("Computer won: " + computerWon);
                    System.out.println("Tie " + tie);
                    System.out.println();
                } else {
                    double computerInput = Math.random();
                    int computerChoice = (int) (computerInput * 3 + 1);
                    System.out.println(computerChoice);

                    if (computerChoice == 1) {
                        if (input == 1) {
                            System.out.println("TIE");
                            tie++;
                        } else if (input == 2) {
                            System.out.println("Player WON");
                            playerWon++;
                        } else if (input == 3) {
                            System.out.println("Computer WON");
                            computerWon++;
                        }
                    } else if (computerChoice == 2) {
                        if (input == 1) {
                            System.out.println("Computer WON");
                            computerWon++;
                        } else if (input == 2) {
                            System.out.println("TIE");
                            tie++;
                        } else if (input == 3) {
                            System.out.println("Player WON");
                            playerWon++;
                        }
                    } else if (computerChoice == 3) {
                        if (input == 1) {
                            System.out.println("Player WON");
                            playerWon++;
                        } else if (input == 2) {
                            System.out.println("Computer WON");
                            computerWon++;
                        } else if (input == 3) {
                            System.out.println("TIE");
                            tie++;
                        }
                    }
                }
            } while (input != 0);
        }
        int howManyGames;
        int currentGame = 0;
        int firstComputerWon = 0;
        int secondComputerWon = 0;
        int tie = 0;
        if (gameMode == 2) {
            System.out.println();
            System.out.println("How many games to play?");
            howManyGames = sc.nextInt();
            do {
                double firstComputerInput = Math.random();
                double secondComputerInput = Math.random();
                int firstComputerChoice = (int) (firstComputerInput * 3 + 1);
                int secondComputerChoice = (int) (secondComputerInput * 3 + 1);
                if (firstComputerChoice == 1) {
                    if (secondComputerChoice == 1) {
                        currentGame++;
                        tie++;
                    } else if (secondComputerChoice == 2) {
                        currentGame++;
                        secondComputerWon++;
                    } else if (secondComputerChoice == 3) {
                        currentGame++;
                        firstComputerWon++;
                    }
                } else if (firstComputerChoice == 2) {
                    if (secondComputerChoice == 1) {
                        currentGame++;
                        firstComputerWon++;
                    } else if (secondComputerChoice == 2) {
                        currentGame++;
                        tie++;
                    } else if (secondComputerChoice == 3) {
                        currentGame++;
                        secondComputerWon++;
                    }
                } else if (firstComputerChoice == 3) {
                    if (secondComputerChoice == 1) {
                        currentGame++;
                        secondComputerWon++;
                    } else if (secondComputerChoice == 2) {
                        currentGame++;
                        firstComputerWon++;
                    } else if (secondComputerChoice == 3) {
                        currentGame++;
                        tie++;
                    }
                }

            } while (currentGame != howManyGames);

            float firstComputerStatistic = (firstComputerWon * 100f) / howManyGames;
            float secondComputerStatistic = (secondComputerWon * 100f) / howManyGames;
            float tieStatistic = (tie * 100f) / howManyGames;

            System.out.println();
            System.out.println("-----------STATISTICS-----------");
            System.out.println();
            System.out.println("First computer won: " + firstComputerWon);
            System.out.println("Second computer won: " + secondComputerWon);
            System.out.println("Tie: " + tie);
            System.out.println();
            System.out.println("First computer result: " + df.format(firstComputerStatistic) + "%");
            System.out.println("Second computer result: " + df.format(secondComputerStatistic) + "%");
            System.out.println("Tie result: " + df.format(tieStatistic) + "%");
            System.out.println();
            if (firstComputerWon > secondComputerWon) {
                System.out.println("Total result: FIRST COMPUTER WON");
            } else {
                System.out.println("Total result: SECOND COMPUTER WON");
            }
        }
    }
}

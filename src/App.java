import java.util.Random;
import java.util.Scanner;

public class App {
    private static Scanner keyboard;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner keyboard = new Scanner(System.in);
        int option;

        printMainMenu();
        System.out.print(" PLEASE ENTER YOUR PREFERRED OPTION : ");
        option = keyboard.nextInt();
        while (option != 5)

        {
            if (option == 1) {
                playDiceComputer();
            } else if (option == 2) {
                playDice2Players();
            } else if (option == 3) {
                playGuessRandomNumber();
            } else if (option == 4) {
                playBlackJack();
            } else {
                System.out.println(" PLEASE ENTER YOUR PREFERRED OPTION [1,5] ");
            }
            printMainMenu();
            System.out.print(" PLEASE ENTER YOUR PREFERRED OPTION: ");
            option = keyboard.nextInt();
        }
        System.out.println("\n!!!!!!!!!!GOODBYE!!!!!!!!!!\n");
    }

    public static void printMainMenu() {
        System.out.println("\n\nWELCOME\n\n");
        System.out.println("\nPlay a Game ?\n");
        System.out.println("1. Dice Game against COMPUTER");
        System.out.println("2. Dice Game between two players");
        System.out.println("3. Guess the Random Number");
        System.out.println("4. BlackJack");
        System.out.println("5. Exit");
    }

    public static void playDiceComputer() {
        System.out.println("Dice Game against COMPUTER option chosen");
        keyboard = new Scanner(System.in);
        Random randComputer = new Random();
        Random randPlayer = new Random();

        int rounds;
        int diceComputer;
        int dicePlayer;
        int numComputer = 0;
        int numPlayer = 0;
        int numDraw = 0;
        String gameStatus = null;

        System.out.println("\n\n//////////WELCOME TO GAME 1//////////");
        System.out.println("HOW MANY ROUNDS :");
        rounds = keyboard.nextInt();

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\n ROUND :" + i);

            diceComputer = randComputer.nextInt(6) + 1;

            dicePlayer = randPlayer.nextInt(6) + 1;

            if (diceComputer > dicePlayer) {
                System.out.println("COMPUTER wins");
                numComputer++;
            } else if (diceComputer < dicePlayer) {
                System.out.println("PLAYER wins");
                numPlayer++;
            } else {
                System.out.println("ITS A DRAW");
                numDraw++;
            }

            if (numComputer > numPlayer) {
                gameStatus = " COMPUTER is the WINNER!!!! ";
            } else if (numPlayer > numComputer) {
                gameStatus = "  PLAYER is the  WINNER!!!! ";
            } else if (numComputer == numPlayer && numComputer == numDraw) {
                gameStatus = "  NO ONE is the  WINNER!!!! ";
            }
        }

        System.out.println("\n\nRESULT OF THE GAME\n\n:");
        System.out.println(" GAME WINNER:" + gameStatus);
        System.out.println(" NO OF WINS (PLAYER):" + numPlayer);
        System.out.println(" NO OF WINS (COMPUTER) :" + numComputer);
        System.out.println(" NO OF DRAWS IN THE GAME :" + numDraw);

    }

    public static void playDice2Players() {
        System.out.println("Dice Game between two players option chosen");
        Scanner keyboard = new Scanner(System.in);
        Random randPlayer1 = new Random();
        Random randPlayer2 = new Random();
        Random randComputer = new Random();

        int rounds;
        int guessNum1;
        int guessNum2;
        int dicePlayer1;
        int dicePlayer2;
        int diceComputer;
        int countDraw = 0;
        int countPlayer1 = 0;
        int countPlayer2 = 0;
        String gameStatus = null;

        System.out.println("\n\n//////////WELCOME TO GAME 2//////////\n\n");
        System.out.println("\n\n HOW MANY ROUNDS :");
        rounds = keyboard.nextInt();

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\n ROUND :" + i);
            System.out.println("!!!!!LETS SEE WHO GUESSES THE NUMBER CORRECT!!!!!");

            diceComputer = randComputer.nextInt(6) + 1;
            System.out.println("PLAYER 1 guess the number");
            guessNum1 = keyboard.nextInt();
            System.out.println("PLAYER 2 guess the number");
            guessNum2 = keyboard.nextInt();
            if (guessNum1 == diceComputer) {
                System.out.println("PLAYER 1 guessed it right!!!!!");
                countPlayer1++;
            } else if (guessNum2 == diceComputer) {
                System.out.println("PLAYER 2 guessed it right!!!!!");
                countPlayer2++;
            } else if (guessNum1 == diceComputer && guessNum2 == diceComputer) {
                System.out.println("ITS A DRAW!!!!!!");
                countDraw++;
            } else {
                System.out.println(" SORRY!!! the number was:" + diceComputer);
            }

        }
        if (countPlayer1 > countPlayer2) {
            gameStatus = " PLAYER 1 is the WINNER!!!! ";
        } else if (countPlayer2 > countPlayer1) {
            gameStatus = " PLAYER 2 is the  WINNER!!!! ";
        } else if (countPlayer1 == countPlayer2 && countDraw == countPlayer2) {
            gameStatus = "SORRY NO ONE WINS BETTER LUCK NEXT TIME!!!!!";
        }
        System.out.println("\n\nRESULT OF THE GAME\n\n:");
        System.out.println(" GAME WINNER : " + gameStatus);
        System.out.println(" NO OF WINS (PLAYER 1) : " + countPlayer1);
        System.out.println(" NO OF WINS (PLAYER 2) : " + countPlayer2);

    }

    public static void playGuessRandomNumber() {
        System.out.println("Guess the Random Number option chosen");
        Scanner keyboard = new Scanner(System.in);
        Random Computer = new Random();
        int numberRange;
        int rounds;
        int correctGuess = 0;
        int wrongGuess = 0;
        String gameStatus;
        int maxRandomNumber;
        int minRandomNumber;
        System.out.println("\n\n//////////WELCOME TO GAME 3//////////\n\n");
        System.out.println("!!!!!LETS SEE WHETHER YOU GUESS THE NUMBER CORRECT!!!!!");
        System.out.println("\n\n HOW MANY ROUNDS :");
        rounds = keyboard.nextInt();
        for (int i = 1; i <= rounds; i++) {
            System.out.println("PLEASE ENTER THE RANGE YOU WANNA PLAY!!!\n");
            System.out.println("maximun number:");
            maxRandomNumber = keyboard.nextInt();
            System.out.println("minimun number:");
            minRandomNumber = keyboard.nextInt();

            numberRange = maxRandomNumber - minRandomNumber;
            int computerNumber;
            computerNumber = Computer.nextInt(numberRange) + minRandomNumber;

            System.out.println("\n ROUND :" + i);
            int guessNumber = 0;
            int count = 1;
            int diff;
            int midValue = computerNumber / 2;

            while (guessNumber != computerNumber && count != 5) {
                System.out.println("\nenter your guess number:\n");
                guessNumber = keyboard.nextInt();
                diff = Math.abs(computerNumber - guessNumber);
                System.out.println("HERE'S SOME HINTS!!!");
                if (diff < guessNumber) {
                    System.out.println("your close from the number!!!");
                } else if (diff > guessNumber) {
                    System.out.println("your far from the number!!!");
                }

                else if (guessNumber > diff && guessNumber > midValue) {
                    System.out.println("your very close from the number!!!");
                } else {
                    System.out.println("your very far from the number!!!");
                }
                count++;
            }
            if (guessNumber == computerNumber) {
                System.out.println(" you guessed it RIGHT !!!" + computerNumber);
                correctGuess++;
            } else {
                System.out.println("\nSORRY YOUR CHANCE IS OVER!!!\n");
                System.out.println("\nTHE CORRECT NUMBER WAS: \n" + computerNumber);
                wrongGuess++;
            }

        }
        if (wrongGuess > correctGuess) {
            gameStatus = "YOU LOST";
        } else {
            gameStatus = "WINNER";
        }
        System.out.println("\n\nSTATISTICS OF THE GAME: ");
        System.out.println("your correct guesses: " + correctGuess);
        System.out.println("your wrong guesses: " + wrongGuess);
        System.out.println("your game status:" + gameStatus);
    }

    public static void playBlackJack() {
        System.out.println("BlackJack option chosen");
        System.out.println("\n\n//////////WELCOME TO GAME 4//////////\n\n");
        System.out.println("!!!!!LETS SEE WHETHER YOU WIN BLACKJACK!!!!!\n\n");
        String choice = "yes";

        while (choice.equalsIgnoreCase("yes")) {
            Scanner keyboard = new Scanner(System.in);
            Random rand = new Random();
            Random randsuit = new Random();

            int valueofCards;
            int valueforDealer;
            String valueofName = "";
            String valueNameforDealer = "";
            final double HIGHEST = 21;
            int totalofPlayer = 0;
            int totalofDealer = 0;
            int number = 0;
            int pointsforPlayer = 0;
            int pointsforDealer = 0;
            String ans = "";
            String suitName = null;

            for (int i = 1; i <= 2; i++) {

                int suitNumber = randsuit.nextInt(4) + 1;
                if (suitNumber == 1) {
                    suitName = "Diamonds";
                } else if (suitNumber == 2) {
                    suitName = "Hearts";
                } else if (suitNumber == 3) {
                    suitName = "Clubes";
                } else {
                    suitName = "Spades";
                }

                valueofCards = rand.nextInt(13) + 1;

                if (valueofCards == 1) {
                    valueofName = "Ace";
                    pointsforPlayer = 1;
                } else if (valueofCards == 11) {
                    valueofName = "Jack";
                    pointsforPlayer = 10;
                } else if (valueofCards == 12) {
                    valueofName = "Queen";
                    pointsforPlayer = 10;
                } else if (valueofCards == 13) {
                    valueofName = "King";
                    pointsforPlayer = 10;
                } else {
                    valueofName = Integer.toString(valueofCards);
                    pointsforPlayer = valueofCards;
                }

                totalofPlayer = totalofPlayer + pointsforPlayer;
                System.out.println("SO YOU GET : " + suitName + " " + valueofName);

            }

            System.out.println("YOUR TOTAL : " + totalofPlayer);

            for (int j = 1; j <= 2; j++)

            {
                valueforDealer = rand.nextInt(13) + 1;

                if (valueforDealer == 1) {
                    valueNameforDealer = "Ace";
                    pointsforDealer = 1;
                } else if (valueforDealer == 11) {
                    valueNameforDealer = "Jack";
                    pointsforDealer = 10;
                } else if (valueforDealer == 12) {
                    valueNameforDealer = "Queen";
                    pointsforDealer = 10;
                } else if (valueforDealer == 13) {
                    valueNameforDealer = "King";
                    pointsforDealer = 10;
                } else {
                    valueNameforDealer = Integer.toString(valueforDealer);
                    pointsforDealer = valueforDealer;
                }

                totalofDealer = totalofDealer + pointsforDealer;
                System.out.println("DEALER GETS : " + " " + valueNameforDealer);

            }

            System.out.println("TOTAL OF DEALER : " + totalofDealer);

            while (totalofDealer < 16) {
                valueforDealer = rand.nextInt(13) + 1;

                if (valueforDealer == 1) {
                    valueNameforDealer = "Ace";
                    pointsforDealer = 1;
                } else if (valueforDealer == 11) {
                    valueNameforDealer = "Jack";
                    pointsforDealer = 10;
                } else if (valueforDealer == 12) {
                    valueNameforDealer = "Queen";
                    pointsforDealer = 10;
                } else if (valueforDealer == 13) {
                    valueNameforDealer = "King";
                    pointsforDealer = 10;
                } else {
                    valueNameforDealer = Integer.toString(valueforDealer);
                    pointsforDealer = valueforDealer;
                }

                totalofDealer = totalofDealer + pointsforDealer;
                System.out.println("DEALER GETS : " + valueNameforDealer);
                System.out.println("TOTAL OF DEALER : " + totalofDealer);

                System.out.println("\n\nDO YOU WANNA DRAW A CARD ? (YES / NO)\n\n ");
                ans = keyboard.nextLine();
            }

            while (ans.equalsIgnoreCase("yes") && totalofPlayer < 21 && totalofDealer < 21) {
                valueofCards = rand.nextInt(13) + 1;

                if (valueofCards == 1) {
                    valueofName = "Ace";
                    pointsforPlayer = 1;
                } else if (valueofCards == 11) {
                    valueofName = "Jack";
                    pointsforPlayer = 10;
                } else if (valueofCards == 12) {
                    valueofName = "Queen";
                    pointsforPlayer = 10;
                } else if (valueofCards == 13) {
                    valueofName = "King";
                    pointsforPlayer = 10;
                } else {
                    valueofName = Integer.toString(valueofCards);
                    pointsforPlayer = valueofCards;
                }

                totalofPlayer = totalofPlayer + pointsforPlayer;
                System.out.println("You get : " + suitName + " " + valueofName);
                System.out.println("Total number you get : " + totalofPlayer);

                if (totalofPlayer < 21 && totalofDealer < 21) {
                    System.out.println("DO YOU WANNA DRAW A CARD ? (YES / NO)");
                    ans = keyboard.nextLine();
                }

            }

            if (totalofPlayer > 21 && totalofDealer > 21) {
                System.out.println("DRAW !!! , because both of you bust!!!");
            } else if (totalofDealer == 21 && totalofPlayer == 21
                    || totalofDealer == totalofPlayer && totalofPlayer == totalofDealer) {
                System.out.println("DRAW");
            } else if (totalofPlayer > 21) {
                System.out.println("YOU BUST!!! Dealer win");
            }

            else if (totalofDealer > 21) {
                System.out.println("DEALER BUST!!! You win");
            } else if (totalofPlayer == 21 || totalofPlayer > totalofDealer) {
                System.out.println("YOU WON !!!!!");
            } else if (totalofDealer == 21 || totalofDealer > totalofPlayer) {
                System.out.println("DEALER WON !!!!!");
            }

            System.out.println("The total point that the Dealer has is " + totalofDealer);
            System.out.println("The total point that you have is " + totalofPlayer);
            System.out.println("\nDO YOU WANNA DRAW A CARD ? (YES / NO)");
            choice = keyboard.nextLine();
        }
    }

}

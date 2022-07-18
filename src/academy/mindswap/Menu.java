package academy.mindswap;
import java.util.Scanner;

public class Menu {
    private Scanner scan;

    public Menu() {
        this.scan = new Scanner(System.in);
    }

    public Scanner getScan() {
        return this.scan;
    }

    public void closeScan() {
        this.scan.close();
    }

    public static void welcome() {
        System.out.println("WELCOME TO THE ROCK-PAPER-SCISSOR GAME!");
        System.out.println("=======================================");
        System.out.println("");
    }

    public static void mainMenu() {
        System.out.println("");
        System.out.println("MENU");
        System.out.println("====");
        System.out.println("Enter 1 - Play the Game");
        System.out.println("Enter 2 - Quit");
        System.out.println("");
    }

    public static void gameMenu() {
        System.out.println("");
        System.out.println("GAME MENU");
        System.out.println("=========");
        System.out.println("Enter 0 - Quit");
        System.out.println("Enter between 3 and 5 Victory Points");
        System.out.println("");
    }

    public static void handsMenu() {
        System.out.println("");
        System.out.println("Select Hand");
        System.out.println("Enter 1 - ROCK");
        System.out.println("Enter 2 - PAPER");
        System.out.println("Enter 3 - SCISSOR");
        System.out.println("");
    }

    public static void gameOverMenu() {
        System.out.println("");
        System.out.println("GAME OVER");
        System.out.println("=========");
        System.out.println("Enter 1 - Play Again");
        System.out.println("Enter 2 - Quit");
        System.out.println("");
    }

    public static void errorMessage() {
        System.out.println("");
        System.out.println("ERROR - Wrong input, try again!");
        System.out.println("");
    }

    public void startGame() {
        mainMenu();

        System.out.print("Enter Input: ");
        int answer = scan.nextInt();
        System.out.println("");

        if(answer > 2 || answer < 0) {
            errorMessage();
            startGame();
        }

        if(answer == 1) {
            execGameMenu();
        }

        if(answer == 2) {
            System.out.println("Quiting Game");
            closeScan();
        }
    }

    public void execGameMenu() {
        gameMenu();
        System.out.print("Enter Input: ");
        int answer = scan.nextInt();
        System.out.println("");

        if(answer == 0) {
            System.out.println("Quiting Game");
            closeScan();
        } else if(answer > 2 && answer < 6) {
            execGame(answer);
        } else {
            errorMessage();
            execGameMenu();
        }
    }

    public Hand playerHand() {
        handsMenu();
        System.out.print("Enter Input: ");
        int answer = scan.nextInt();
        System.out.println("");

        if(!(answer > 0 && answer < 4)) {
            errorMessage();
            playerHand();
        }
        return GameLogic.getPlayerHand(answer);
    }

    public void execGame(int victoryPoints) {
        int logic;
        int playerVictoryPoints = 0;
        int npcVictoryPoints = 0;
        int draws = 0;
        int rounds = 1;
        Hand npcHand;
        Hand playerHand;

        while (playerVictoryPoints < victoryPoints && npcVictoryPoints < victoryPoints) {
            System.out.println("ROUND " + rounds);

            npcHand = GameLogic.getNpcHand();
            playerHand = playerHand();
            logic = GameLogic.logic(playerHand, npcHand);

            if(logic == 0) {
                System.out.println("PLAYER: " + playerHand + " | CPU: " +  npcHand + " | DRAW!");
                System.out.println("");
                draws++;
            } else if(logic == 1) {
                System.out.println("PLAYER: " + playerHand + " | CPU: " +  npcHand + " | PLAYER Scored!");
                System.out.println("");
                playerVictoryPoints++;
            } else if (logic == 2) {
                System.out.println("PLAYER: " + playerHand + " | CPU: " +  npcHand + " | CPU Scored!");
                System.out.println("");
                npcVictoryPoints++;
            }
            rounds++;
        }

        System.out.println(playerVictoryPoints > npcVictoryPoints ? "PLAYER Won The Game!": "CPU Won The Game!");
        System.out.println("STATS:");
        System.out.println("PLAYER: " + playerVictoryPoints + " | CPU: " + npcVictoryPoints + " | DRAWS: " + draws);
        System.out.println("");
        replayMenu();
    }

    public void replayMenu() {
        gameOverMenu();

        System.out.print("Enter Input: ");
        int answer = scan.nextInt();
        System.out.println("");

        if(answer > 2 || answer < 0) {
            errorMessage();
            startGame();
        }

        if(answer == 1) {
            execGameMenu();
        }

        if(answer == 2) {
            System.out.println("Quiting Game");
            closeScan();
        }
    }

}

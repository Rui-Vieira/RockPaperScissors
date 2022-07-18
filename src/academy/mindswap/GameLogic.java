package academy.mindswap;
public class GameLogic {

    public static Hand getNpcHand() {
        int handNum = (int) Math.round((Math.random() * (3 - 1) + 1));
        System.out.println(handNum);
        return switch (handNum) {
            case 1 -> Hand.ROCK;
            case 2 -> Hand.PAPER;
            default -> Hand.SCISSOR;
        };
    }

    public static Hand getPlayerHand(int num) {
        return switch (num) {
            case 1 -> Hand.ROCK;
            case 2 -> Hand.PAPER;
            default -> Hand.SCISSOR;
        };
    }

    public static int logic(Hand hand1, Hand hand2) {
        if (hand1 == Hand.ROCK && hand2 == Hand.SCISSOR || hand1 == Hand.PAPER && hand2 == Hand.ROCK || hand1 == Hand.SCISSOR && hand2 == Hand.PAPER) {
            return 1; // caso returne 1 vitoryPoints para npc1
        }
        if (hand1 == Hand.ROCK && hand2 == Hand.PAPER || hand1 == Hand.PAPER && hand2 == Hand.SCISSOR || hand1 == Hand.SCISSOR && hand2 == Hand.ROCK) {
            return 2; // caso returne 2 vitoryPoints para npc2
        }
        return 0; // caso 0 é empate
    }

}

package baseball.view;

import baseball.constant.Game;

public class HintOutput {
    public static void noMatchingNumber() {
        System.out.println(Game.NOTHING);
    }

    public static void existBallNumber(int ballNumberCount) {
        System.out.println(ballNumberCount + Game.BALL);
    }

    public static void existStrikeNumber(int strikeNumberCount) {
        System.out.println(strikeNumberCount + Game.STRIKE);
    }

    public static void existBallAndStrikeNumber(int ballNumberCount, int strikeNumberCount) {
        System.out.println(ballNumberCount + Game.BALL + " " + strikeNumberCount + Game.STRIKE);
    }
}

package baseball.controller;

import baseball.model.Number;
import baseball.view.ViewGame;

import java.util.Arrays;
import java.util.List;
public class Computer {
    public static int strikeCount;
    public static int ballCount;
    RandomNumber randomnumber = new RandomNumber();
    ViewGame viewgame = new ViewGame();

    public static void startGame(Number number) {
        List<Integer> computerNumbers = RandomNumber.makeRandomNumber();
        number.setComputer_Number(computerNumbers);
    }

    private static void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    private static void checkStrikeAndBall(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < 3; i++) {
            countStrike(computerNumbers.get(i), playerNumbers.get(i));
            countBall(computerNumbers, playerNumbers.get(i), i);
        }
    }

    private static void countStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            strikeCount++;
        }
    }

    private static void countBall(List<Integer> computerNumbers, int playerNumber, int numberIndex) {
        if (computerNumbers.get(numberIndex) != playerNumber && computerNumbers.contains(playerNumber)) {
            ballCount++;
        }
    }

    public static void viewStrikeAndBall() {
        String Mes = "";

        Mes += viewBall();
        Mes += viewStrike();
        Mes += viewNothing();

        ViewGame.viewStrike_Ball(Mes);
    }

    private static String viewBall() {
        if (ballCount > 0) {
            return ballCount + "볼" + " ";
        }

        return "";
    }

    private static String viewStrike() {
        if (strikeCount > 0) {
            return strikeCount + "스트라이크" + " ";
        }

        return "";
    }

    private static String viewNothing() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        return "";
    }

    public static boolean proceedComputerToDo(Number number) {
        List<Integer> playerNumbers = number.getPlayer_Number();
        List<Integer> computerNumbers = number.getComputer_Number();

        compareNumbers(playerNumbers, computerNumbers);

        return isThreeStrike();
    }

    public static boolean isThreeStrike() {
        return strikeCount == 3;
    }

    public static void compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        initCount();
        checkStrikeAndBall(playerNumbers, computerNumbers);
        viewStrikeAndBall();
    }
}

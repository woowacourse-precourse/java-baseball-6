package baseball.service;

import baseball.model.GameNumber;

import java.util.List;

public class CompareService {
    private final int SIZE_NUMBER;
    private final GameNumber gameNumber;
    private int strikeCount;
    private int ballCount;

    public CompareService(GameNumber gameNumber, int sizeNumber) {
        this.gameNumber = gameNumber;
        this.SIZE_NUMBER = sizeNumber;
    }

    // 스트라이크 수 반환
    public int compareNumbers() {
        initCount();
        List<Integer> playerNumbers = gameNumber.getPlayerNumbers();
        List<Integer> computerNumbers = gameNumber.getComputerNumbers();

        for (int i = 0; i < SIZE_NUMBER; i++) {
            countStrike(playerNumbers.get(i), computerNumbers.get(i));
            countBall(playerNumbers.get(i), computerNumbers, i);
        }

        printHint();
        return strikeCount;
    }

    public void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void countStrike(int playNumber, int computerNumber) {
        if (playNumber == computerNumber) {
            strikeCount++;
        }
    }

    public void countBall(int playerNumber, List<Integer> computerNumbers, int index) {
        if (computerNumbers.get(index) != playerNumber && computerNumbers.contains(playerNumber)) {
            ballCount++;
        }
    }

    public void printHint() {
        String hintMessage = "";
        if (ballCount != 0) {
            hintMessage += ballCount + "볼 ";
        }
        if (strikeCount != 0) {
            hintMessage += strikeCount + "스트라이크";
        }
        if (ballCount == 0 && strikeCount == 0) {
            hintMessage += "낫싱";
        }

        System.out.println(hintMessage);
    }
}

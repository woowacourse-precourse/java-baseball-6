package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayerPartner extends NumberClassifier {
    private int answer = 0;
    private boolean[] answerSheet = new boolean[10];

    public static PlayerPartner inputAnswerOf(int[] answers) {
        return new PlayerPartner(answers);
    }

    private PlayerPartner() {

    }

    private PlayerPartner(int[] answers) {
        int multiple = 100;

        for (Integer number : answers) {
            this.answer += number * multiple;
            this.answerSheet[number] = true;
            multiple /= 10;
        }
    }

    public void startGame() {
        while (isContinue(getStrikeCount())) {
            Player player = Player.inputNumberOf(readLine());
            int playerNumbers = player.getNumber();

            compareNumbers(playerNumbers, this.answer);
            printBallStatus(getStrikeCount(), getBallCount());
        }
    }

    private boolean isContinue(int strikeCount) {
        return strikeCount < 3;
    }

    @Override
    protected boolean isBallStrike(int playerNumber) {
        return this.answerSheet[playerNumber];
    }

    @Override
    protected boolean isStrike(int playerNumber, int partnerNumber) {
        return playerNumber == partnerNumber;
    }

    private void printBallStatus(int strikeCount, int ballCount) {
        StringBuffer message = new StringBuffer();

        if (ballCount > 0) {
            message.append(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            message.append(strikeCount + "스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            message.append("낫싱");
        }

        System.out.println(message.toString());
    }
}
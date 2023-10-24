package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayerPartner extends NumberClassifier {
    private int answer = 0;
    private boolean[] answerSheet = new boolean[10];

    public PlayerPartner() {

    }

    public void startGame() {
        writeAnswer();

        while (isContinue(getStrikeCount())) {
            int playerNumbers = Player.nextNumberOf(readLine()).getNumber();
            compareNumbers(playerNumbers, this.answer);

            printBallStatus(getStrikeCount(), getBallCount());
        }
    }

    private void writeAnswer() {
        StringBuffer stringAnswer = new StringBuffer();

        while (stringAnswer.length() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);

            if (!this.answerSheet[number]) {
                this.answerSheet[number] = true;
                stringAnswer.append(number);
            }
        }

        this.answer = Integer.parseInt(stringAnswer.toString());
    }

    private boolean isContinue(int strikeCount) {
        return strikeCount < 3;
    }

    @Override
    protected boolean validateBallStrike(int playerNumber) {
        return this.answerSheet[playerNumber];
    }

    @Override
    protected boolean validateStrike(int playerNumber, int partnerNumber) {
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
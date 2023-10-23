package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayerPartner extends NumberClassifier{
    private int answer = 0;
    private boolean[] answerSheet = new boolean[10];

    public PlayerPartner() {

    }

    private void writeAnswer() {
        StringBuffer stringAnswer = new StringBuffer();

        while(stringAnswer.length() < 3){
            int number = Randoms.pickNumberInRange(1, 9);

            if(!this.answerSheet[number]){
                this.answerSheet[number] = true;
                stringAnswer.append(number);
            }
        }

        this.answer = Integer.parseInt(stringAnswer.toString());
    }

    public void startGame() {
        writeAnswer();

        while (isContinue(getStrikeCount())) {
            int playerNumbers = Player.nextNumberOf(readLine()).getNumber();
            writeBallsCount(playerNumbers, this.answer);

            printBallStatus(getStrikeCount(), getBallCount());
        }
    }

    @Override
    protected boolean checkStrike(int playerNumber, int partnerNumber) {
        return playerNumber == partnerNumber;
    }

    @Override
    protected boolean checkBallStrike(int playerNumber) {
        return this.answerSheet[playerNumber];
    }

    private boolean isContinue(int strikeCount) {
        return strikeCount < 3;
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
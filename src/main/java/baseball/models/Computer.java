package baseball.models;

import java.util.List;

import baseball.utils.Utils;

public class Computer {

    Utils utils = new Utils();

    private String answerNumber;

    public String getAnswerNumber() {
        return answerNumber;
    }

    // 1부터 9까지 서로 다른 수로 이루어진 수 선택
    public void chooseNumber(int length) {
        String result = "";

        List<Integer> randomNumberList = Utils.generateRandomNumber(length);
        for (int number : randomNumberList) {
            result += Integer.toString(number);
        }

        this.answerNumber = result;
    }

    // 사용자 입력에 따라 힌트를 반환
    public Hint giveHint(String playerGuess) {
         int ballCnt = utils.checkBallCnt(this.answerNumber, playerGuess);
         int strikeCnt = utils.checkStrikeCnt(this.answerNumber, playerGuess);

         return new Hint(ballCnt, strikeCnt);
    }

}

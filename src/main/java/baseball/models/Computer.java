package baseball.models;

import java.util.List;

import baseball.utils.Utils;

public class Computer {

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

}

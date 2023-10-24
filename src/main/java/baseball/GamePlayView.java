package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GamePlayView {
    private static final String ASKING_FOR_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void run() {
        this.printAskingForInputMessage();
    }

    public void printAskingForInputMessage() {
        System.out.print(ASKING_FOR_INPUT_MESSAGE);
    }

    public String receiveInputFromPlayer() {
        return Console.readLine();
    }

    public void printJudgement(String judgement) {
        System.out.println(judgement);
    }
}

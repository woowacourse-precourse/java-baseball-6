package baseball.service;

import baseball.en.GameStatus;
import baseball.util.InputView;
import baseball.util.NumberGenerater;

import java.util.List;

public class BaseballGame {

    private List<Integer> randomNums;
    private List<Integer> guessNums;
    private int numSize;
    private GameStatus status = GameStatus.INIT;

    public void startGame(int numSize) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(numSize + "자리수의 숫자를 추측하여 맞춰주세요.");
        this.randomNums = NumberGenerater.getRandomNumbers(numSize);
        this.status = GameStatus.RUN;
        this.numSize = numSize;
    }

    public void receiveNums() {
        this.guessNums = InputView.receiveNums(this.numSize);
    }

//    public String checkReceivedNums(List<Integer> receivedNums) {
//
//    }


    public GameStatus getStatus() {
        return this.status;
    }

}

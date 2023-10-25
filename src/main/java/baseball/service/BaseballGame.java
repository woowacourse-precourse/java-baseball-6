package baseball.service;

import baseball.en.GameStatus;
import baseball.util.InputView;
import baseball.util.NumberGenerater;
import baseball.util.OutputView;

import java.util.List;

public class BaseballGame {

    private List<Integer> randomNums;
    private List<Integer> guessNums;
    private int numSize;
    private GameStatus status = GameStatus.INIT;

    private GameResult result;

    public void startGame(int numSize) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(numSize + "자리수의 숫자를 추측하여 맞춰주세요.");
        this.randomNums = NumberGenerater.getRandomNumbers(numSize);
//        System.out.println("randomNum = " + randomNums);
        this.status = GameStatus.RUN;
        this.numSize = numSize;
    }

    public void receiveNums() {
        this.guessNums = InputView.receiveNums(this.numSize);
    }

    public void checkReceivedNums() {
        int flag = 0;
        GameResult result = new GameResult();
        for (int i =0; i < numSize; i++) {
            int guessNum = guessNums.get(i);
            if (randomNums.contains(guessNum)){
                flag += 1;
                if (randomNums.get(i) == guessNum) {
                    result.addStrikeCount();
                    continue;
                }
                result.addBallCount();
            }
        }
        System.out.println("flag" + flag);

        if (flag == 0) {
            result.addNothingCount();
        }

        this.result = result;
        OutputView.printResult(result);

    }

    public void restartOrQuit(int numSize){
        int answer = InputView.askNewGame(numSize,this.result);

        if(answer == 1){
            this.startGame(numSize);
        } else if (answer == 2) {
            System.out.println("게임 종료");
            stopGame();
        }
    }

    public void stopGame() {
        this.status = GameStatus.STOP;
    }


    public GameStatus getStatus() {
        return this.status;
    }

}

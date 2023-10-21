package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.MyNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        do {
            gameStart();
            playGame();
            quitGame();
        } while (playButton());
    }

    public void gameStart() {
        outputView.printStartMessage();
    }

    public void playGame() {
        MyNumber myNumber = new MyNumber();
        Computer computer = new Computer(createRandomNumber());

        while (myNumber.getStrike() != 3) {
            myNumber.resultInit();
            inputView.inputNumber(myNumber);
            getMyNumberResult(myNumber, computer);
        }
    }

    public void quitGame() {
        outputView.printEndMessage();
    }

    public boolean playButton() {
        return inputView.inputPlayButton();
    }

    public void getMyNumberResult(MyNumber myNumber, Computer computer) {
        getStrikeCount(myNumber, computer);
        getBallCount(myNumber, computer);
        outputView.printMyNumberResult(myNumber);
    }

    public void getStrikeCount(MyNumber myNumber, Computer computer) {
        List<Integer> myNumberList = myNumber.getMyNumberList();
        List<Integer> answerNumberList = computer.getAnswerNumberList();

        for (int numberIndex = 0; numberIndex < myNumberList.size(); numberIndex++) {
            int number = myNumberList.get(numberIndex);
            if (number == answerNumberList.get(numberIndex)) {
                myNumber.strikeCount();
            }
        }
    }

    public void getBallCount(MyNumber myNumber, Computer computer) {
        List<Integer> myNumberList = myNumber.getMyNumberList();
        List<Integer> answerNumberList = computer.getAnswerNumberList();

        for (int numberIndex = 0; numberIndex < myNumberList.size(); numberIndex++) {
            int number = myNumberList.get(numberIndex);
            if (number != answerNumberList.get(numberIndex)
                    && answerNumberList.contains(number)) {
                myNumber.ballCount();
            }
        }
    }

    public List<Integer> createRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }
}

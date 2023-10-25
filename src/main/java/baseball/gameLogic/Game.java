package baseball.gameLogic;

import baseball.Input;
import baseball.Output;

import java.util.List;

public class Game {
    public void startGame() {
        Output output = new Output();

        //랜덤 숫자 생성
        List<Integer> randomNum = new RandomNumber().generateRandomNumbers();

        //리스트 - [스트라이크, 볼]
        List<Integer> countList;
        do {

            //숫자 입력 받음
            output.inputNum();
            List<Integer> inputNum = new Input().numberInput();

            //스트라이크, 볼 판정
            countList = new Comparing().countComparison(randomNum, inputNum);
            output.showResult(countList);

        } while (countList.get(0) != 3);

        output.endGame();
    }
}

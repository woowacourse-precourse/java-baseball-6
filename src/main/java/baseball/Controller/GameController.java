package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.NumberList;
import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void startGame() {
        OutputView.printStartGameMessage();
        Computer computer = new Computer();
        computer.setAnswer(createRandomTarget());
        // TO DO: 유저로부터 숫자 3자리를 받아 컴퓨터의 정답과 같을 때까지 비교
        OutputView.printEndGameMessage();
    }

    public NumberList createRandomTarget() {
        List<Integer> answerList = new ArrayList<>();
        while(answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }
        return new NumberList(answerList);
    }
}

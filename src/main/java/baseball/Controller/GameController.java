package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.NumberList;
import baseball.View.InputView;
import baseball.View.OutputView;
import baseball.utils.Transfer;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void startGame() {
        OutputView.printStartGameMessage();
        Computer computer = new Computer();
        computer.setAnswer(createRandomTarget());
        while(true) {
            String userAnswerString = InputController.scanUserAnswer();
            // TO DO: 유저 인풋과 정답 비교해서 결과 출력
        }
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

    private static class InputController {
        private static final String WRONG_INPUT_ANSWER = "1~9 사이 수 3자리를 입력해주세요.";
        private static final String WRONG_INPUT_TYPE = "3자리 수를 입력해주세요.";
        public static String scanUserAnswer() {
            InputView.printEnterNumbers();
            String inputString = Console.readLine();
            validateUserAnswer(inputString);
            return inputString;
        }

        private static void validateUserAnswer(String inputString) {
            boolean isValid = true;
            if(inputString.length() != 3) isValid = false;
            for(int i=0; i<inputString.length(); i++) {
                int number = inputString.charAt(i)-'0';
                isValid &= (1 <= number && number <= 9);
            }
            if(!isValid) throw new IllegalArgumentException("[ERROR] " + WRONG_INPUT_ANSWER);
        }
    }
}

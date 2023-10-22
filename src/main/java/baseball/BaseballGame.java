package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> answer = new ArrayList<>();
    List<Integer> userAnswer = new ArrayList<>();


    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initGame();
        waitInput();
    }

    public void initGame() {
        int randomNumber;
        int length = 0;

        answer.clear();
        userAnswer.clear();
        // 3개의 숫자를 만들어 list에 추가. 서로 다른 숫자여야함.
        while (length < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
                length++;
            }
        }
    }

    public void waitInput() {
        String userInputString;
        String[] userInputArray;
        int userInputInteger;

        //user의 입력을 기다림.
        System.out.print("숫자를 입력해주세요 : ");
        userInputString = Console.readLine();

        //user로부터 받은 입력값을 ListArray에 integer로 변환해서 추가.
        userInputArray = userInputString.split("");
        for (int i = 0; i < userInputArray.length; i++) {
            userInputInteger = Integer.valueOf(userInputArray[i]);
            userAnswer.add(userInputInteger);
        }
    }
}

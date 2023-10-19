package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballController {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        play();
    }

    private void play() {
        Integer answer = createAnswer();
        System.out.println("숫자를 입력해주세요 : ");
        Integer userInput = Integer.parseInt(readLine());
    }

    protected int createAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder answerStream = new StringBuilder();
        computer.stream().forEach(answerStream::append);
        return Integer.parseInt(answerStream.toString());
    }
}

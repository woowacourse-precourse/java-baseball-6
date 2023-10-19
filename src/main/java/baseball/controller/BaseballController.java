package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        createAnswer();
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

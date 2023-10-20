package baseball.controller;

import static baseball.domain.Baseball.createAnswer;

import baseball.domain.Baseball;
import baseball.domain.Result;
import baseball.service.BaseballService;

public class BaseballController {
    BaseballService baseballService;

    public BaseballController() {
        baseballService = new BaseballService();
    }

    public void start() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Baseball gameAnswer = createAnswer();

        System.out.print("숫자를 입력해주세요 : ");
        Baseball guess = baseballService.input();
        Result result = baseballService.compare(guess, gameAnswer);
    }
}

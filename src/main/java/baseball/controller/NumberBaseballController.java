package baseball.controller;

import baseball.service.NumberBaseballService;

public class NumberBaseballController {

    /**
     * 객체 생성 시 outputView, inputView, numberBaseBallService 객체 할당
     */
    private final NumberBaseballService numberBaseballService;

    public NumberBaseballController() {
        numberBaseballService = new NumberBaseballService();
    }

    /**
     * 랜덤 답안 생성 및 사용자 입력을 통한 숫자야구 게임 진행
     *
     * @func start() : 숫자야구게임 시작
     */
    public void start() {
        numberBaseballService.gameStart();
    }
}

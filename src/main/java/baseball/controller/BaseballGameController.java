package baseball.controller;

import baseball.entity.Computer;
import baseball.entity.User;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_SHUTDOWN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static Computer pc;
    public static User user;

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print(INPUT_MESSAGE);
            // Todo: 컴퓨터가 가질 값 랜덤 생성
            pc = new Computer();
            pc.setNumber();

        }
    }
}

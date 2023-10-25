package baseball.controller;

import baseball.entity.Computer;
import baseball.entity.Hint;
import baseball.entity.User;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_SHUTDOWN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static Computer pc;
    public static User user;
    public static Hint hint;

    public BaseballGameController(){
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initializePc();

        while (true) {
            System.out.print(INPUT_MESSAGE);

            hint = new Hint();
            hint.gamePlay(pc.getNumber(), user.getNumber());
            hint.printHint();

            if(hint.getGameOver()) {

                break;
            }
            /*
                   Todo
                    5. 힌트 출력
                    (ex) N스트라이크 M볼, 낫싱...)

                    -> 3번 ~ 5번 반복

                    6. 3개의 숫자를 다 맞출 경우, 종료문구 출력

                    7. 재시작 / 종료 문구 출력
                    a. 재시작: 1번부터 다시 시작
                    b. 종료: 시스템 종료

             */

        }
    }

    public void initializePc(){
        pc = new Computer();
        pc.setNumber();
    }
}

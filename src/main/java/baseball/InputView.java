package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private enum Message {
        GAME_START("숫자 야구 게임을 시작합니다."),
        REQUEST_INPUT("숫자를 입력해주세요 : ");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

    public void printStart() {
        System.out.println(Message.GAME_START.message);
    }

    public String getPlayerNumbers() {
        System.out.print(Message.REQUEST_INPUT.message);
        return Console.readLine();
    }
}

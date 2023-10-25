package baseball.game;

import baseball.game.model.Result;
import camp.nextstep.edu.missionutils.Console;

public class View {

    // 시작메세지
    public void printStartMessage() {
        System.out.println(OuputMessage.START.getMessage());
    }

    // 숫자입력메세지
    public String inputNumber() {
        System.out.print(OuputMessage.ASK_NUMBER.getMessage());
        return Console.readLine();
    }

    // 결과메세지
    public Result printResult(Result result) {
        System.out.println(result.toMessage());
        return result;
    }

    public void printEnd() {
        System.out.println(OuputMessage.END.getMessage());
    }

    public String askRestart() {
        System.out.println(OuputMessage.RESTART.getMessage());
        return Console.readLine();
    }

    enum OuputMessage {
        END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        ASK_NUMBER("숫자를 입력해주세요 :"),
        START("숫자 야구 게임을 시작합니다.");

        private String message;

        OuputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}

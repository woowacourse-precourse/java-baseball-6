package baseball.print;

public class PrintMessage {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
        System.out.println(NEW_OR_END_MESSAGE);
    }
}

package baseball.constant;

import java.util.function.Consumer;

public enum SystemMessage {

    NEW("숫자 야구 게임을 시작합니다.", Status.NEW, System.out::println),
    INPUT("숫자를 입력해주세요 : ", Status.SET, System.out::print);

    private final String message;
    private final Status status;
    private final Consumer<String> print;

    SystemMessage(String message, Status status, Consumer<String> print) {
        this.message = message;
        this.status = status;
        this.print = print;
    }

    public void printMessage(Status status) {
        if (status == this.status) {
            print.accept(message);
        }
    }
}

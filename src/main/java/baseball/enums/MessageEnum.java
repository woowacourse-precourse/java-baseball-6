package baseball.enums;

import static baseball.enums.NumbersEnum.*;

public enum MessageEnum {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", LENGTH.showValue())),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_NUMBER("숫자를 입력해주세요 : ");

    private final String value;
    MessageEnum(String value) {
        this.value = value;
    }

    public String show() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}



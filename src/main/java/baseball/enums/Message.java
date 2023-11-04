package baseball.enums;

import baseball.Result;

public enum Message {
    START("숫자 야구 게임을 시작합니다." ),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    LOSE(""),
    PLAY_NEXT_GAME_OR_NOT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    String korMessage;

    Message(String korMessage) {
        this.korMessage = korMessage;
    }

    public String getKorMessage() {
        return korMessage;
    }

    public static String makeHintMessage(Result result) {
        StringBuilder builder = new StringBuilder();
        if (result.getBallCount() > 0) {
            builder.append(String.format("%d볼",result.getBallCount()));
        }
        if (result.getStrikeCount() > 0) {
            if (!builder.isEmpty()) {
                builder.append(" ");
            }
            builder.append(String.format("%d스트라이크", result.getStrikeCount()));
        }
        return builder.toString();
    }
}

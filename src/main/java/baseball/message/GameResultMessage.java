package baseball.message;

import java.util.Arrays;
import java.util.Optional;

// 게임 과정에서 출력하기 위한 메세지를 저장하는 클래스
public enum GameResultMessage {
    BALL_1("1볼", 10),
    BALL_2("2볼", 20),
    BALL_3("3볼", 30),
    STRIKE_1("1스트라이크", 1),
    STRIKE_2("2스트라이크", 2),
    STRIKE_3("3스트라이크", 3),
    NOT_MATCHED("낫싱", -1)
    ;

    private final String message;
    private final int code;

    GameResultMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    // 게임 종료 조건을 조회하기 위한 메서드 추가
    public static int getTargetCode() {
        return STRIKE_3.getCode();
    }

    // 게임 결과 코드에 따라서 그에 적합한 결과를 반환하는 메소드
    public static String getMessageByCode(int code) {
        int ballCount = code / 10 * 10;
        int strikeCount = code % 10;

        if(ballCount == 0 && strikeCount == 0) return NOT_MATCHED.message;

        String ballMessage = getBallMessage(ballCount);
        String strikeMessage = getStrikeMessage(strikeCount);

        if(ballCount == 0) return strikeMessage;
        if(strikeCount == 0) return ballMessage;

        return ballMessage + " " + strikeMessage;
    }

    private static String getBallMessage(int count) {
        Optional<String> resultMessage = Arrays.stream(values())
                .filter(result -> result.getCode() == count)
                .map(GameResultMessage::getMessage)
                .findFirst();

        return resultMessage.orElse("");
    }

    private static String getStrikeMessage(int count) {
        Optional<String> resultMessage = Arrays.stream(values())
                .filter(result -> result.getCode() == count)
                .map(GameResultMessage::getMessage)
                .findFirst();

        return resultMessage.orElse("");
    }
}

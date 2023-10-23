package baseball;

import static baseball.NumberBaseballGameConfig.CONTINUE_MESSAGE;
import static baseball.NumberBaseballGameConfig.INPUT_PROMPT;
import static baseball.NumberBaseballGameConfig.START_MESSAGE;
import static baseball.NumberBaseballGameConfig.WIN_MESSAGE;

public class Announcer {

    // 게임 시작 메시지 출력
    public void announceGameStart() {
        System.out.println(START_MESSAGE);
    }

    // 추측값 입력 유도 메시지 출력
    public void askToInput() {
        System.out.print(INPUT_PROMPT);
    }

    // 모두 맞혔을 경우 게임 종료 메시지 출력
    public void announceWin() {
        System.out.println(WIN_MESSAGE);
    }

    // 볼 개수와 스트라이크 개수를 기반으로 메시지 출력
    public void announceScore(Score score) {
        System.out.println(resolveScoreToString(score));
    }

    // 다음 게임 할건지 물어보는 메시지 출력
    public void askContinue() {
        System.out.println(CONTINUE_MESSAGE);
    }

    // 볼 카운트와 스트라이크 카운트로 출력해야할 메시지를 resolve하는 메서드
    public String resolveScoreToString(Score score) {
        int ballCount = score.getBallCount();
        int strikeCount = score.getStrikeCount();
        StringBuilder result = new StringBuilder();

        if (ballCount > 0) {
            result.append(ballCount).append("볼 ");
        }

        if (strikeCount > 0) {
            result.append(strikeCount).append("스트라이크 ");
        }

        if (result.length() == 0) {
            result.append("낫싱");
        }

        return result.toString().trim();
    }
}

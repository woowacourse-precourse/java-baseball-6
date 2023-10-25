package baseball.model;

import static baseball.model.BaseballGameCounts.BALL;
import static baseball.model.BaseballGameCounts.STRIKE;

public class BaseballGameCountsMessage {
    private String message = "";

    public BaseballGameCountsMessage(BaseballGameCounts baseballGameCounts) {
        // 카운트 수를 기반으로 메시지 생성을 위해 변수 지정
        Integer ballCounts = baseballGameCounts.getCounts().get(BALL);
        Integer strikeCounts = baseballGameCounts.getCounts().get(STRIKE);

        // 스트라이크 카운트가 존재하면 메시지에 덧붙임
        if (strikeCounts > 0) {
            this.message = String.format("%d스트라이크", strikeCounts);
        }

        // 볼 카운트가 존재하면 메시지에 덧붙임
        if (ballCounts > 0) {
            this.message = String.format("%d볼 ", ballCounts) + this.message;
        }

        // 스트라이크, 볼이 아무것도 없을 경우 '낫싱'으로 초기화
        if (strikeCounts == 0 && ballCounts == 0) {
            this.message = "낫싱";
        }
    }

    // 메시지를 출력하는 함수
    public void printMessage() {
        System.out.println(this.message);
    }
}

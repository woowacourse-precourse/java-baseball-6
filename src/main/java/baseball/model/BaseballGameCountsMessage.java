package baseball.model;

public class BaseballGameCountsMessage {
    private String message;

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    public BaseballGameCountsMessage(BaseballGameCounts baseballGameCounts) {
        // 카운트 수를 기반으로 메시지 생성을 위해 변수 지정
        Integer ballCounts = baseballGameCounts.getCounts().get(BALL);
        Integer strikeCounts = baseballGameCounts.getCounts().get(STRIKE);

        // 스트라이크 카운트가 존재하면 메시지에 덧붙임
        if (strikeCounts > 0) {
            editMessage(String.format("%d스트라이크", strikeCounts));
        }

        // 볼 카운트가 존재하면 메시지에 덧붙임
        if (ballCounts > 0) {
            editMessage(String.format("%d볼 ", ballCounts));
        }

        // 스트라이크, 볼이 아무것도 없을 경우 '낫싱'으로 초기화
        if (strikeCounts == 0 && ballCounts == 0) {
            editMessage("낫싱");
        }
    }

    // 조건에 따라 메시지를 수정해주는 함수
    public void editMessage(String frag) {
        if (message == null) {
            this.message = frag;
            return;
        }
        this.message = frag + this.message;

    }

    // 메시지를 출력하는 함수
    public void printMessage() {
        System.out.println(this.message);
    }
}

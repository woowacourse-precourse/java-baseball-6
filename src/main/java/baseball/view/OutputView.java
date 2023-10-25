package baseball.view;

import baseball.constant.Constant;
import baseball.dto.ResultDTO;

public class OutputView {

    /**
     * 숫자야구게임의 시작과 끝에 출력되는 메시지와 관련된 문자열 및 메서드
     */
    private static final String START_MESSAGE = "숫자야구게임을 시작합니다.";
    private static final String END_MESSAGE = Constant.GAME_NUMBERS_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    /**
     * 정답과 사용자 입력을 비교한 결과를 Console에 출력
     *
     * @param resultDTO : strike, ball 결과가 담긴 객체
     */
    public static void printResult(ResultDTO resultDTO) {
        int strikeCount = resultDTO.getStrikeCount();
        int ballCount = resultDTO.getBallCount();
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.println();
    }
}

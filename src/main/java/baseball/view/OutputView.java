package baseball.view;

import baseball.dto.ResultDto;

public class OutputView {
    public static void printWelcome() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResult(ResultDto resultDto) {
        System.out.println(resultDto.noticeResult());
    }

    public static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

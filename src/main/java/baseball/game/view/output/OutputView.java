package baseball.game.view.output;

import baseball.game.model.dto.RoundResultDto;

/**
 * 게임 결과를 유저에게 출력하는 클래스
 */
public class OutputView {

    public void printResult(RoundResultDto roundResult) {
        StringBuilder result = new StringBuilder();

        if (roundResult.getBallCount() != 0) {
            result.append(roundResult.getBallCount()).append("볼 ");
        }

        if (roundResult.getStrikeCount() != 0) {
            result.append(roundResult.getStrikeCount()).append("스트라이크");
        }

        if (roundResult.getStrikeCount() == 0 && roundResult.getBallCount() == 0) {
            result.append("낫싱");
        }

        System.out.println(result.toString().trim());
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

package baseball.view;

import baseball.domain.Referee;

public class OutputView {
   private StringBuilder sb =  new StringBuilder();

    public OutputView() {
    }

    public void printResult(Referee referee) {
        if (referee.getBallNum() == 3) {
            sb.append("3볼 ");
        }
        if (referee.getBallNum() == 2) {
            sb.append("2볼 ");
        }
        if (referee.getBallNum() == 1) {
            sb.append("1볼 ");
        }
        if (referee.getStrikeNum() == 3) {
            sb.append("3스트라이크");
        }
        if (referee.getStrikeNum() == 2) {
            sb.append("2스트라이크");
        }
        if (referee.getStrikeNum() == 1) {
            sb.append("1스트라이크");
        }
        String result = sb.toString();
        System.out.println(result);
    }
}

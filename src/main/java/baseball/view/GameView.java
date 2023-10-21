package baseball.view;

import baseball.model.PlayerAnswer;

public class GameView {

    public void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printSuccessGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 ");
    }

    public void printOptionMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printAnswerHintMessage(PlayerAnswer playerAnswer) {
        System.out.println(printBallOrStrike(playerAnswer));
    }

    private String printBallOrStrike(PlayerAnswer playerAnswer) {
        String hint = "";

        if (playerAnswer.getBall() > 0) {
            hint += playerAnswer.getBall() + "볼 ";
        }
        if (playerAnswer.getStrike() > 0) {
            hint += playerAnswer.getStrike() + "스트라이크";
        }

        return hint.equals("") ? "낫싱" : hint;
    }

}

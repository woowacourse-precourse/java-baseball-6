package baseball.game.view;

public class GameView {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


    private void printHint(Integer strikeCount, Integer ballCount) {
        StringBuilder hint = new StringBuilder();

        if (ballCount != 0) hint.append(ballCount).append("볼 ");
        if (strikeCount != 0) hint.append(strikeCount).append("스트라이크");
        if (ballCount == 0 && strikeCount == 0) hint.append("낫싱");

        System.out.println(hint);
    }

}

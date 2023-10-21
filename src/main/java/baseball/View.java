package baseball;

public class View {

    public void opening() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void input() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void score(Score score) {
        if (score.hasWinScore()) {
            System.out.println(String.format("%s스트라이크", score.getStrike()));
            System.out.println("3개의 숫자를 모두 맞히셨습니다.! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        if (score.isNoScore()) {
            System.out.println("낫싱");
        }

        if (score.isOnlyBall()) {
            System.out.println(String.format("%s볼", score.getBall()));
        }

        if (score.isOnlyStrike()) {
            System.out.println(String.format("%s스트라이크", score.getStrike()));
        }

        if(score.isStrikeWithBall()) {
            System.out.println(String.format("%s볼 %s스트라이크", score.getBall(), score.getStrike()));
        }
    }
}

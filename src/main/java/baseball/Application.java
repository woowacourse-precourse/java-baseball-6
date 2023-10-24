package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView();
        BaseballComputer baseballComputer = new BaseballComputer();
        BaseballUmpire baseballUmpire = new BaseballUmpire();

        // 게임 시작
        BaseballGame baseballGame = new BaseballGame(baseballView, baseballComputer, baseballUmpire);
        try {
            baseballView.outputGameStart();
            baseballGame.start();
        } catch (Exception e) {
            throw new IllegalArgumentException("1~9 사이의 서로 다른 세 개의 숫자를 공백없이 입력해주세요.");
        }
    }
}

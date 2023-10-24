package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballInputView baseballInputView = new BaseballInputView();
        BaseballOutputView baseballOutputView = new BaseballOutputView();
        BaseballComputer baseballComputer = new BaseballComputer();
        BaseballUmpire baseballUmpire = new BaseballUmpire();

        // 게임 시작
        BaseballGame baseballGame = new BaseballGame(baseballInputView, baseballOutputView, baseballComputer,
                baseballUmpire);
        baseballOutputView.outputGameStart();
        baseballGame.start();
    }
}

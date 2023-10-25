package baseball;

import view.PlayGameInformationOutputView;

public class Application {
    public static void main(String[] args) {
        PlayGameInformationOutputView playGameInformationOutputView = new PlayGameInformationOutputView();
        playGameInformationOutputView.printGameStart();
    }
}

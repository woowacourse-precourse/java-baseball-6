package baseball;

import baseball.presenter.GamePresenter;

public class Application {
    public static void main(String[] args) {
        GamePresenter gamePresenter = new GamePresenter();
        gamePresenter.play();
    }
}

package baseball.game;

import baseball.View.View;
import baseball.data.GameResult;
import baseball.player.Computer;

import baseball.player.User;

public class BaseballGame implements Game{
    Computer computer;
    User user;
    View view;
    public BaseballGame(View view) {
        this.view = view;
    }

    @Override
    public void startGame(Computer computer, User user) {
        this.computer = computer;
        this.user = user;

        view.startView();
    }

    @Override
    public boolean playTurn() {
        user.inputNumbers(view.inputView());
        GameResult result = computer.reply(user.ask());
        return view.outputView(result);
    }

    public boolean isRestart() {
        return view.endView();
    }
}

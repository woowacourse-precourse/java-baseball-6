package baseball.view;

public class GameView {

    private User user;

    public GameView(User user) {
        this.user = user;
    }

    public void showStartMessage() {
        user.showStartMessage();
    }

    public String getUserInput() {
        return user.getUserInput();
    }
}

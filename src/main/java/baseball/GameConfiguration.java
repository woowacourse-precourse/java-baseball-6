package baseball;

public class GameConfiguration { //각 객체간 의존성 주입을 해주는 클래스.
    private Constant constant;
    private CheckForm checkForm;
    private Game game;

    public GameConfiguration(Constant constant, CheckForm checkForm, Game game) {
        this.constant = constant;
        this.checkForm = checkForm;
        this.game = game;
    }

    public Constant getConstant() {
        return constant;
    }

    public CheckForm getCheckForm() {
        return checkForm;
    }

    public Game getGame() {
        return game;
    }

}

package baseball.my_sol;

public class MyCheckScore {
    private final Score playResult;

    public MyCheckScore(Nums user, Nums computer) {
        this.playResult = judgeGame(user, computer);
    }

    private Score judgeGame(Nums user, Nums computer) {
        return user.compareTo(computer);
    }

    public Score notifyResult() {
        return playResult;
    }
}

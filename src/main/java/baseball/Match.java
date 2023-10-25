package baseball;

public class Match {
    private Catcher catcher;
    private Pitcher pitcher;
    private Referee referee;

    public Match(Catcher catcher, Pitcher pitcher, Referee referee) {
        this.catcher = catcher;
        this.pitcher = pitcher;
        this.referee = referee;
    }

    public void init() {
        catcher.generateRandomNumbers();
    }

    public void run() {
        while (true) {
            if (playRound().isStrikeOut()) {
                break;
            }
        }
    }

    public RoundResult playRound() {
        pitcher.setNumbers();
        RoundResult roundResult = referee.judge(catcher.getNumbers(), pitcher.getNumbers());
        System.out.println(roundResult);

        return roundResult;
    }
}

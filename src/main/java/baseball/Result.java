package baseball;

public class Result {
    private int strikes = 0; //유저가 고른 공에 대한 스트라이크 수
    private int balls = 0; //유저가 고른 공에 대한 볼 수


    private void makeResult(Player player, Computer computer) {
        this.strikes = computer.compareStrike(player);
        this.balls = computer.compareBall(player);

        if (strikes == 3) {
            player.setPlayerState(State.PAUSE);
        }
    }

    public void showResult(Player player, Computer computer) {
        this.makeResult(player, computer);

        String statement = "";

        if (hasStrike() && hasBall()) {
            statement = this.balls + "볼 " + this.strikes + "스트라이크";
        } else if (hasStrike()) {
            statement = this.strikes + "스트라이크";
        } else if (hasBall()) {
            statement = this.balls + "볼";
        } else {
            statement = "낫싱";
        }

        System.out.println(statement);
    }


    private boolean hasStrike() {
        return this.strikes != 0;
    }

    private boolean hasBall() {
        return this.balls != 0;
    }
}

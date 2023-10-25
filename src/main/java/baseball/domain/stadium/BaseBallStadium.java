package baseball.domain.stadium;

import baseball.domain.baseballplayer.referee.Referee;
import baseball.domain.baseballplayer.team.BaseBallTeam;

public class BaseBallStadium {
    private final BaseBallTeam defenseTeam;
    private final BaseBallTeam offenseTeam;
    private final Referee referee;

    private BaseBallStadium(final BaseBallTeam defenseTeam, final BaseBallTeam offenseTeam, final Referee referee) {
        this.defenseTeam = defenseTeam;
        this.offenseTeam = offenseTeam;
        this.referee = referee;
    }

    public static BaseBallStadium of(final BaseBallTeam defenseTeam, final BaseBallTeam offenseTeam, final Referee referee) {
        return new BaseBallStadium(defenseTeam, offenseTeam, referee);
    }

    public void startNewRound() {
        defenseTeam.createNewBall();
        while (true) {
            offenseTeam.createNewBall();
            referee.printResult(defenseTeam, offenseTeam);

            if (referee.isRoundOver()) {
                printWinMessage();
                return;
            }
        }
    }

    private void printWinMessage() {
        final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        System.out.println(WIN_MESSAGE);
    }

}

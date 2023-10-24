package baseball.v5.player;

import java.util.List;

public class PlayerManagerV5 {
    private ComputerPlayerV5 computerPlayer;
    private ChallengerPlayerV5 challengerPlayer;

    public PlayerManagerV5(ComputerPlayerV5 computerPlayer, ChallengerPlayerV5 challengerPlayer) {
        this.computerPlayer = computerPlayer;
        this.challengerPlayer = challengerPlayer;
    }

    public List<Integer> getComputerNums() {
        return computerPlayer.setNum();
    }

    public List<Integer> getChallengerNums() {
        return challengerPlayer.setNum();
    }

    public void managePlayers() {
        this.computerPlayer = new ComputerPlayerV5();
        this.challengerPlayer = new ChallengerPlayerV5();
    }
}




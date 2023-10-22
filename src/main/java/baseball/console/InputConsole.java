package baseball.console;

import baseball.domain.player.ComputerPlayer;
import baseball.domain.player.UserPlayer;

public class InputConsole {

    public static int[] userNumSetting() {
        UserPlayer.setUserNumber();
        return UserPlayer.getUserNumber();
    }
    public static int[] computerNumSetting() {
        ComputerPlayer.setComputerNumber();
        return ComputerPlayer.getComputerNumber();
    }
}

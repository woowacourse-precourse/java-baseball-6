package baseball.console;

import baseball.domain.player.ComputerPlayer;
import baseball.domain.player.UserPlayer;
import baseball.utils.StringException;
import baseball.utils.StringUtil;

public class InputConsole {
    private static int SIZE = 3;
    public static int[] userNum = new int[SIZE];
// 플레이어에서 받고 유효성 검사는 여기서 진행
    public static void userNumSetting(String str) {
        StringException.checkUserInputTotal(str, 3);
        int[] userNum = StringUtil.stringToIntArray(str);
    }
    public static int[] userNumGetting() {
        return userNum;
    }
    public static int userReplayInputSetting() {
        int user = Integer.parseInt(UserPlayer.getUserNumber());
        StringException.checkReplayInput(user);
        return user;
    }
    public static int[] computerNumSetting() {
        ComputerPlayer.setComputerNumber();
        return ComputerPlayer.getComputerNumber();
    }
}

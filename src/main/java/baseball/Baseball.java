package baseball;

import baseball.core.Computer;
import baseball.core.Core;
import baseball.core.Player;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.MessageConstant.*;

public class Baseball {
    private final Core core = new Core();
    private final Player player = new Player();
    private final Computer computer = new Computer();

    public void startBaseball() {
        List<Integer> computerNumber = computer.getComputerNumber();
        //System.out.println(computerNumber);
        System.out.println(START_BASEBALL_MSG);
        boolean restartFlag = true;

        while(restartFlag) {
            System.out.print(PLEASE_INPUT_MSG);
            List<Integer> playerNumber = player.getPlayerNumber();
            int strikeCount = core.countStrike(computerNumber, playerNumber);
            int ballCount = core.countBall(computerNumber, playerNumber);
            core.printBaseballResult(strikeCount, ballCount);

            if(strikeCount == MAX_STRIKE) {
                System.out.println(END_BASEBALL_MSG);
                restartFlag = isRestartOrExit();
            }
        }

    }

    public boolean isRestartOrExit() {
        System.out.println(RESTART_OR_EXIT_MSG);
        int choice = Integer.parseInt(Console.readLine());

        if (choice == RESTART_NUM) {
            startBaseball();
        }

        return false;
    }

}
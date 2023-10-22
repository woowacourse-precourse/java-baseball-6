package baseball.service;

import baseball.domain.Computer;
import baseball.dto.GameCommand;
import baseball.dto.Score;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.Constants.*;
import static baseball.dto.GameCommand.RESTART;
import static baseball.dto.GameStatus.PLAY;

public class Game {


    public void play() {
        Computer computer = new Computer();
        Score score = new Score();

        while (score.getStatus() == PLAY) {
            System.out.println(GAME_NUMBER_INPUT_STRING);
            List<Integer> userNum = getUserNums(Console.readLine());
            score = computer.getScore(userNum);
            System.out.println(score.getScoreToString());
        }

        System.out.println(GAME_END_STRING);
    }

    private List<Integer> getUserNums(String readLine) {
        if (readLine.length() != NUMBER_SIZE) //잚못된 개수의 문자를 입력한 경우
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);

        List<Integer> nums = new ArrayList<>();
        for (char num : readLine.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException(ERROR_INVALID_NUMBER); //숫자를 입력하지 않은 경우
            }
            nums.add(Character.digit(num, 10));
        }
        return nums;
    }

    public boolean isReplay() {
        System.out.println(GAME_RESTART_INPUT);
        GameCommand command = GameCommand.fromInputCommand(Console.readLine());

        return command == RESTART;
    }
}

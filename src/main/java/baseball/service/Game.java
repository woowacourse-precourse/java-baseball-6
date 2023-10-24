package baseball.service;

import baseball.domain.Computer;
import baseball.dto.Score;
import baseball.util.NumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.Constants.*;
import static baseball.dto.GameStatus.PLAY;

public class Game {
    private Computer computer;
    private Score score;

    public Game(Computer computer, Score score) {
        this.computer = computer;
        this.score = score;
    }

    public Game(NumberGenerator gameNumberGenerator) {
        this(new Computer(gameNumberGenerator.getRandomNumber()), new Score());
    }

    public void playGame() {
        while (score.getStatus() == PLAY) {
            System.out.print(GAME_NUMBER_INPUT_STRING);
            score = getOneRoundScore(Console.readLine());
            System.out.println(score.getScoreToString());
        }
        System.out.println(GAME_END_STRING);
    }

    private Score getOneRoundScore(String input) {
        List<Integer> userNum = getValidUserNums(input);
        return computer.getScore(userNum);
    }


    public List<Integer> getValidUserNums(String readLine) {
        validUserNumbers(readLine);
        return getUserNumbers(readLine);
    }

    private static void validUserNumbers(String readLine) {
        if (StringUtils.isBlank(readLine) || readLine.length() != NUMBER_SIZE) //잚못된 개수의 문자를 입력한 경우
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
    }

    private static List<Integer> getUserNumbers(String readLine) {
        List<Integer> nums = new ArrayList<>();
        for (char num : readLine.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException(ERROR_INVALID_NUMBER); //숫자를 입력하지 않은 경우
            }
            nums.add(Character.digit(num, 10));
        }
        return nums;
    }


}

package baseball.service;

import baseball.domain.Computer;
import baseball.dto.Score;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.Constant.ERROR_USER_INPUT;
import static baseball.dto.GameStatus.PLAY;

public class Game {

    public void play() {
        Computer computer = new Computer();
        Score score = new Score();

        while (score.getStatus() == PLAY) {
            System.out.println("숫자를 입력해주세요 ");
            List<Integer> userNum = getUserNums(Console.readLine());
            score = computer.getScore(userNum);
            System.out.println(score.getScoreToString());
        }

        System.out.println("게임 종료");
    }

    private List<Integer> getUserNums(String readLine) {
        if (readLine.length() != 3) //잚못된 개수의 문자를 입력한 경우
            throw new IllegalArgumentException(ERROR_USER_INPUT);

        List<Integer> nums = new ArrayList<>();
        for (char num : readLine.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException(ERROR_USER_INPUT); //숫자를 입력하지 않은 경우
            }
            nums.add(Character.digit(num, 10));
        }
        return nums;
    }

    public boolean isReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cmd = Console.readLine();
        if (cmd.equals("1")) {
            return true;
        }

        if (cmd.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}

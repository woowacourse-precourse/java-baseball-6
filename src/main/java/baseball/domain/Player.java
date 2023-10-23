package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> guessNumbers;

    public List<Integer> getGuessNumbers() {
        return guessNumbers;
    }

    public Player() {
        this.guessNumbers = new ArrayList<>();
    }
    public void guess() {
        System.out.print("숫자를 입력해주세요 : ");
        String answer = Console.readLine();
        for (int i = 0; i < 3; i++) {
            guessNumbers.add(answer.charAt(i) - '0');
        }
    }

    public String replayOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}

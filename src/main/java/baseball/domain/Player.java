package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.logic.BaseballGame.EXIT;
import static baseball.logic.BaseballGame.RESTART;

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
        if(answer.length() <= 0 || answer.length() > 3 || isDuplicate(answer)){
            throwIllegalArgumentException();
        }
        guessNumbers.clear();
        for (int i = 0; i < 3; i++) {
            guessNumbers.add(answer.charAt(i) - '0');
        }
    }

    public String replayOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        if (answer.equals(RESTART) || answer.equals(EXIT)) {
            return answer;
        }
        throwIllegalArgumentException();
        return null;
    }

    public boolean isDuplicate(String answer) {
        String temp = "";

        for (char c: answer.toCharArray()) {
            // 포함되지 않는다면
            if (!temp.contains(String.valueOf(c))) {
                temp += String.valueOf(c);
            } else {
                return true;
            }
        }

        return false;
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }
}

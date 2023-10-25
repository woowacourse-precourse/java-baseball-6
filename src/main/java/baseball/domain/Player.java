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
        String guess = Console.readLine();
        if(guess.length() <= 0 || guess.length() > 3 || isThereDuplicateNumber(guess)){
            throwIllegalArgumentException();
        }
        guessNumbers.clear();
        for (int i = 0; i < 3; i++) {
            guessNumbers.add(guess.charAt(i) - '0');
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

    // 사용자의 입력에 중복 숫자가 있는지 검사한다
    public boolean isThereDuplicateNumber(String guess) {
        String temp = "";

        for (char guessNumber: guess.toCharArray()) {
            if (!temp.contains(String.valueOf(guessNumber))) {
                temp += String.valueOf(guessNumber);
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

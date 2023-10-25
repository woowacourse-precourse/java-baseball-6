package baseball.user;

import baseball.game.BaseballConstants;
import baseball.game.GameMenu;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private List<Integer> baseballNumbers;
    private GameMenu gameMenu = GameMenu.NEW_GAME;

    public void inputBaseballNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputBaseballNumber = Console.readLine();
        validateInputNumber(inputBaseballNumber);
        baseballNumbers = Arrays.stream(inputBaseballNumber.split(""))
                .map(Integer::valueOf)
                .toList();
    }

    private void validateInputNumber(String inputBaseballNumber) {
        if (inputBaseballNumber == null || inputBaseballNumber.length() != BaseballConstants.TOTAL_BASEBALL_NUMBERS) {
            throw new IllegalArgumentException();
        }

        for (char c : inputBaseballNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }

        Set<Character> duplicateCheckSet = new HashSet<>();
        for (char c : inputBaseballNumber.toCharArray()) {
            if (!duplicateCheckSet.add(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }

    public void chooseNewGameOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameMenu = GameMenu.of(Console.readLine());
    }


    public boolean isNewGame() {
        return GameMenu.NEW_GAME == gameMenu;
    }
}

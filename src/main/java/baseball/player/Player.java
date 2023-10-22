package baseball.player;

import baseball.validate.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Player {
    private final PlayerInputValidator validator;
    private List<Integer> numbers;

    public Player() {
        this.validator = new PlayerInputValidator();
        inputNumbers();
    }

    private void inputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        this.numbers = validator.validateNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

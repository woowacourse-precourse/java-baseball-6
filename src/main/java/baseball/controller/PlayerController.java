package baseball.controller;

import baseball.domain.numbers.Numbers;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.view.BaseBallView;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PlayerController {
    private static final BaseBallView baseBallView = BaseBallView.create();

    private PlayerController() {
    }

    public static void startBattles (Player opponent) {
        boolean isContinueBattle = Boolean.TRUE;

        while (isContinueBattle) {
            isContinueBattle = startOneBattle(opponent);
        }
    }

    private static boolean startOneBattle(Player opponent) {
        Player player = changePlayerNumbers(baseBallView.numbersInputView());
        Result result = opponent.battle(player);

        baseBallView.resultGameView(result.toString());

        return result.isContinue();
    }

    private static Player changePlayerNumbers(String numberString) {
        return Player.create(convertStringToNumbers(numberString));
    }

    private static Numbers convertStringToNumbers(String numberString) {
        validateIsInteger(numberString);
        
        return Numbers.create(Arrays.stream(numberString.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }
    

}

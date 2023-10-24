package baseball.console;

import baseball.domain.BaseBall;
import baseball.service.BaseBallService;
import baseball.util.InputValidate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.util.Constant.*;
import static baseball.util.InputValidate.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {

    public BaseBallService baseBallService;

    public int playGame() {

        baseBallService = new BaseBallService();

        System.out.println(START_GAME);
        BaseBall computer = new BaseBall();
        BaseBall player = new BaseBall(new ArrayList<>());

        while (true) {
            System.out.print(INPUT_NUMBERS);

            String[] input = readLine().split("");
            validateLength(input);

            List<Integer> inputNumbers = Arrays.stream(input)
                    .map(Integer::parseInt)
                    .peek(InputValidate::validateNumberRange)
                    .toList();
            player.setInputBallNumber(inputNumbers);
            if (baseBallService.isThreeStrike(player, computer)) { // 3스트라이크 확인
                System.out.println(NUMBER_THREE + STRIKE);
                // 게임재시작 여부
                return baseBallService.restartGame();
            }
            int[] result = baseBallService.checkStrikeAndBallCount(player, computer);
            System.out.print(baseBallService.notificationResult(result));
        }
    }
}

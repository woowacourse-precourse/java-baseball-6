package baseball.controller;

import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.util.Constant.*;
import static baseball.util.Constant.BaseballController.*;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;


    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void start() {
        // 게임 시작
        inputView.start();
        int cmd;
        do {
            cmd = 0;
            // 랜덤 3자리의 수 생성
            List<Integer> computerNums = createRandomNums();
            do {
                // 3자리의 수 입력 받기
                String input = inputView.getNums();
                List<Integer> userNums = getUserNums(input);
                // 비교
                Result result = new Result(RANGE_ZERO, RANGE_ZERO);
                result.getResult(computerNums, userNums);
                // 힌트 제공
                cmd = outputView.getHints(cmd, result.getBall(), result.getStrike());
            } while(cmd != CMD_QUIT && cmd != CMD_RESTART);
        } while(cmd != CMD_QUIT);
    }


    private static List<Integer> createRandomNums() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < RANGE_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }
        return computerNums;
    }

    private static List<Integer> getUserNums(String input) {
        List<Integer> userNums = new ArrayList<>();
        Arrays.stream(input.split(SPACE)).forEach(str -> {
            try {
                Integer num = Integer.parseInt(str);
                // 각 자릿수끼리 중복된 수를 입력한 경우 || 각 자릿수가 1 ~ 9까지의 수가 아닌 경우
                if (userNums.contains(num) || num == RANGE_ZERO) throw new IllegalArgumentException();
                userNums.add(num);
            }
            // 숫자 외의 문자를 입력한 경우
            catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        });
        // 입력 받은 수가 3자리가 아닌 경우
        if (userNums.size() != RANGE_DIGIT) throw new IllegalArgumentException();
        return userNums;
    }

}

package baseball;

import baseball.BaseballService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballController {

    private BaseballService baseballService = new BaseballService();

    public void start() {
        List<Integer> answer = baseballService.generateAnswer();
    }
}

package baseball.service;

import java.util.List;

public class BaseBallService {
    private static List<Integer> computerNum;
    private static int strike = 0;
    private static int ball = 0;

    public void init(List<Integer> generatedComputerNum) {
        computerNum = generatedComputerNum;
    }
}

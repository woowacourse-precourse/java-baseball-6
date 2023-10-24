package baseball.controller;

import baseball.model.NumberVO;
import baseball.utility.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraderResult {

    int ballCount;
    int strikeCount;

    public String setGameResult(NumberVO computer, int user) {
        List<Integer> userNumber = cutOneByOne(user);

        strikeCount = countStrike(computer, userNumber);
        
        String sortedResult;

        if (ballCount == 0 && strikeCount == 0) {
            sortedResult = String.format("%s\n", Constant.NOTTING);
        } else if (strikeCount == 0) {
            sortedResult = String.format("%s\n", Constant.BALL);
            sortedResult = String.format(sortedResult, ballCount);
        } else if (ballCount == 0) {
            sortedResult = String.format("%s\n", Constant.STRIKE);
            sortedResult = String.format(sortedResult, strikeCount);
        } else {
            sortedResult = String.format("%s %s\n", Constant.BALL, Constant.STRIKE);
            sortedResult = String.format(sortedResult, ballCount, strikeCount);
        }

        return sortedResult;
    }

    private List<Integer> cutOneByOne(int user) {
        int[] tmpArr = new int[3];

        for (int i = 2; i >= 0; i--) {
            tmpArr[i] = user % 10;
            user /= 10;
        }

        List<Integer> list = new ArrayList<>();
        for (int element : tmpArr) {
            list.add(element);
        }

        return list;
    }

    private int countStrike(NumberVO computer, List<Integer> user) {

    }
}

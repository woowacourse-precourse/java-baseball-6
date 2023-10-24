package baseball.controller;

import baseball.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class GraderResult {

    int ballCount;
    int strikeCount;

    public String setGameResult(List<Integer> computer, int user) {
        ballCount = 0;
        strikeCount = 0;
        List<Integer> userNumber = cutOneByOne(user);

        countStrike(computer, userNumber);

        if (strikeCount != 3) {
            countBall(computer, userNumber);
        }

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

    private void countStrike(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == user.get(i)) {
                strikeCount++;
                user.remove(i);
                user.add(i, 0);
            }
        }
    }

    private void countBall(List<Integer> computer, List<Integer> user) {
        for (int element : user) {
            if (computer.contains(element)) {
                ballCount++;
            }
        }
    }
}

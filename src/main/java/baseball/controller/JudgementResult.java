package baseball.controller;

import baseball.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class JudgementResult {

    public String setGameResult(List<Integer> computer, String user) {
        List<Integer> userNumber = cutOneByOne(Integer.parseInt(user));

        int strikeCount = countStrike(computer, userNumber);
        int ballCount = countBall(computer, userNumber);

        String sortedResult;

        if (ballCount == 0 && strikeCount == 0) {
            sortedResult = String.format("%s\n", Constant.NOTTING);
            return sortedResult;
        } else if (strikeCount == 0) {
            sortedResult = String.format("%s\n", Constant.BALL);
            sortedResult = String.format(sortedResult, ballCount);
            return sortedResult;
        } else if (ballCount == 0) {
            sortedResult = String.format("%s\n", Constant.STRIKE);
            sortedResult = String.format(sortedResult, strikeCount);
            return sortedResult;
        }
        sortedResult = String.format("%s %s\n", Constant.BALL, Constant.STRIKE);
        sortedResult = String.format(sortedResult, ballCount, strikeCount);

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

    private int countStrike(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == user.get(i)) {
                strikeCount++;
                user.remove(i);
                user.add(i, 0);
            }
        }

        return strikeCount;
    }

    private int countBall(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;

        for (int element : user) {
            if (computer.contains(element)) {
                ballCount++;
            }
        }

        return ballCount;
    }
}

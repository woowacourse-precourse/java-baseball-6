package baseball;

import baseball.validation.NumberValidation;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        NumberValidation validation = new NumberValidation();

        List<Integer> comDigits = getComDigits();

        playNumberBaseBallGame(outputView, inputView, validation, comDigits);
    }

    private static void playNumberBaseBallGame(OutputView outputView, InputView inputView, NumberValidation validation, List<Integer> comDigits) {
        outputView.printStartMessage();
        do {
            outputView.printInputMessage();
            int userNum = inputView.enterNumber(validation);

            List<Integer> userDigits = new ArrayList<>(3);
            while (userNum > 0) {
                userDigits.add(userNum % 10);
                userNum = userNum / 10;
            }
            Collections.reverse(userDigits);

            int ballCnt = getBallCnt(comDigits, userDigits);
            int strikeCnt = getStrikeCnt(comDigits, userDigits);

            outputView.printGameResultMessage(ballCnt, strikeCnt);

            if (strikeCnt == 3) {
                outputView.printEndMessage();
                outputView.printSelectMessage();

                int flag = inputView.enterRestartOrEnd(validation);
                if (flag == 2) {
                    break;
                }
                comDigits = getComDigits();
            }

        } while (true);
    }

    private static List<Integer> getComDigits() {
        List<Integer> comDigits = new ArrayList<>();
        while (comDigits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comDigits.contains(randomNumber)) {
                comDigits.add(randomNumber);
            }
        }
        return comDigits;
    }

    private static int getBallCnt(List<Integer> comDigits, List<Integer> userDigits) {
        int ballCnt = 0;
        for (int i = 0 ; i < 3; i++) {
            int ballIndex = comDigits.indexOf(userDigits.get(i));
            if (ballIndex != i && ballIndex != -1) {
                ballCnt += 1;
            }
        }
        return ballCnt;
    }

    private static int getStrikeCnt(List<Integer> comDigits, List<Integer> userDigits) {
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (comDigits.get(i).equals(userDigits.get(i))) {
                strikeCnt += 1;
            }
        }
        return strikeCnt;
    }
}

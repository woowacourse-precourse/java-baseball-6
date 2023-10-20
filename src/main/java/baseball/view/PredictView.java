package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class PredictView {

    private static final String PREDICT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String printAndRead() {
        System.out.println(PREDICT_MESSAGE);
        return Console.readLine();
    }
}

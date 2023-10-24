package baseball.controller;

import baseball.model.baseballModel;
import baseball.view.baseballView;

import java.util.HashSet;

public class baseballController {

    int endValue = 2;
    String endComment = "게임 종료";
    String exceptionComment = "자릿수가 서로 다른 세 자리의 숫자를 입력해주세요. 예 : 213";
    baseballView view = new baseballView();
    baseballModel model = new baseballModel();

    public void run() { //숫자야구게임 실행 조건
        boolean flag = true;
        view.startConsole();

        while (flag) {
            model.computerNumber();

            playBall();

            int endFlag = Integer.parseInt(view.endConsole());
            if (endFlag == endValue) {
                flag = false;
            }
        }
        view.closeConsole();
    }

    public void playBall() {
        boolean flag = true;

        while (flag) {
            String insert = view.insertConsole();
            raiseException(insert);
            model.ballCount(insert);
            String result = model.stringResult();
            view.resultConsole(result);

            if (result.contains(endComment)) {
                break;
            }
        }

    }

    private void raiseException(String insert) { //예외처리 검증
        if (insert.isEmpty()) {
            throw new IllegalArgumentException(exceptionComment);
        }
        if (insert.length() != 3 || !insert.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException(exceptionComment);
        }

        HashSet<Integer> hashSet = new HashSet<>(); //서로 다른 세 자리의 수 검증
        for (int i = 0; i < insert.length(); i++) {
            hashSet.add(Integer.parseInt(String.valueOf(insert.charAt(i))));
        }
        if (hashSet.size() != insert.length()) {
            throw new IllegalArgumentException(exceptionComment);
        }
    }
}

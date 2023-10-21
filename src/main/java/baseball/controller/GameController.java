package baseball.controller;

import baseball.view.ErrorView;
import baseball.view.PrintView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    int strike = 0;
    int ball = 0;

    PrintView printView = new PrintView();

    public int[] getInputNumber() {
        ErrorView errorView = new ErrorView();
        int[] inputNum = new int[3];
        String input = Console.readLine();
        if (input.length() != 3) {
            errorView.inputNumberLengthError();
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                errorView.validateInputError();
            }
            inputNum[i] = Integer.parseInt(String.valueOf(c));
        }
        return inputNum;
    }

    // 입력받은 숫자와 정답을 비교한다.
    public boolean analyzeInputNumber(int[] answer, int[] inputNum) {

        strike = 0;
        ball = 0;

        for (int i = 0; i < answer.length; i++) {
            compareNumber(answer, inputNum, i);
        }

        printView.printScoreMessage(strike, ball);

        return strike != 3;
    }


        // 정답과 숫자가 같은지 확인한다.
        public void compareNumber ( int[] answer, int[] inputNum, int index){
            for (int j = 0; j < inputNum.length; j++) {
                if (answer[index] == inputNum[j]) {
                    getCount(index, j);
                    break;
                }
            }
        }

        // 스트라이크와 볼의 갯수를 구한다.
        public void getCount ( int index, int j){
            if (index != j) {
                ball++;
            }
            if (index == j) {
                strike++;
            }
        }
    }

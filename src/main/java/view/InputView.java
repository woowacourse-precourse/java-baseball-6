package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import model.ExceptionModel;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    ExceptionModel exceptionModel = new ExceptionModel();

    /**
     * 야구볼 서로 다른 3자리의 수 입력받기
     */
    public List<Integer> inputBaseBall() {
        String number = readLine();
        exceptionModel.checkBaseBall(number);
        return changeInteger(number);
    }

    /**
     * 입력받은 문자열을 정수형 리스트로 변환
     */
    private List<Integer> changeInteger(String input) {
        String[] str = input.split("");
        List<Integer> numbers = new ArrayList<>();
        for (String s :
                str) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    /**
     * 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수 입력받기
     */
    public int inputRetryNumber() {
        String number = readLine();
        exceptionModel.checkRetry(number);
        return Integer.parseInt(number);
    }

}

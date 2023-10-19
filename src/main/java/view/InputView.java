package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import model.ExceptionModel;

public class InputView {
    ExceptionModel exceptionModel = new ExceptionModel();
    /**
     * 야구볼 서로 다른 3자리의 수 입력받기
     */
    public String[] inputBaseBall() {
        String number = readLine();
        exceptionModel.checkBaseBall(number);
        return number.split("");
    }


    /**
     * 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수 입력받기
     */
    public String inputRetryNumber() {
        String number = readLine();
        exceptionModel.checkRetryNumber(number);
        return number;
    }

}

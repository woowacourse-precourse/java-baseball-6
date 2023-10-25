package baseball.domain;

import baseball.utils.InputValidation;
import baseball.view.InputInformationView;

public class Player {
    private String inputNumber;
    private final InputValidation inputValidation;
    private final InputInformationView inputInformationView;

    // Player 생성시 입력 값을 검증해주는 InputValidation 를 같이 생성.
    public Player() {
        this.inputValidation = new InputValidation();
        this.inputInformationView = new InputInformationView();
    }

    // Player 는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력하는 메서드.
    public void inputNumber() {
        inputInformationView.numberInputGuide();
        String inputNumber = camp.nextstep.edu.missionutils.Console.readLine();
        inputValidation.validation(inputNumber);
        this.inputNumber = inputNumber;
    }

    // Player 가 입력한 임의의 3자리 수를 리턴하는 메서드.
    public String getInputNumber() {
        return inputNumber;
    }
}

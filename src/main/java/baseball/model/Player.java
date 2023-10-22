package baseball.model;

import baseball.view.InputView;

import java.util.List;

public class Player {

    private final InputView inputView;
    private final Util util;
    private List<Integer> numbers;
    private final int settingNumberLength;

    public Player(int numberLength) {
        this.inputView = new InputView();
        this.settingNumberLength = numberLength;
        this.util = new Util();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setPlayerNumbersWithString(String input) {
        List<Integer> inputNumbers = util.parseToNumberList(input);

       this.numbers = inputNumbers;
    }
}

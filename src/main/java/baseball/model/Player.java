package baseball.model;

import baseball.view.InputView;

import java.util.List;

public class Player {

    private final InputView inputView;
    private final Util util;
    private List<Integer> numbers;

    public Player() {
        this.inputView = new InputView();
        this.util = new Util();
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setPlayerNumbers() {
        String input = inputView.inputPlayerNumber();
        List<Integer> inputNumbers = util.parseToNumberList(input);

       setNumbers(inputNumbers);
    }
}

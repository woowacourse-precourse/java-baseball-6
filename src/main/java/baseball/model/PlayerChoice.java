package baseball.model;

public class PlayerChoice {
    private int value;

    public PlayerChoice(String input) {
        validateChoice(input);
        value = Integer.parseInt(input);
    }

    private void validateChoice(String input) {
        int choice = Integer.parseInt(input);
        if ((choice != 1) && (choice != 2)) {
            throw new IllegalArgumentException("1 또는 2 를 입력해주세요.");
        }
    }

    public int getValue() {
        return value;
    }
}

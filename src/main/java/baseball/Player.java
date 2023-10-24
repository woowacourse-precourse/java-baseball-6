package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String[] playerNumbers;

    public void pickPlayerNumbers() {
        System.out.print(Message.PLEASE_TYPE_NUMBERS);
        String input = Console.readLine();
        // 숫자 이외 값을 입력한 경우 & 빈 입력인 경우
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message.NOT_NUMBERS_OR_BLANK);
        }
        // 3자리 숫자를 입력하지 않은 경우
        if (input.length() != Message.TOTAL_PLAYER_NUMBERS) {
            throw new IllegalArgumentException(Message.NOT_THREE_NUMBERS);
        }
        // 중복된 숫자를 입력한 경우
        String[] pickedNumbers = input.split("");
        if (pickedNumbers[0].equals(pickedNumbers[1]) || pickedNumbers[0].equals(pickedNumbers[2])
                || pickedNumbers[1].equals(pickedNumbers[2])) {
            throw new IllegalArgumentException(Message.REPEATED_NUMBERS);
        }
        this.playerNumbers = pickedNumbers;
    }

    public String[] getPlayerNumbers() {
        if (this.playerNumbers == null) {
            throw new IllegalStateException(Message.PLAYER_NUMBERS_IS_NULL);
        }
        return this.playerNumbers;
    }
}

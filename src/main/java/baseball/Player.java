package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String[] playerNumbers;
    private static final int TOTAL_PLAYER_NUMBERS = 3;

    public void pickPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        // 숫자 이외 값을 입력한 경우 & 빈 입력인 경우
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력한 값이 숫자가 아니거나 빈 입력입니다.");
        }
        // 3자리 숫자를 입력하지 않은 경우
        if (input.length() != TOTAL_PLAYER_NUMBERS) {
            throw new IllegalArgumentException("입력 값이 3자리가 아닙니다.");
        }
        // 중복된 숫자를 입력한 경우
        String[] pickedNumbers = input.split("");
        if (pickedNumbers[0].equals(pickedNumbers[1]) || pickedNumbers[0].equals(pickedNumbers[2])
                || pickedNumbers[1].equals(pickedNumbers[2])) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
        }
        this.playerNumbers = pickedNumbers;
    }

    public String[] getPlayerNumbers() {
        if (this.playerNumbers == null) {
            throw new IllegalStateException("playerNumbers shouldn't be NULL");
        }
        return this.playerNumbers;
    }
}

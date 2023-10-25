package baseball;

public class Input {
    public static void check(String playerNum) {
        checkNum1(playerNum);
        checkNum2(playerNum);
    }

    public static void checkNum1(String playerNum) {
        if (playerNum.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkNum2(String playerNum) {
        for(char c : playerNum.toCharArray()) {
            if(Character.getNumericValue(c) < 1 || Character.getNumericValue(c) > 9) {
                throw new IllegalArgumentException();
            }
        }
    }


}

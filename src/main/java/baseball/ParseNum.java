package baseball;

public class ParseNum {
    public static int[] parseInput(String input) {
        int[] parsedNum = new int[3];
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                parsedNum[i] = Character.getNumericValue(c);
            }
        }
        return parsedNum;
    }
}

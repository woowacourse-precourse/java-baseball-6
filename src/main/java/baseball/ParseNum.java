package baseball;

public class ParseNum {
    public static int[] parseInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해 주세요.");
        }

        int[] parsedNum = new int[3];
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                parsedNum[i] = Character.getNumericValue(c);
            } else {
                throw new IllegalArgumentException("숫자 이외의 문자를 입력하셨습니다.");
            }
        }
        return parsedNum;
    }
}

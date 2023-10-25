package baseball;

public class Validate {
    public static void validateInput(String input) {
        // 잘못된 숫자 입력할 경우 예외처리 하기
        if (input.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력하실 수 없습니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자로 입력해 주세요.");
        }
    }

    public static void checkDuplication(String[] inputSplit) {
        if (inputSplit[0].equals(inputSplit[1]) || inputSplit[0].equals(inputSplit[2])
                || inputSplit[1].equals(inputSplit[2])) {
            throw new IllegalArgumentException("중복되지 않는 숫자들로 입력해 주세요.");
        }
    }
}

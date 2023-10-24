package baseball;

public class Validation {
    // 이 클래스에 정의된 모든 메소드를 실행합니다.
    static public void validate(String input) {
        validateNaturalNumber(input);
        validateDuplicate(input);
        validateLength(input);
    }

    // 입력이 모두 자연수로 이루어져있는지 확인합니다.
    static private void validateNaturalNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if ('1' <= current && current <= '9') continue; // 조건이 1부터 9까지의 수만 들어옴이므로.
            throw new IllegalArgumentException("1부터 9까지의 수만 입력 하실 수 있습니다.");
        }
    }

    // 입력에 중복된 수가 있는지 확인합니다.
    static private void validateDuplicate(String input) {
        boolean[] isExist = new boolean[9]; // 문자열을 구성하는 문자가 1~9까지임이 증명되었음으로
        for (int i = 0; i < input.length(); i++) {
            int current = input.charAt(i) - '1';
            if (isExist[current]) {
                throw new IllegalArgumentException("입력 하신 수 중 중복 되는 숫자가 있습니다.");
            }
            isExist[current] = true;
        }
    }

    // 입력의 길이가 3인지 확인합니다.
    static private void validateLength(String input) {
        boolean error = input.length() != 3; // 모든 수가 1~9까지이고, 중복이 없음이 검사되으므로 글자 수만 맞으면 된다.
        if (error) {
            throw new IllegalArgumentException("입력 하신 숫자의 길이가 " + 3 + "(이)가 아닙니다.");
        }
    }
}

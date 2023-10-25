package game;

public class InputValidator {
    public static boolean isValid(String input) {
        // 입력의 길이 체크
        if (input == null || input.length() != NumberBaseballGame.getNumberLength()) {
            throw new IllegalArgumentException("Input length is not valid!");
        }

        // 입력에 중복된 숫자가 있는지 체크
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("Input contains duplicated numbers!");
                }
            }
        }

        // 입력에 '0'이 포함되어 있는지 체크
        if (input.contains("0")) {
            throw new IllegalArgumentException("Input should not contain number '0'!");
        }

        return true;
    }

    public static boolean isContinueValid(String response) {
        if(!(response.equals("1") || response.equals("2"))){
            return false;
        }
        return true;
    }
}

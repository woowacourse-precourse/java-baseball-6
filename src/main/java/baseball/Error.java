package baseball;

public class Error {
    static void duplicateInput(boolean[] check, char c) {
        if (check[c - '0']) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력하세요!");
        }
    }

    static void illegalInputRange(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("1~9사이 숫자만 입력하세요!");
        }
    }

    static void illegalInputSize(String str) {
        if (str.length() != 3) {
            throw new IllegalArgumentException("3자리만 입력하세요!");
        }
    }
}

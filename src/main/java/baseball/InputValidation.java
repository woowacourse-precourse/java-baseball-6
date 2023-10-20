package baseball;

public class InputValidation {
    public boolean isThreeNumber(String threeNumber) {
        if (threeNumber.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
        for (int i = 0; i < 3; i++) {
            if (!isOneToNine(threeNumber.charAt(i))) {
                throw new IllegalArgumentException("1-9까지의 숫자가 아닙니다.");
            }
        }
        return true;
    }

    private boolean isOneToNine(char number) {
        if (number >= '1' && number <= '9') {
            return true;
        }
        return false;
    }

    public boolean isMenuNumber(String stringMenuNumber) {
        int menuNumber = Integer.parseInt(stringMenuNumber);
        if (menuNumber != 1 && menuNumber != 2) {
            throw new IllegalArgumentException("메뉴에 있는 숫자가 아닙니다.");
        }
        return true;
    }

    // 중복 숫자 추가
}

package baseball.domain;

public class Validator {

    private Validator() {
    }

    public static boolean stringLengthCheck(final String strNum) {
        return strNum.length() == 3;
    }

    public static boolean isNull(final String strNum) {
        return strNum == null;
    }

    public static boolean reStartChecker(String strNum) {
        try {
            if (Integer.parseInt(strNum) == 1) {
                return true;
            } else if (Integer.parseInt(strNum) == 2) {
                return true;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return false;
    }

    public static boolean isNumber(String strNum) {
        try {
            Integer.parseInt(strNum);
            return true;
            
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDuplicate(String strNum) {
        int originSize = strNum.length();
        int checkSize = removeDuplicateString(strNum).length();

        return checkSize < originSize;
    }

    public static String removeDuplicateString(String str) {

        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }
}

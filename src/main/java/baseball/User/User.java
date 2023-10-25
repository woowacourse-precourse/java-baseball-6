package baseball.User;

public class User {

    public boolean checkthreeNum(String str) {
        if (str.length() == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkdifferentNum(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRange(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < '1' || charArray[i] > '9') {
                return false;
            }
        }
        return true;
    }


}

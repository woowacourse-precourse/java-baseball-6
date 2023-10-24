package baseball.utils;

public class UserNumList {

    public static int[] UserInputList(String num) throws IllegalArgumentException{
        checkLength(num);
        int[] userInputList = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            if (checkAvailableNum(num, i)){
                userInputList[i] = num.charAt(i) - '0';
            }
        }
        return userInputList;
    }

    private static void checkLength(String num) throws IllegalArgumentException{
        if (num.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
    private static boolean checkAvailableNum(String num, int i) {
        return '0' <= num.charAt(i) && num.charAt(i) <= '9';
    }
}

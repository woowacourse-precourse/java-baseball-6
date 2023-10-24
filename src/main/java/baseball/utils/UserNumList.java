package utils;

public class UserNumList {

    public static int[] UserInputList(String num) {
        int[] userInputList = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            userInputList[i] = num.charAt(i) - '0';
        }
        return userInputList;
    }
}

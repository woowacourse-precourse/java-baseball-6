package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class user {
    private static String input;
    private user() {}
    static class inputException extends IllegalArgumentException {
        public inputException(String a) {
            super(a);
        }
    }

    public static ArrayList<Integer> userInput(int size) throws inputException{

        ArrayList<Integer> userList = new ArrayList<>();
        input = Console.readLine();

        if (input.length() != size) {
            throw new inputException("3으로 사이즈를 맞춰서");
        }
        for (int i=0; i<size; i++){

            int number = Integer.parseInt(String.valueOf(input.charAt(i)));
            userList.add(number);
        }

        return userList;
    }

}

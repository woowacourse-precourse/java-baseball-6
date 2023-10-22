package baseball.domain;

import baseball.exception.InputNeitherRestartNorExit;
import baseball.exception.InputNotNumber;
import baseball.exception.InputNumberNotUnique;
import baseball.exception.InputSizeNot3;

import java.util.ArrayList;
import java.util.List;

public class ClientNumbers implements Numbers {

    private final List<Integer> numbers = new ArrayList<>(SIZE);

    public ClientNumbers(String inputStr) {
        validateInputNotNumber(inputStr);
        validateInputNumberNotUnique(inputStr);
        validateInputSizeNot3(inputStr);

        char[] charArray = inputStr.toCharArray();

        for(char c : charArray) {
            numbers.add(Integer.parseInt(String.valueOf(c)));
        }
    }

    public Info compareWithComputerNumbers(ComputerNumbers computerNumbers) {
        Info info = new Info();

        int ball = 0;
        int strike = 0;
        boolean stop = false;

        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                int cl = numbers.get(i);
                int co = computerNumbers.getNumbers().get(j);

                if(cl == co && i != j) {
                    info.setBall(++ball);
                }
                if(cl == co && i == j) {
                    info.setStrike(++strike);
                }
            }
        }

        if(strike == 3) {
            info.setOngoing(stop);
        }

        return info;
    }

    public static void validateInputNotNumber(String inputStr) {
        char[] charArray = inputStr.toCharArray();

        for(char c : charArray) {
            if(!Character.isDigit(c)) {
                throw new InputNotNumber();
            }
        }
    }

    public static void validateInputNumberNotUnique(String inputStr) {
        char[] charArray = inputStr.toCharArray();

        for(int i=1; i<SIZE; i++) {
            char firstChar = charArray[0];
            if(firstChar == charArray[i]) {
                throw new InputNumberNotUnique();
            }
        }
    }

    public static void validateInputSizeNot3(String inputStr) {
        if (inputStr.length() != SIZE) {
            throw new InputSizeNot3();
        }
    }
}

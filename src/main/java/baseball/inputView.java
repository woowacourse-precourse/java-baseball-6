package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class inputView {

    private String inputNumber;
    private List<Integer> userNumberLst = new ArrayList<>();

    InputException inputException = new InputException();


    public List<Integer> userInput() {
        printInputtMessage();
        userInputNumber();
        userNumberLst = userInputNumberStringToList(inputNumber);
        inputException.checkInputExection(userNumberLst);
        return userNumberLst;


    }

    public void printInputtMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void userInputNumber() {

        inputNumber = Console.readLine();


    }

    public List<Integer> userInputNumberStringToList(String str) {
        List<Integer> numLst = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            numLst.add(ch - '0');

        }
        return numLst;

    }

}

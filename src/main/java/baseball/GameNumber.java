package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    private String computerNumber;
    private String userNumber;

    public GameNumber() {
        inputUserNumber();
        createComputerNumber();
    }
    public void inputUserNumber(){
        String inputNumber;

        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Console.readLine();
        checkInputValidity(inputNumber);
        this.userNumber = inputNumber;
    }
    public void createComputerNumber(){
        String number = "";
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                number += Integer.toString(randomNumber);
            }
            this.computerNumber = number;
        }
    }
    public void checkInputValidity(String userInput) {
        int checkInt;

        try {
            checkInt = Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if(userInput.length() != 3)
            throw new IllegalArgumentException();

        checkInt = Integer.parseInt(userInput);
        int hundredsPlace = checkInt / 100;
        int tensPlace = (checkInt / 10) % 10;
        int onesPlace = checkInt % 10;

        if (hundredsPlace == tensPlace || hundredsPlace == onesPlace || tensPlace == onesPlace)
            throw new IllegalArgumentException();
    }
    public String inputRestart() {
        String userInput;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        userInput = Console.readLine();

        return userInput;
    }
    public String getComputerNumber() {
        return computerNumber;
    }
    public String getUserNumber() {
        return userNumber;
    }
}
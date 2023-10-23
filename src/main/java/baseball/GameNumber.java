package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameNumber {
    private String computerNumber;
    private String userNumber;

    public GameNumber() {
        inputUserNumber();
        createComputerNumber();
    }
    public void inputUserNumber(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = null;
        try {
            inputNumber = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            throw new IllegalArgumentException("에러발생");
        }

        if(userInput.length() != 3)
            throw new IllegalArgumentException("에러발생");

        checkInt = Integer.parseInt(userInput);
        int hundredsPlace = checkInt / 100;
        int tensPlace = (checkInt / 10) % 10;
        int onesPlace = checkInt % 10;

        if (hundredsPlace == tensPlace || hundredsPlace == onesPlace || tensPlace == onesPlace)
            throw new IllegalArgumentException("에러발생");
    }
    public String inputRestart() {
        String userInput;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userInput;
    }
    public String getComputerNumber() {
        return computerNumber;
    }
    public String getUserNumber() {
        return userNumber;
    }
}
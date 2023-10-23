package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumber;

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    public Player() throws IllegalArgumentException {
        String inputNumber = playerInput();   // 플레이어 숫자 입력
        validationNumber(inputNumber);   // 유효성 검사: 숫자 여부
        List<Integer> inputNumberInt = changeToInt(inputNumber);   // 입력값 숫자로 변환
        validationThree(inputNumberInt);   // 유효성 검사: 세 자리 수
        validationRange(inputNumberInt);   // 유효성 검사: 1~9 사이의 수
        validationDuplicate(inputNumberInt);   // 유효성 검사: 중복 여부

        this.playerNumber = inputNumberInt;
    }

    // 플레이어 숫자 입력
    public String playerInput() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    // 입력값 숫자로 변환
    public List<Integer> changeToInt(String inputNumber) {
        List<Integer> playerNumberInt = new ArrayList<>();
        for (String s : inputNumber.split("")) {
            playerNumberInt.add(Integer.valueOf(s));
        }
        return playerNumberInt;
    }

    // 유효성 검사: 숫자 여부
    public void validationNumber(String inputNumber) throws IllegalArgumentException {
        try {
            Integer.valueOf(inputNumber);
        }
        catch (NumberFormatException ex) {
            System.out.println("숫자가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    // 유효성 검사: 세 자리 수
    public void validationThree(List<Integer> playerNumberInt) throws IllegalArgumentException {
        if (playerNumberInt.size() != 3){
            System.out.println("세 자리 수가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    // 유효성 검사: 1~9 사이의 수
    public void validationRange(List<Integer> playerNumberInt) throws IllegalArgumentException {
        for (Integer i : playerNumberInt) {
            if (i == 0) {
                System.out.println("1~9사이의 수가 아닙니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    // 유효성 검사: 중복 여부
    public void validationDuplicate(List<Integer> playerNumberInt) throws IllegalArgumentException {
        int length = playerNumberInt.size();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (playerNumberInt.get(i) == playerNumberInt.get(j)) {
                    System.out.println("숫자가 중복됩니다.");
                    throw new IllegalArgumentException();
                }
            }
        }
    }

}

package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumber;

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerInput) {
        validationNumber(playerInput);   // 유효성 검사: 숫자 여부
        List<Integer> inputNumber = changeToInt(playerInput);   // 입력값 정수 리스트로 변환
        validationThree(inputNumber);   // 유효성 검사: 세 자리 수
        validationRange(inputNumber);   // 유효성 검사: 1~9 사이의 수
        validationDuplicate(inputNumber);   // 유효성 검사: 중복 여부

        this.playerNumber = inputNumber;
    }

    // 입력값 정수 리스트로 변환
    public List<Integer> changeToInt(String inputNumber) {
        List<Integer> playerNumberInt = new ArrayList<>();
        for (String s : inputNumber.split("")) {
            playerNumberInt.add(Integer.valueOf(s));
        }
        return playerNumberInt;
    }

    // 유효성 검사: 숫자 여부
    private void validationNumber(String inputNumber) {
        try {
            Integer.valueOf(inputNumber);
        }
        catch (NumberFormatException ex) {
            System.out.println("숫자가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    // 유효성 검사: 세 자리 수
    private void validationThree(List<Integer> playerNumberInt) {
        if (playerNumberInt.size() != 3){
            System.out.println("세 자리 수가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    // 유효성 검사: 1~9 사이의 수
    private void validationRange(List<Integer> playerNumberInt) {
        for (Integer i : playerNumberInt) {
            if (i == 0) {
                System.out.println("1~9사이의 수가 아닙니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    // 유효성 검사: 중복 여부
    private void validationDuplicate(List<Integer> playerNumberInt) {
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

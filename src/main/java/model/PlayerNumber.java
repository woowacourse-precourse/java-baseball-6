package model;

import view.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {
    ArrayList<Integer> playerPickList = new ArrayList<>();

    public void setPlayerPickList() {
        //사용자 입력
        String playerInput = InputView.setPlayerNumber();
        //예외 체크
        isValidNumber(playerInput);
        isAllDigits(playerInput);
        hasNoDuplicates(playerInput);
        //리스트로 변환
        convertToArrayList(playerInput);
    }

    public ArrayList<Integer> getPlayerPickList() {
        return this.playerPickList;
    }

    public static void isValidNumber(String playerInput) { //3개의 숫자인지 확인
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException("숫자는 3자리만 입력 가능합니다.");
        }
    }

    public static void isAllDigits(String playerInput) { //숫자인지 확인
        for (int i = 0; i < playerInput.length(); i++) {
            if (!Character.isDigit(playerInput.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }

    public static void hasNoDuplicates(String playerInput) {//Set으로 중복을 확인
        Set<Character> duplicateSet = new HashSet<>();
        for (int i = 0; i < playerInput.length(); i++) {
            duplicateSet.add(playerInput.charAt(i));
        }
        if (!(duplicateSet.size() == playerInput.length())) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public void convertToArrayList(String playerInput) {
        playerPickList.clear();
        for (int i = 0; i < playerInput.length(); i++) {
            int digit = Character.getNumericValue(playerInput.charAt(i));
            playerPickList.add(digit);
        }
    }
}

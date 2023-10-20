package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerNumber {
    private static final int NUMBER_SIZE = 3;
    List<Integer> computer = new ArrayList<>();
    String computerNumber;
    
    public ComputerNumber() {
    
    }
    
    public void pickThreeNumber() {
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        computerNumber = String.valueOf(computer.get(0)) + (computer.get(1)) + (computer.get(2));
    }
    
    public void deleteComputerNumber() {
        computer.clear();
        computerNumber = "";
    }
    
    public boolean validation(String userInput) {
        validateNum(userInput);
        validateSize(userInput);
        validateDuplicate(userInput);
        return true;
    }
    
    private void validateNum(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자만 입력해주세요!");
        }
        
        
    }
    
    private void validateSize(String userInput) {
        if (userInput.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요!");
        }
    }
    
    private void validateDuplicate(String userInput) {
        Set<Character> nonDuplicateNumbers = new HashSet<>();
        nonDuplicateNumbers.add(userInput.charAt(0));
        nonDuplicateNumbers.add(userInput.charAt(1));
        nonDuplicateNumbers.add(userInput.charAt(2));
        if (nonDuplicateNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("서로 다른 숫자들을 입력해주세요!");
        }
    }
    public int calculateScore(String userInput) {
        int score = 0;
        
        for (int i = 0; i < 3; i++) {
            if (computerNumber.charAt(i) == userInput.charAt(i)) {
                score += 10; // 스트라이크
            } else if (computerNumber.contains(String.valueOf(userInput.charAt(i)))){
                score += 1; // 볼
            }
        }
        
        return score;
    }
}

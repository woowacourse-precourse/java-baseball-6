package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Inspection {

    //길이 확인
    private void lengthCheck(String userInput){
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
        }
    }
    //범위 확인 (1~9)
    private void rangeCheck(String userInput){
        for (int i = 0; i < 3; i++) {
            char digit = userInput.charAt(i);
            int num = Character.getNumericValue(digit);

            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("입력값은 1부터 9 사이의 정수여야 합니다.");
            }
        }
    }
    //중복 확인
    private void duplicateCheck(String userInput){
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            char digit = userInput.charAt(i);
            int num = Character.getNumericValue(digit);

            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
            }
        }
    }
    //입력예외테스트
    public void inputExceptionTest(String input){
        lengthCheck(input);
        duplicateCheck (input);
        rangeCheck(input);
    }
    //입력 및 오류검출 메서드 (출력 : 문자열)
    public String userInput() {
        System.out.print("1부터 9 사이의 정수 3개를 입력하세요 : ");
        String input = Console.readLine();
        inputExceptionTest(input);
        return input;
    }
    public int RestartInput() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        int intValue = Integer.parseInt(input);
        if (intValue < 1 || intValue > 2) {
            throw new IllegalArgumentException("1또는 2만 입력하세요.");
        }
        return intValue;
    }
    public List<Integer> userInputToList(){
        String userInput = userInput();
        List<Integer> userInputList =userInput.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
        return userInputList;
    }
}
package view;

import java.util.HashSet;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    public int[] getUserInput() throws IllegalArgumentException{

        String input = scanner.nextLine();
        isDuplicate(input);
        isNumber(input);
        isThree(input);

        //입력문자열을 숫자 배열로 저장
        int[] numbers = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }
        return numbers;
    }

    //입력예외1: 입력 숫자 중복 체크
    public void isDuplicate(String input) {
        HashSet<String> uniqueValue = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            uniqueValue.add(String.valueOf(input.charAt(i)));
        }
        if (uniqueValue.size() != 3) throw new IllegalArgumentException(" 중복된 값은 입력이 불가능합니다.");
    }

    //입력예외2: 숫자인지 체크
    public void isNumber(String input) {
        if (!input.matches("\\d+")) throw new IllegalArgumentException(" 숫자가 아닌 값은 입력이 불가능합니다.");
    }

    //입력예외3: 숫자가 3개인지
    public void isThree(String input) {
        if (!(input.length() == 3)) throw new IllegalArgumentException(" 3개의 숫자를 입력해주세요");
    }


    //종료입력
    public boolean isRestart(){
        String input = scanner.nextLine();
        return Integer.parseInt((input)) == 1;
    }


}
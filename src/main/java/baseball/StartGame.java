package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class StartGame {

    /**
     * 플레이어의 숫자를 입력받는 메서드 입니다.
     */
    public List<Integer> PlayerNumber(){

        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        isNumber(input);
        threeNumber(input);
        duplicatedNumber(input);

        List<Integer> playerNumbers = new ArrayList<>();

        for(String number : input.split("")){
            playerNumbers.add(Integer.parseInt(number));
        }

        return playerNumbers;
    }

    /**
     * 게임을 다시시작 할지에 대한 여부를 묻는 메서드 입니다.
     */
    public boolean isGameStart(){

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        oneOrZero(input);

        if(input.equals("1")){
            return true;
        }

        return false;
    }

    /**
     * 1 혹은 2가 아니라면, 예외를 발생시키는 메소드 입니다.
     */
    private void oneOrZero(String input){

        if(!input.equals("1") && (!input.equals("2"))){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력 받은 3자리 문자열 중 중복된 값이 있는지 확인해주는 메소드 입니다.
     */
    private void duplicatedNumber(String input){

        char[] digits = input.toCharArray();
        if (digits[0] == digits[1] || digits[0] == digits[2] || digits[1] == digits[2]) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력 받은 문자열이 3자리 인지 확인해 주는 메소드 입니다.
     */
    private void threeNumber(String input){

        if (input.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력 받은 문자열이 1 ~ 9 까지의 숫자인지 확인해 주는 메소드 입니다.
     */
    private void isNumber(String input){

        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }
}

package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Game {

    private static List<Integer> answer;
    private static List<Integer> playerInputNum;

    private boolean exit = false;

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        answer = createRandomNumber();
        while(!exit) {
            playerInputNum = inputNum(); // 검증까지 끝
            printResult(playerInputNum);
        }

    }

    // 랜덤 세자리 수 정답 생성
    public List<Integer> createRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while(randomNumber.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
        //System.out.println("테스트용 정답 : "+randomNumber);
        return randomNumber;
    }

    // 플레이어한테 숫자 입력받기
    public List<Integer> inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        ValidateInputNum(input);
        List<Integer> inputNumber = new ArrayList<>();
        for(int i=0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int num = Character.getNumericValue(ch);
                inputNumber.add(num);
            }
        }
        return inputNumber;
    }

    // 입력받은 문자열이 숫자가 맞는지 검증
    public boolean isValidNumber(String input) {
        String pattern = "^[1-9]*$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException("입력값이 올바르지 않아 종료합니다.");
        }
        return true;
    }

    // 입력받은 문자열이 세자리인지 검증
    public boolean isThreeDigit(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException("입력값이 세자리가 아니므로 종료합니다.");
        }
        return true;
    }

    // 입력받은 문자열에 대해 중복 검증
    public boolean isNotDuplicate(String input) {
        if(input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2)){
            throw new IllegalArgumentException("입력값에 중복된 값이 존재하므로 종료합니다.");
        }
        return true;
    }

    public void ValidateInputNum(String input) {
        if (!isValidNumber(input) || !isThreeDigit(input) || !isNotDuplicate(input)) {
            throw new IllegalArgumentException();
        }
    }


    public int countStrike(List<Integer> answer, List<Integer> input) {
        int cnt = 0;
        for (int i =0; i < answer.size(); i++) {
            if(answer.get(i).equals(input.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countBall(List<Integer> answer, List<Integer> input) {
        int cnt = 0;
        for (int i =0; i < answer.size(); i++) {
            if(!answer.get(i).equals(input.get(i)) && answer.contains(input.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    // 재시작 입력에 대한 검증
    public boolean isRestartValidNumber(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력값이 1과 2 중 하나의 수가 아니므로 종료합니다.");
        }
        return true;
    }
}
package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static List<Integer> answer;
    private static List<Integer> playerInputNum;

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        answer = createRandomNumber();
        playerInputNum = inputNum();
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
        return randomNumber;
    }

    // 플레이어한테 숫자 입력받기
    public List<Integer> InputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> inputNum = new ArrayList<>();
        for(int i=0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int num = Character.getNumericValue(ch);
                inputNum.add(num);
            }
        }
        return inputNum;
    }
}
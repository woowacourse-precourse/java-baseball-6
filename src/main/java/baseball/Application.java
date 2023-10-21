package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void getNums(){   // 나와 상대방(컴퓨터)의 숫자 생성
        // 상대방(컴퓨터) 숫자
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        // 내 숫자
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        System.out.println();
        // 숫자 개수가 3개가 아닐 경우 예외처리
        if (inputNumber.length() > 3 || inputNumber.length() < 3){
            throw new IllegalArgumentException();
        }
        List<Integer> mine = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = inputNumber.charAt(i);
            if (mine.contains(num)) {  // 중복입력 예외처리
                throw new IllegalArgumentException();
            }else mine.add(num);
        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        getNums();  // 숫자 입력 받기
    }
}

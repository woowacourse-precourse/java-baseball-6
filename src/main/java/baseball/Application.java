package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 숫자 생성, 초기화
    public static List create_answer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    
    // 숫자 입력
    public static String InputNum() {
        String inputNum = Console.readLine();
        System.out.println(inputNum);
        return inputNum;
    }
    // 입력 오류 검사
    public static int validation(String str) {
        int num = Integer.parseInt(str);
        try {
            if(str.length() != 3)
                throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
            else if(num <= 0)
                throw new IllegalArgumentException("음수나 0은 불가능합니다.");
            else if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0')
                throw new IllegalArgumentException("1~9까지의 숫자만 입력 가능합니다.");
            else if(str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) ||
            str.charAt(1) == str.charAt(2))
                throw new IllegalArgumentException("중복된 숫자는 불가능합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("error : " + e.getMessage());
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = create_answer();
        int status = 1; // 게임 진행 상태
        while(status == 1) {
            String input = InputNum();
            if(validation(input) == 0)
                break;
        }
        System.out.println("게임을 완전히 종료합니다.");
    }
}

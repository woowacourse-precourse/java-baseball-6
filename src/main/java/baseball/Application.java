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
        System.out.print("숫자를 입력해주세요: ");
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

    // 결과 출력
    public static boolean baseball(List<Integer> answer, String str) {
        int ball = 0, strike = 0;
        for(int i=0; i<3; i++) {
            int n = answer.get(i);
            for(int j=0; j<3; j++){
                if(n == str.charAt(j) - '0') {
                    if(i == j)
                        strike++;
                    else
                        ball++;
                }
            }
        }
        if(ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if(strike == 3) {
            System.out.println("3스트라이크");
            return true;
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = create_answer();
        int status = 1; // 게임 진행 상태
        while(status == 1) {
            String input = InputNum();
            if(validation(input) == 0)
                break;
            if(baseball(answer, input)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                status = Integer.parseInt(Console.readLine());
            }
        }
        System.out.println("게임을 완전히 종료합니다.");
    }
}

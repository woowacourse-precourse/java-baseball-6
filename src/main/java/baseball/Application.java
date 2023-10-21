package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    // 사용자 입력 무결성 체크 함수
    public static boolean inputCheck(String user, int len, char start, char end){
        int num[] = new int[9];
        if (user.length() != len)
            return false;
        for (int i = 0; i < len; i++){
            if (!(start <= user.charAt(i) && user.charAt(i) <= end))
                return false;
            if(++num[user.charAt(i) - '0' - 1] >= 2)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // -- 프리코스 1주차 라이브러리 사용 예시 코드 --
        /* pickNumberInRange 테스트
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        */

        /* readLine() 테스트
        System.out.println(readLine());
        */

        boolean contiGame = true;
        // 프로그램 전체 동작 반복 제어
        while(contiGame){
            // ---- 게임 초기화 과정 (추후 모듈화)
            // 컴퓨터 숫자 생성
            String user = new String();
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            // ----

            System.out.println("숫자 야구 게임을 시작합니다.");
            // 사용자 입력, 숫자 야구 규칙 적용 반복 제어
            while(true){
                int ball = 0, strike = 0;
                // 사용자 입력
                System.out.print("숫자를 입력해주세요 : ");
                user = readLine();
                
                if (!inputCheck(user, 3, '1', '9'))
                    throw new IllegalArgumentException();

                // 컴퓨터, 사용자 숫자 검증 (추후 모듈화)
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        if (computer.get(i) == (user.charAt(j) - '0')){
                            if (i == j)
                                strike++;
                            else
                                ball++;
                        }
                    }
                }

                // 볼, 스트라이크 결과 출력 (추후 모듈화?)
                if (ball != 0)
                    System.out.print(ball + "볼 ");
                if (strike != 0)
                    System.out.print(strike + "스트라이크");
                if (ball == 0 && strike == 0)
                    System.out.print("낫싱");
                System.out.println();    
            
                // 사용자가 숫자를 맞췄을 경우 (추후 모듈화?)
                if (strike == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    user = readLine();

                    if (!inputCheck(user, 1, '1', '2'))
                        throw new IllegalArgumentException();

                    // 사용자의 입력이 2인 경우 프로그램 전체 반복 제어 변수를 변경
                    if (user.charAt(0) == '2')
                        contiGame = false;
                    break;
                }
            }
        }
    }
}

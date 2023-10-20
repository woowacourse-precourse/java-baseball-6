package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public int strike = 0;
    public int ball = 0;

    List<Integer> computer = new ArrayList<>();
    List<Integer> user = new ArrayList<>();



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");


        // strike, ball 변수 생성 및 초기화

        // 컴퓨터 랜덤값 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("com: " + computer.toString());

        // 사용자 입력
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);

        List<Integer> user = new ArrayList<>();
        while (user.size() < 3) {
            int userNumber = sc.nextInt();

        }


        sc.close();

//        while(true) {
//            strike = 0;
//            ball = 0;
//        }

    }

    // 스트라이크, 볼 여부 확인
    public boolean judgeStrike() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(computer.get(i) == user.get(j)) {   // com[0] - user[0][1][2] 비교 // com[1] - user[0][1][2] 비교 ...
                    if(i==j) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }
                }
            }
        }
        if(strike == 3) {            // for문 종료 후, Strike가 3이면 true 반환
            return true;
        } else {                  // 그렇지 않으면 false 반환
            return false;
        }
    }
}

/*
1. 3개의 랜덤한 수 고르기(만들어서 str로 만들어 두자)
2. 반복: 한 게임이 끝날 때 까지(맞추거나 잘못된 값을 입력하는 동안)
3. 한 숫자를 계속 맞춰야 됨
    - do{} while(조건);
4. 숫자 맞치면 게임 종료(1, 2 선택하세요)
5. 잘못된 값 => IllegalArgumentException
6. 숫자 비교:
    - 한 게임이 시작될 때 random으로 각자 다른 수가 들어진 배열을 만들기
    - 입력도 배열로 만들기
    - 입력을 반복문을 돌면서 자리가 같은지 아닌지 확인하기(아니면 둘 다 스트링으로 하고 index 찾는 함수 있으면 쓰기)
    - string은 indexOf를 사용할 수 있음. 그럼 입력을 반복문으로 보낸 i와 인덱스가 같은지 확인하거나 아님 i, j 이중 for문 쓰거나
7. 볼: 숫자만 맞는 것, 스트라이크: 숫자도 맞고 자리도 맞고
8. 1~9의 서로 다른 숫자
9. https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java 자바 스타일 가이드
 */


package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 초기화

        Random rand = new Random();
        int end = 1;


        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isFinish = false;
        // 게임 진행
        while (end == 1) {
            // 한 게임당 초기화
            // 랜덤한 수가 들어가는 com 리스트
//            List<String> com = new ArrayList<String>();/
            String com = "";
            isFinish = false;

            while (com.length() < 3) {
                int r = rand.nextInt(9) + 1;
                String sr = Integer.toString(r);
                if (!com.contains(sr)) {     //리스트에 포함되지 않는다면 추가하고 실행
                    com = com + sr;
                }
            }
            //@@@@ 삭제해야 하는 코드
            System.out.println("answer: "+com);
            // 게임 시작

            // while (게임 진행되는 동안)
            while (!isFinish) {
                int strike = 0;
                int ball = 0;
                // 입력
                System.out.print("숫자를 입력해주세요 : ");
                Scanner sc = new Scanner(System.in);
                String num = sc.nextLine();
                // TODO: 이상한 입력 체크
                // 잘못된 입력 1: 3자리가 아닌 수일 경우(1,2,4, ...)
                // 잘못된 입력 2: 0이 들어올 경우
                // 잘못된 입력 3: 숫자가 아닌 경우
                // 비교
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (num.charAt(i) == com.charAt(j)) {
                            if (i == j) {
                                strike += 1;
                            } else {
                                ball += 1;
                            }
                        }
                    }
                }

                // 결과
                // 정답: 일단 나가기
                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    end = sc.nextInt();
                    // TODO: 잘못된 값 입력됬는지 확인!
                    isFinish = true;

                }
                else if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }
                else {
                    System.out.println(ball+"볼 "+strike+"스트라이크");
                }
                // 계속

            }

        }

    }
}

/*
1. 3개의 랜덤한 수 고르기(만들어서 str로 만들어 두자)
2. 반복을 어디서부터 어디까지 하는지 확인
3. 한 숫자를 계속 맞추는 것이 아니라 숫자를 입력할 때마다 랜덤으로 숫자를 만들고 결과를 나타내야됨
    - do{} while(조건);
4. 오타 주의
5. 숫자 맞치면 게임 종료(1, 2 선택하세요)
6. 잘못된 값 => IllegalArgumentException
7. 숫자 비교: for문을 돌면서 i를 둘 다 입력해서 서로 비교해서 같으면 스트라이크 다르면 볼?

다시 생각
1. 한 숫자에 대해 반복을 실행하고 맞추고 다른 게임을 시작할 때 랜덤 숫자가 바뀌어야됨
2. 볼: 숫자만 맞는 것, 스트라이크: 숫자도 맞고 자리도 맞고


추가해야 할 것
1. 0으로 시작하게
2. 이상한 숫자를 입력했ㅇㄹ 때 IllegalArgumentException
*/


package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean isFinisth = false;
        do {

            System.out.print("숫자를 입력해주세요 : ");
            String num = sc.nextLine();
            // 난수와 비교

            //@@@@@@ 제거!
            System.out.println("check num:"+num);
            List<String> com = new ArrayList<String>();
            int strike = 0;
            int ball = 0;

            //@@@@@@ 제거!!
            System.out.println("check size: "+com.size());
            System.out.println("check charAt: "+num.charAt(0));
            int size = 0;
            while (size < 3) {
                size = com.size();
                // 서로 다른 3개의 숫자가 아님!
                // 배열을 만들어서 집어넣고 안나오게 해야 됨
                int r = rand.nextInt(9)+1;
                String sr = Integer.toString(r);
                if (com.contains(sr)) {     // 리스트에 포함된다면
                    continue;
                } else {     // 리스트에 포함되지 않는다면 추가하고 실행
                    com.add(sr);

                    // 추가를 하고 add 하기 때문에!
                    if (sr.equals(num.charAt(size))) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }
                }
            }
            System.out.println("check com: "+com);
            // 3가지 수를 비교하고 나서
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                // 새로 시작하는 boolean을 넣어 주기
                int newgame = sc.nextInt();
                if (newgame == 2){
                    isFinisth = true;
                }

            } else if (ball == 3) {
                System.out.println("낫싱");
            } else {
                System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            }
        }
        while(!isFinisth);


        sc.close();





    }
}

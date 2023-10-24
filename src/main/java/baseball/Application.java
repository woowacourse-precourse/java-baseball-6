package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){

            //상대방 숫자 설정
            int[] com = new int[3];
            for ( int i = 0 ; i < com.length ; i++ ){
                com[i] =  Randoms.pickNumberInRange(1,9); // 1~9에 해당하는 랜덤 정수 입력
            }

            //겹치는 수가 있으면 다시 시작
            if ( com[0] == com[1] || com[0] == com[2] || com[1] == com[2] ){
                continue;
            }


            while(true){

                int strike = 0;
                int ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
                //사용자 숫자 입력
                int num = Integer.parseInt(Console.readLine());

                //사용자 입력값 오류 확인 (3자리 수가 아닌 경우)
                if ( !(num > 100 && num < 1000 )){
                    throw new IllegalArgumentException("올바르지 않은 값을 입력했습니다."); // 사용자가 잘못된 값을 입력한 경우 (세자리 수를 입력하지 않은 경우)
                }

                int[] me = new int[3];
                for (int i = 2; i >= 0 ; i-- ){
                    me[i] = num % 10;
                    num = num / 10;
                }

                //사용자 입력값 오류 확인 (서로다른 수가 아닌 경우)
                if ( me[0] == me[1] || me[0] == me[2] || me[1] == me[2] ){
                    throw new IllegalArgumentException("올바르지 않은 값을 입력했습니다."); // 사용자가 잘못된 값을 입력한 경우 (세개의 숫자에 중복이 있는 경우)
                }

                //사용자 숫자와 상대방 숫자 비교
                if ( com[0] == me[0] ) strike++;
                if ( com[1] == me[1] ) strike++;
                if ( com[2] == me[2] ) strike++;

                if ( com[0] == me[1] || com[0] == me[2] ) ball++;
                if ( com[1] == me[0] || com[1] == me[2] ) ball++;
                if ( com[2] == me[0] || com[2] == me[1] ) ball++;

                //결과출력
                if ( ball == 0 && strike == 0 ){
                    System.out.println("낫싱");
                }
                else{
                    if ( ball != 0 ){
                        if ( strike != 0 ) System.out.print(ball + "볼 ");
                        else System.out.println(ball + "볼");
                    }
                    if ( strike != 0 ) {
                        System.out.println(strike + "스트라이크");

                        if ( strike == 3 ){
                            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                            break;
                        }
                    }
                }


            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int flag = Integer.parseInt(Console.readLine());
            if ( flag == 1 ) continue;
            else if ( flag == 2 ) break;
            else throw new IllegalArgumentException("올바르지 않은 값을 입력했습니다."); // 사용자가 잘못된 값을 입력한 경우 (1,2 가 아닌 값을 입력)
        }




    }
}

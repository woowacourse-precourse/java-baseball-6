package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int len = 3;                 // N자리 수 숫자 야구 게임
        int restart = 1;             // 재시작 및 최종 루프 탈출 변수
        int s_cnt, b_cnt;            // strike & ball count
        int[] answer = new int[len]; // 정답 Array
        int[] input = new int[len];  // 입력 Array

        System.out.print("숫자 야구 게임을 시작합니다.\n");
        while(restart == 1) { // restart가 1이면 재시작함

            // 정답생성(with 중복방지) : 이전과 같은 랜덤넘버가 들어오면 i--로 루프재실행
            answer[0] = Randoms.pickNumberInRange(1, 9);
            for (int i = 1; i < len; i++){
                answer[i] = Randoms.pickNumberInRange(1, 9);
                for(int j=0;j<i;j++){
                    if(answer[i] == answer[j]) {
                        i--;
                        break;
                    }
                }
            }

            // 한 문제를 맞추거나 예외발생 시까지 무한루프
            while(true) {
                /*  Input to IntArray */
                System.out.print("숫자를 입력해주세요 : ");
                String temp = Console.readLine();

                // 서로다른, 세자리의, 1~9까지의 수가 아니면 예외발생 : 0을 넣는 것도 입력범위를 초과하는 것으로 보았음
                if (temp.length() != len)
                    throw new IllegalArgumentException("잘못된 입력 값입니다.");  // 세 자리수가 아니면 예외발생
                for(int i = 0; i < len; i++) {
                    try {
                        String str_temp = Character.toString(temp.charAt(i)); // 문자열 1개짜리 String으로 분리
                        input[i] = Integer.parseInt(str_temp);                // 해당 문자열을 int로 변환
                        if(input[i]==0) i = 1/0;                              // 0입력시 에러발생->예외발생
                    }catch(Throwable t){                                      // 정수변환이 안되면 예외발생
                        throw new IllegalArgumentException("잘못된 입력 값입니다.");
                    }

                    for(int j = 0; j < i; j++) {
                        if(input[i] == input[j])                              // 서로 다른 수가 아니면 예외발생
                            throw new IllegalArgumentException("잘못된 입력 값입니다.");
                    }
                }

                /* Strike & Ball check */
                // 같은 숫자가 같은자리면 strike, 다른자리면ball
                s_cnt = 0; b_cnt = 0;
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        if ((i == j) && (answer[i] == input[j])) s_cnt++;
                        else if ((i != j) && (answer[i] == input[j])) b_cnt++;
                    }
                }

                // 볼/스트라이크/낫싱 판별문 출력
                if (b_cnt == 0 && s_cnt == 0) System.out.print("낫싱");
                if (b_cnt > 0) System.out.print(b_cnt + "볼 ");
                if (s_cnt > 0) System.out.print(s_cnt + "스트라이크 ");
                System.out.print("\n");

                if (s_cnt == len) {
                    System.out.print(len+"개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                    break;
                }
            }

            // Game Restart with Exception Handling
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            restart = Integer.parseInt(Console.readLine());
            if (restart != 1 && restart != 2) // 1과 2가 아닌 값은 예외발생
                throw new IllegalArgumentException("잘못된 입력 값입니다.");
        }
    }
}
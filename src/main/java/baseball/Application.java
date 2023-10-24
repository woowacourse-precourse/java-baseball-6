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
        while(restart == 1) {
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

            while(true) {
                /* Part1 : Input to Array */
                System.out.print("숫자를 입력해주세요 : ");
                String temp = Console.readLine();
                if (temp.length() != len){
                    throw new IllegalArgumentException("잘못된 입력 값입니다.");
                }
                for(int i = 0; i < len; i++) {
                    char char_temp = temp.charAt(i);
                    String str_temp = Character.toString(char_temp);
                    input[i] = Integer.parseInt(str_temp);

                    for(int j = 0; j < i; j++) {
                        if(input[i] == input[j]){
                            throw new IllegalArgumentException("잘못된 입력 값입니다.");
                        }
                    }
                }
                /* Part2 : Strike & Ball check */
                s_cnt = 0; b_cnt = 0;
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        if ((i == j) && (answer[i] == input[j])) s_cnt++;
                        else if ((i != j) && (answer[i] == input[j])) b_cnt++;
                    }
                }
                if (b_cnt == 0 && s_cnt == 0) System.out.print("낫싱");
                if (b_cnt > 0) System.out.print(b_cnt + "볼 ");
                if (s_cnt > 0) System.out.print(s_cnt + "스트라이크 ");
                System.out.print("\n");

                if (s_cnt == len) {
                    System.out.print(len+"개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                    s_cnt = 0; b_cnt = 0;
                    break;
                }
            }
            // Game Restart with Exception Handling
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            restart = Integer.parseInt(Console.readLine());
            if (restart != 1 && restart != 2){
                System.out.print("잘못된 입력입니다. 종료합니다\n");
                break;
            }
        }
    }
}

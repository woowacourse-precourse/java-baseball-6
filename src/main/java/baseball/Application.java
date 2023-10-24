package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.pool.TypePool;

import java.util.HashSet;
import java.util.Set;

public class Application {

    // Answer Check Method
    public static int[] check(int[] answer, int[] input){
        // idx 0 : Strike, 1 : ball
        int[] result = {0, 0};
        // input값과 매칭된 경우 true로 하여 매칭 대상에서 삭제
        boolean[] flag = {false, false, false};

        // i : input값의 idx
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 3; k++){
                if(flag[k] == false){ // 매칭되지 않은 수의 경우
                    // 스트라이크의 경우
                    if(answer[i] == input[k] && i == k) {
                        result[0]++;
                        flag[k] = true;
                        break;
                    }
                    // 볼의 경우
                    else if(answer[i] == input[k] && i != k) {
                        result[1]++;
                        flag[k] = true;
                        break;
                    }
                }
            }
        }

        return result;
    }

    // 입력 데이터의 숫자가 중복되는지 확인하는 함수
    public static boolean diffCheck(String input){
        Set<Character> set = new HashSet<>();
        boolean result = false;

        for(int i = 0; i < input.length(); i++){
            set.add(input.charAt(i));
        }

        if(set.size() == 3){
            result = true;
        }

        return result;
    }

    // 입력데이터의 형식 확인 및 예외 throw
    public static void inputDataCheck(String input) throws IllegalArgumentException {
        // 정규표현식을 통한 길이 및 숫자 데이터인지 확인
        // input데이터의 숫자들이 중복이 되는지 확인
        if (!input.matches("[1-9]{3}") || !diffCheck(input))
            throw new IllegalArgumentException(); // 형식에 맞지 않는다면 IllegalArgumentException Throw

    }

    // 게임 재실행 여부 형식 확인 및 예외 throw
    public static void againDataCheck(String input) throws IllegalArgumentException {
        if(!input.equals("1") && !input.equals("2"))
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String again = "1";

        while(again.equals("1")) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 상대방으로부터 3개의 랜덤 숫자를 생성한다.
            int[] answer = {
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9)
            };

            int[] result = new int[2]; // 정답 검사 결과를 받기 위한 int배열

            // 스트라이크가 3번이 나올때까지 실행
            while (result[0] < 3) {
                // 사용자로부터 숫자 3개를 입력받는다.
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                // 형식체크 및 예외
                inputDataCheck(input);

                // 입력 숫자의 정답 검사를 위한 String -> int[]변환
                int[] input_array = new int[3];
                for (int i = 0; i < input.length(); i++)
                    input_array[i] = input.charAt(i) - '0';


                // 정답 검사 메소드 실행
                result = check(answer, input_array);
                if (result[0] == 0 && result[1] == 0) {
                    System.out.println("낫싱");
                } else {
                    if (result[0] > 0 && result[1] > 0)
                        System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
                    else if (result[0] == 0) // 볼만 존재하는 경우
                        System.out.println(result[1] + "볼");
                    else if (result[1] == 0)
                        System.out.println(result[0] + "스트라이크");
                }
            }
            // 스트라이크가 3번인 경우
//            if(result[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            again = Console.readLine();
            // 형식체크 및 예외
            againDataCheck(again);

//            }
        }


    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        Start();

    }

    public static void Start(){
        String select = "1";

        while(select.equals("1")){
            String answer = Make_Random_Num();
            Game(answer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            select = Input.In_Sec();

        }

    }


    public static void Game(String answer){

        int success = 0;

        while(success != 1){
            success = Comp(Input.In_Fir(), answer);
        }

    }

    public static int Comp(String input, String answer){

        int strike = 0, ball = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(input.charAt(i) == answer.charAt(j)){
                    ball++;
                    if(i == j){
                        strike++;
                    }
                }
            }
        }

        ball -= strike;

        if(strike == 3){
            System.out.println("3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        }
        else{
            if(ball > 0){
                System.out.print(ball + "볼");
                if(strike > 0){
                    System.out.println(" " + strike + "스트라이크");
                }
            }
            else if(ball == 0 && strike > 0){
                System.out.println(strike + "스트라이크");
            }
            else{
                System.out.println("낫싱");
            }


            return 0;
        }


    }

    public static String Make_Random_Num(){
        int cnt = 0;
        int result = 0;
        int[] check = new int[10];

        while(cnt < 3){

            int temp = Randoms.pickNumberInRange(1, 9);

            if(check[temp] == 0){
                result *= 10;
                result += temp;
                cnt++;
            }
        }

        String com_result = Integer.toString(result);

        return com_result;
    }

}

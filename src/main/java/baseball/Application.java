package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static String get_userNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        if(userNumber.matches("[0-9]+")){
            int nbr_len = userNumber.length();
            if(nbr_len != 3){
                throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
            }
        }
        else{
            throw new IllegalArgumentException("문자가 포함되어 있습니다.");
        }
        return userNumber;
    }
    public static boolean check_GameOver(List<Integer> computer, String userNumber){
        int ball = 0;
        int strike = 0;

        for(int i=0; i<3; i++){
            int x = (int) userNumber.charAt(i) - 48;

            // strike check
            if(computer.get(i) == x){
                strike += 1;
            }
            // ball check
            if(computer.contains(x)){
                ball += 1;
            }
        }
        ball -= strike;

        // print result
        if(strike == 3){
            System.out.printf("%d스트라이크\n", strike);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if(ball == 0 & strike == 0){
            System.out.println("낫싱");
        }
        else{
            if(ball > 0) {
                System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            }
            else{
                System.out.printf("%d스트라이크\n", strike);
            }
        }
        return false;
    }

    public static void play_games(){
        // 필요 변수 선언
        boolean gameover = false;

        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 수 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //System.out.println(computer);

        while(!gameover) {
            // 사용자 수 입력 받기
            String userNumber = get_userNumber();

            // strike, ball check
            gameover = check_GameOver(computer, userNumber);
        }
        return;
    }
    public static void main(String[] args) {
        int restart = 1;
        while(restart == 1){
            play_games();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String temp = Console.readLine();
            restart = Integer.valueOf(temp);
        }
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            play_game();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String isContinue = Console.readLine();
            if (isContinue.equals("2")){
                break;
            }
            else if (!isContinue.equals("1")){
                throw new IllegalArgumentException();
            }
        }
    }

    private static void play_game(){
        // generate computer's random 3 numbers
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // count the numbers of ball and strike
        // break when 3 strikes
        int strikes = 0;
        while (strikes < 3){
            strikes = 0;
            int balls = 0;
            System.out.print("숫자를 입력해주세요 : ");
            String guess_nums = Console.readLine();

            //중복된 숫자 또는 3개 이상 숫자 입력 예외처리
            if (guess_nums.length() != 3){
                throw new IllegalArgumentException();
            }
            else {
                if (guess_nums.charAt(0) == guess_nums.charAt(1) || guess_nums.charAt(1) == guess_nums.charAt(2) ||
                        guess_nums.charAt(2) == guess_nums.charAt(0)){
                    throw new IllegalArgumentException();
                }
            }

            for (int i = 0; i < 3; i++){
                int num = guess_nums.charAt(i) - '0';

                // 숫자 범위 예외처리
                if (num < 1 || num > 9){
                    throw new IllegalArgumentException();
                }

                // 스트라이크, 볼 카운트
                if (computer.contains(num)){
                    if (computer.get(i) == num){
                        strikes++;
                    }
                    else{
                        balls++;
                    }
                }
            }

            if (balls == 0 && strikes == 0){
                System.out.println("낫싱");
            }
            else if (balls == 0) {
                System.out.printf("%d스트라이크\n", strikes);
            }
            else if (strikes == 0) {
                System.out.printf("%d볼\n", balls);
            }
            else {
                System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

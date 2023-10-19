package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int play_on =0;
        List<Integer> computer = new ArrayList<>();

        while(true){
            if(play_on ==0){
                // 목표값 설정
                while(computer.size() < 3){
                    int randomNumber = Randoms.pickNumberInRange(1,9);
                    if (!computer.contains(randomNumber)){
                        computer.add(randomNumber);
                    }
                }
                play_on=1;
            }
            if(play_on ==1) {
                System.out.print("숫자를 입력해주세요 : ");
                String guess = Console.readLine();

                int strike = 0;
                int ball = 0;
                int nothing = computer.size();
                int temp = 0;

                while (temp < guess.length()) {
                    int guess_num = guess.charAt(temp);

                    if (computer.contains(guess_num)) {
                        if (guess_num == computer.get(temp)) {
                            strike++;
                        } else ball++;
                    } else nothing--;
                }
                if (nothing != 0) {
                    if (strike == 3) {
                        System.out.println("3스트라이크");
                        play_on = 3;
                    }
                    if (ball == 0) {
                        System.out.println(strike + "스트라이크");
                    }
                    if (strike == 0) {
                        System.out.println(ball + "볼");
                    }
                    if (strike * ball > 0) {
                        System.out.println(ball + "볼 " + strike + "스트라이크");
                    }
                }
            }
            if(play_on==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                play_on = Integer.parseInt(Console.readLine());
            }
            if(play_on==2){
                break;
            }

        }



    }
}

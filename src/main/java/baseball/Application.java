package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int play_on =1;
        List<Integer> computer = new ArrayList<>();

        while(true){
            if(play_on ==1){
                // 목표값 설정
                while(computer.size()>0){
                    computer.remove(computer.size()-1);
                }
                while(computer.size() < 3){
                    int randomNumber = Randoms.pickNumberInRange(1,9);
                    if (!computer.contains(randomNumber)){
                        computer.add(randomNumber);
                    }
                }
                play_on=0;
            }
            if(play_on ==0) {
                System.out.print("숫자를 입력해주세요 : ");
                String guess = Console.readLine();

                int strike = 0;
                int ball = 0;
                int nothing = computer.size();
                int temp = 0;

                while (temp < guess.length()) {
                    int guess_num = Integer.parseInt(String.valueOf(guess.charAt(temp)));

                    if (computer.contains(guess_num)) {
                        int located_num = computer.get(temp);
                        if (guess_num == located_num) {
                            strike++;
                        } else ball++;
                    } else nothing--;
                    temp+=1;
                }
                if (nothing != 0) {
                    if (strike == 3) {
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
                if(nothing ==0){
                    System.out.println("낫싱");
                }
            }
            if(play_on==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int user_input = Integer.parseInt(Console.readLine());
                System.out.println("[user input] >>> "+user_input);
                play_on = user_input;
            }
            if(play_on==2){
                break;
            }

        }



    }
}

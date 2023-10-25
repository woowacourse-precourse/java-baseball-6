package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException{

        boolean status=true;

        while (status) {
            // 게임시작 안내
            System.out.println(InfoMessage.START.getMessage());
            // 랜덤 숫자 만들기
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if(!computer.contains(randomNumber))
                    computer.add(randomNumber);
            }
            System.out.println(computer.toString());

            boolean inputNum = true;
            // 숫자 입력받기
            while (inputNum) {
                System.out.print(InfoMessage.INPUT_NUMBER.getMessage());
                String str = Console.readLine();
                int strike = 0;
                int ball = 0;
                for (int i = 0; i < 3; i++) {
                    int num = str.charAt(i)-'0';
                    if (computer.get(i) == num) {
                        strike++;
                    } else if(computer.contains(num)){
                        ball++;
                    }
                }
                String ans ="";
                if (strike == 3) break;

                if(ball > 0){
                    ans+= ball+"볼 ";
                }
                if (strike > 0) {
                    ans += strike + "스트라이크 ";
                }
                if(strike==0&&ball==0){
                    ans += "낫싱";
                }
                System.out.println(ans);
            }//while
            // 숫자를 모두 맞힌 경우
            System.out.println(InfoMessage.CORRECT_ANSWER.getMessage());
            System.out.println(InfoMessage.RESTART.getMessage());

            int choice = Integer.parseInt(Console.readLine());
            if (choice == 1) {
                status = true;
            } else if (choice == 2) {
                status = false;
            } else {
                status = false; // 다시확인
                throw new IllegalArgumentException();
            }

        }
    }
}

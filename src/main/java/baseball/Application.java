package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        while(true){
            System.out.println("숫자 야구 게임을 시작합니다.");
            int[] answerA = new int[3];
            for(int i=0; i<3; i++){
                answerA[i] = pickNumberInRange(1,9);
                for(int k=0; k<i; k++){
                    if(answerA[k]==answerA[i]){
                        i--;
                        break;
                    }
                }
            }

            int ball = 0;
            int strike = 0;
            while (strike<3){
                System.out.print("숫자를 입력해주세요 : ");
                String input = readLine();
                ball = 0;
                strike = 0;
                for(int i=0; i<3; i++){
                    int inputN = input.charAt(i)-'0';
                    if(inputN==answerA[0] || inputN==answerA[1] || inputN==answerA[2]){
                        if(inputN == answerA[i]) strike++;
                        else ball++;
                    }
                }

                if(ball>0 && strike>0) {
                    System.out.println(ball + "볼 "+strike+"스트라이크");
                }
                else if(ball>0) {
                    System.out.println(ball+"볼");
                }
                else if(strike>0) {
                    System.out.println(strike+"스트라이크");
                }
                else {
                    System.out.println("낫싱");
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String exitType = readLine();
            if(exitType.equals("2")) break;
        }


    }
}

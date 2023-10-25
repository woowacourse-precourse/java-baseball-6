package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.ResultType.*;

public class Application {
    private static boolean status;
    private static List<Integer> computer;
    public static void main(String[] args){

        status = true;

        while (status) {
            gameStart();
            boolean inputNum = true;

            while (inputNum) {
                System.out.print(InfoMessage.INPUT_NUMBER.getMessage());
                String str = Console.readLine();
                if (str.length() != 3) {
                    throw new IllegalArgumentException();
                }
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
                if (strike == 3){
                    ans="3"+STRIKE;
                    inputNum=false;
                }
                if(ball > 0){
                    ans+= ball+BALL+" ";
                }
                if (strike!=3 && strike > 0) {
                    ans += strike + STRIKE + " ";
                }
                if(strike==0&&ball==0){
                    ans += NOTHING;
                }
                System.out.println(ans);
            }//while
            SuccessCorrectAnswer();
        }
    }
    private static void SuccessCorrectAnswer(){
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
    private static void makeRandomNumber(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
    }
    private static void gameStart(){
        System.out.println(InfoMessage.START.getMessage());
        computer = new ArrayList<>();
        makeRandomNumber();
    }

}

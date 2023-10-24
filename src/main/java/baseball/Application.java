package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

class IllegalArgumentException extends Exception{
    public IllegalArgumentException() {}
    public IllegalArgumentException(String message){
        super(message);
    }
}

public class Application {
    public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현

        Scanner scan = new Scanner(System.in);
        List<Integer> computer = new ArrayList<>();

         while (computer.size() < 3) {
             int randomNumber = Randoms.pickNumberInRange(1, 9);
             if (!computer.contains(randomNumber)) {
                 computer.add(randomNumber);
             }
         }

        System.out.println("숫자 야구 게임을 시작합니다.");
        int power = 1;

        while(power!=2){

            System.out.print("숫자를 입력해주세요 : ");
            String str = readLine();

            if (str.length() != 3)
                throw new IllegalArgumentException("Invalid argument: " + str);
            else if(str.charAt(0) == '0' ||
                    str.charAt(1) == '0' ||
                    str.charAt(2) == '0')
                throw new IllegalArgumentException("Invalid argument: " + str);
            else if(countChar(str,str.charAt(0))>1 ||
                    countChar(str,str.charAt(1))>1 ||
                    countChar(str,str.charAt(2))>1)
                throw new IllegalArgumentException("Invalid argument: " + str);


            List<Integer> user = new ArrayList<>();
            for (int i = 0; i < str.length(); i++)
                user.add(str.charAt(i) - '0'); // 사용자에게 입력받은 숫자를 분할하여 ArrayList에 저장

            int ball=0, strike = 0;

            for(int i=0;i<3;i++){
                int check = user.indexOf(computer.get(i));
                if(check==-1)
                    continue;
                else if(check==i)
                    strike++;
                else
                    ball++;
            }

            if(strike==0 && ball==0)
                System.out.print("낫싱");
            else{
                if(ball!=0)
                    System.out.printf("%d볼 ",ball);
                if(strike!=0)
                    System.out.printf("%d스트라이크",strike);
            }
            System.out.println();

            if(strike==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                power = Integer.parseInt(readLine());

                if(power!=1 && power!=2)
                    throw new IllegalArgumentException("Invalid argument: " + power);
                }
            }
        }
    }
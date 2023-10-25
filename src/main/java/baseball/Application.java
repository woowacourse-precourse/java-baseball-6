package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {

        int end = 0;

        while(end==0){
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }

            }
            int str = 0;
            int ball = 0;
            while(str!=3){
                str = 0;
                ball = 0;


                    System.out.print("숫자를 입력해주세요 : ");
                String num = Console.readLine();
                    String num1 = num.substring(0,1);
                    String num2 = num.substring(1,2);
                    String num3 = num.substring(2,3);
                    int num11 = Integer.parseInt(num1);
                    int num22 = Integer.parseInt(num2);
                    int num33 = Integer.parseInt(num3);

                if(num.length()!=3||num1==num2||num1==num3||num2==num3){
                    throw new IllegalArgumentException();
                }

                    List<Integer> number = new ArrayList<>();
                    number.add(num11);
                    number.add(num22);
                    number.add(num33);
                    for(int i=0;i<3;i++){
                        if(computer.get(i)==number.get(i)){
                            str++;
                        }
                        else if(number.contains(computer.get(i))){
                            ball++;
                        }

                    }
                    if(str==3){
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    }
                    else if(ball>0&&str>0){
                        System.out.println(ball+"볼"+" "+str+"스트라이크");
                    }
                    else if (ball>0&&str==0) {
                        System.out.println(ball+"볼");
                    }
                    else if (ball==0&&str>0) {
                        System.out.println(str+"스트라이크");
                    }
                    else {
                        System.out.println("낫싱");
                    }
            }
            String x = Console.readLine();
            int x1 = Integer.parseInt(x);
            if(x1==1){
                end=0;
            }
            else{
                end=1;
            }
        }












    }

}

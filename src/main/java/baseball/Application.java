package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        int ans=1;
        Scanner s = new Scanner(System.in);

        while(ans==1){
            System.out.println("숫자 야구 게임을 시작합니다.");

            int com1, com2, com3;
            int num1, num2, num3;

            com1 = Randoms.pickNumberInRange(1, 9);
            com2 = Randoms.pickNumberInRange(1, 9);
            while(com1==com2){
                com2 = Randoms.pickNumberInRange(1, 9);
            }
            com3 = Randoms.pickNumberInRange(1, 9);
            while(com1==com3||com2==com3){
                com3 = Randoms.pickNumberInRange(1, 9);
            }


            int scount=0;
            int bcount=0;

            while(scount<=3){
                System.out.print("숫자를 입력해주세요 : ");
                num1 = s.nextInt();
                num2 = s.nextInt();
                num3 = s.nextInt();

                scount=0;
                bcount=0;

                if(num1==com1){
                    ++scount;
                }
                if(num2==com2){
                    ++scount;
                }
                if(num3==com3){
                    ++scount;
                }
                if(num1==com2||num1==com3){
                    ++bcount;
                }
                if(num2==com1||num2==com3){
                    ++bcount;
                }
                if(num3==com1||num3==com2){
                    ++bcount;
                }
                if(scount==3){
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                else if(scount==0&&bcount==0){
                    System.out.println("낫싱");
                }
                else{
                    if(bcount>0){
                        System.out.print(bcount+"볼 ");
                    }
                    if(scount>0){
                        System.out.println(scount+"스트라이크");
                    }
                }

            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            ans = s.nextInt();
        }

    }
}

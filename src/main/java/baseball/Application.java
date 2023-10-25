package baseball;

import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        int ans=1;
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        while(ans==1){
            System.out.println("start game");

            int com1, com2, com3;
            int num1, num2, num3;

            com1 = r.nextInt(9)+1;
            com2 = r.nextInt(9)+1;
            while(com1==com2){
                com2 = r.nextInt(9)+1;
            }
            com3 = r.nextInt(9)+1;
            while(com1==com3||com2==com3){
                com3 = r.nextInt(9)+1;
            }
            System.out.println("random : "+ com1+", "+com2+", "+com3);

            int scount=0;
            int bcount=0;

            while(scount<=3){
                System.out.print("input: ");
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
                    System.out.println("3strike");
                    System.out.println("congratulation! quit");
                    break;
                }
                else if(scount==0&&bcount==0){
                    System.out.println("nothing");
                }
                else{
                    System.out.println(bcount+"ball "+scount+"strike");
                }

            }
            System.out.println("one more time 1, quit 2");
            ans = s.nextInt();
        }

    }
}

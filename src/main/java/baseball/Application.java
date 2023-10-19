package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("start baseball game");

        Scanner sc = new Scanner(System.in);
        while (true){


            while (true){
                // 여기서 새로운 수가 생성되어야 함
                Random ran = new Random();
                int guess = ran.nextInt(10);
                // 여기서 수를 입력받아야 함

                System.out.print("input your number : ");
                int num = sc.nextInt();

                if (guess == num){
                    System.out.println("answer");
                    System.out.println("you want replay? you want  1  not want 2");
                    break;
                } else{
                    System.out.println("retry.");
                }
            }

            int finalNum = sc.nextInt();
            if (finalNum == 2){
                System.out.println("terminate");
                break;
            }
            else if (finalNum == 1){
                System.out.println("game again start");
                continue;
            }

        }

    }
}

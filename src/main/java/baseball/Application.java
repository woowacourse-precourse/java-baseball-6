package baseball;

import java.util.Scanner;
import java.util.Random;3

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //컴퓨터가 만든 서로다른 3개의 수
        int[] ComNum = new int[3];
        Random rd = new Random();   //난수 만들 객체임

        for (int i = 0; i < 3; i++) {
            if (ComNum[i] !=  ComNum[i-1]) {    //중복방지
                ComNum[i] = rd.nextInt(10); //1~9까지 무작위 정수 발생
            }
        }

        //게임시작
        System.out.println("숫자 야구 게임을 시작합니다");

        System.out.println("숫자를 입력해주세요.");
        for (int i = 0; i < 3; i++) {
            int num = sc.nextInt(); //입력할 값

            if (){  //같은 수가 같은 자리에 있으면 스트라이크
                System.out.println();
            }
            else if (){ //다른 자리에 있으면 볼

            }
            else if (){ //같은 수가 전혀 없으면 낫싱

            }
            else {  //성공
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        sc.close();

    }
}

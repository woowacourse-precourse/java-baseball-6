package baseball;

import java.util.Random;
import java.util.Scanner;

public class baseball {

        /*
        사용할 변수
        랜덤으로 뽑힐 서로 다른 세자릿수 (입출력조건이 '서로 다른 세자릿수, 게임이 끝난 후 반복 또는 종료구분 하는 수(1,2)')
        입력할 숫자
        스트라이크, 볼
        */



    int numArr[] = new int[3]; //랜덤숫자를 넣기위한 length 3인 빈 배열
    int inputArr[] = new int[3]; // 사용자가 입력한 숫자를 넣기위한 length 3인 빈 배열
    int strike = 0; //입력한 값의 strike를 저장받을 변수
    int ball = 0; //입력한 값의 ball을 입력받을 변수

    Random random = new Random();
    Scanner scan = new Scanner(System.in);
//        System.out.("숫자야구 게임을 시작합니다.");
    String name = scan.nextLine();
}

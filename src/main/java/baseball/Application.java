package baseball;

import java.util.Scanner;


public class Application {
    public static boolean strick_check(int[] input_arr, int[] com_arr){
        int check_cnt=0;
        for(int i=0;i<input_arr.length;i++){
            if(input_arr[i]==com_arr[i]) check_cnt++;
        }

        if (check_cnt==0)
            System.out.println("낫싱");

        System.out.println(check_cnt+"스트라이크");

        return check_cnt == 3;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요. : ");

        int[] com_arr={4,7,8};
        int[] input_arr=new int[3];
        String num = sc.next();

        for(int i=0;i<num.length();i++){
            input_arr[i]=(int)num.charAt(i)-'0';
        }

        System.out.println(strick_check(input_arr,com_arr));
    }
}

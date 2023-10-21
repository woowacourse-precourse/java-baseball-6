package baseball;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1. 서로 다른 3자리의 수를 입력받는 객체
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("input the nums");
            int baseball_num = sc.nextInt();
            //지금 asdf 넣으면 에러생김


            if(0<baseball_num && baseball_num<1000){
                String strBaseball_num = Integer.toString(baseball_num);
                char[] Baseball_numArr = GetNum(strBaseball_num.toCharArray());

            }else{
                System.out.println("OMG! should input the nums well in range. Error.");
                IllegalArgumentException e;
            }
        }catch(IllegalArgumentException e){
            System.out.println("no. should not input out of variable");
        }
        //-- 0< num <1000
        //-- 변수 숫자가 아니어도 오류
        //-- tochararray 변환해서 length 3자리 이상일경우 IllegalArgumentException
        // try catch문으로 IllegalArgumentException e로 처리.
    }
    private static char[] GetNum(char[] strBaseball_num){
        char[] nums = strBaseball_num;
        return nums;
    }
}


package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>(); // 랜덤숫자3자리 생성
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }   System.out.println(computer);   //난수확인값


        String user = Console.readLine(); // 사용자가 입력할 3자리
        int[] arr = new int[user.length()];
        for( int i = 0; i < user.length(); i++ ) {
            arr[i] = user.charAt(i)- '0';
        }
        for( int j = 0; j < user.length(); j++ ) {
            }System.out.println(Arrays.toString(user.toCharArray()));  // 배열로 입력되는 확인값




//
//
//        int numArr[] = new int[3]; //랜덤숫자를 넣기위한 length 3인 빈 배열
//        int inputArr[] = new int[3]; // 사용자가 입력한 숫자를 넣기위한 length 3인 빈 배열
//        int strike = 0; //입력한 값의 strike를 저장받을 변수
//        int ball = 0; //입력한 값의 ball을 입력받을 변수


    }
}

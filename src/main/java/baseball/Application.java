package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 랜덤숫자3자리 생성 메소드  =============================================================
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }   System.out.println(computer);   //난수확인값

        // 입력값 메소드 =======================================================================
        String user = Console.readLine(); // 사용자가 입력할 3자리 Console.readLine()
        int[] arr = new int[user.length()];
        for( int i = 0; i < user.length(); i++ ) {
            arr[i] = user.charAt(i)- '0';
        }
        for( int j = 0; j < user.length(); j++ ) {
            }System.out.println(Arrays.toString(user.toCharArray()));  // 배열로 입력되는 확인값
        // 배열로 나타낸값을  가독성있게 선언해줄필요가 있을듯

        // 비교 메소드
        //for문으로 computer의 난수 3개와 user


    }
}

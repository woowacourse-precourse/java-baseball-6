package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
                }
                System.out.println(computer);   //난수확인값

                // 입력값 메소드 =======================================================================
                System.out.println("숫자 야구 게임을 시작합니다.");
                System.out.print("숫자 세자리를 입력하세요 : ");
                List<Integer> user = new ArrayList<>();
                for (int i = 0; user.size() < 3; i++) {
                        String userInput = Console.readLine(); // 사용자가 입력할 3자리 Console.readLine()
                        user.add(Integer.parseInt(userInput));
                }
                System.out.println();


//        String arrUser = Arrays.toString(user.toCharArray());
//        if(arrUser.length()!=3){
//                System.out.println("세자리의 숫자만 입력해주세요");
//        for( int j = 0; j < user.length(); j++ ) {
//            }try{
//        }catch (NumberFormatException e){
//            e.printStackTrace();
//        }}        // 예외처리
//        System.out.println(Arrays.toString(user.toCharArray()));  // 배열로 입력되는 확인값

//        System.out.println(arrUser);
                // 배열로 나타낸값을  가독성있게 선언해줄필요가 있을듯

                // 비교 메소드 =========================================================================
                //for문으로 computer의 난수 3개와 user
        }

}

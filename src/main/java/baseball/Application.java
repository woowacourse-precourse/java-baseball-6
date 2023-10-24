package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.jdi.Value;

import java.util.*;

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
                System.out.println("computer = " + computer);   //todo 난수확인값 지워야함

                // 입력값 메소드 =======================================================================
                System.out.println("생각하는 숫자 한개씩 입력(enter)해주세요.");       //todo 예외처리 (중복포함)
                List<Integer> user = new ArrayList<>();
                for (int i = 0; user.size() < 3; i++) {
//                while (user.size() < 3) { // while문 test
                        String userInput = Console.readLine();
                        String userArr = Arrays.toString(userInput.); // 입력값을 배열로 저장
                        System.out.println("userInput = " + userInput);
                        System.out.println("userArr.length() = " + userArr.length());
                        if (CheckValueInput(userInput,0)==0 ||user.size() !=3) {
                                try{
                                        System.out.println("올바른 세자리 숫자를 입력이 되지 않았습니다.");
                                        throw new IllegalArgumentException();
                                }catch(IllegalArgumentException e){
                                        return;
                                }
                        }
                        System.out.println("userArr = "+ userArr);            //todo 중간값 확인 제출전 제거

                        // 판정 메소드 =====================================================================================
                        int ballCount = 0;
                        int strikeCount = 0;
                        System.out.println("userArr.length() = " + userArr.length());
                        for (int j=0; j< userArr.length();j++) {
                                if (computer.contains(userArr.charAt(j))) {
                                        System.out.println("strikeCount = " + userArr.charAt(j));;
                                        if (computer.indexOf(userArr.charAt(j)) == j) {
                                                strikeCount++;
                                        } else {
                                                ballCount++;
                                        }
                                }
                        }
                        // 출력 메소드 ===================================================================================
                        if (strikeCount == 3) {
                                System.out.println("3스트라이크!");
                                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                                String choice = Console.readLine();           //todo 재시작or종료 구현
                                if (choice == "1") {
                                } else if(choice =="2"){
                                        throw null;             // todo 임시
                                }else {
                                        try {
                                                throw new IllegalArgumentException();
                                        }catch (Exception e){
                                                return;
                                        }
                                }
                        } else if (strikeCount + ballCount == 0) {
                                System.out.println("낫싱!");
                        } else {
                                System.out.println(ballCount + "볼, " + strikeCount + "스트라이크");        // 출력
                        }

//                int[] test = new int[0];              // 이형식은 왜 안되는지 찾아보기
//                for (int x = 0; test.length < 3; x++) {
//                        String testInut = Console.readLine();
//                        test.
//                }
                }
        }
        public static int CheckValueInput(String value, int defVal){
                try{
                        return Integer.parseInt(value);
                }catch (IllegalArgumentException e){
                        return defVal;
                }
        }
}

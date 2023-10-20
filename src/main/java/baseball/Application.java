package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int n = 3;
        int[] computer = new int[n];

        while (true){
            System.out.println("숫자 야구 게임을 시작합니다.");

            // computer 배열에 랜덤 1~9까지 랜덤 숫자 삽입 (중복 X)
            for (int i = 0; i < n; i++){
                computer[i] = Randoms.pickNumberInRange(1, 9);
            }
            System.out.print("컴퓨터 랜덤 숫자 3자리: ");
            for (int i : computer){
                System.out.print(i);
            }
            System.out.print("\n");

            ArrayList<Integer> integerArrList = new ArrayList<>();

            while (true) {
                int strikes = 0; // 스트라이크 개수
                int balls = 0; // 볼 개수
                char numCheck;
                System.out.print("숫자를 입력해주세요 : ");
                String inputStrNo = Console.readLine(); // 사용자 입력 3자리 숫자 (중복 X)
                if (inputStrNo.isEmpty()){
                    throw new IllegalArgumentException("입력값이 없습니다.");
                }
                for (int i = 0; i < inputStrNo.length(); i++){
                    numCheck = inputStrNo.charAt(i); // 문자열에서 문자 뽑아내기 (문자 / 숫자 구분하는 함수)
                    if (numCheck < 48 || numCheck > 58){
                        throw new IllegalArgumentException("숫자만 입력해주세요");
                    }
                }
                String[] inputStrNoArr = inputStrNo.split(""); // 숫자 문자열 분리
                if (inputStrNoArr.length != 3){
                    throw new IllegalArgumentException("3자리 숫자를 입력하세요");
                }
                for (int i = 0; i < n; i++){
                    integerArrList.add(Integer.valueOf(inputStrNoArr[i]));
                }
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++) {
                        if (integerArrList.get(i) == computer[i]) {
                            strikes++;
                            break;
                        }
                        if (integerArrList.get(i) == computer[j]) {
                            balls++;
                            break;
                        }
                    }
                }
                if (strikes == 3){
                    System.out.printf("%d 스트라이크\n", strikes);
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strikes == 0 && balls == 0){
                    System.out.println("낫싱");
                } else if (balls == 0){
                    System.out.printf("%d스트라이크\n", strikes);
                } else if (strikes == 0){
                    System.out.printf("%d볼\n", balls);
                } else {
                    System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            String restart = Console.readLine();
            if (restart.equals("2")){
                break;
            }
        }
//        List<Integer> computer = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            computer.add(Randoms.pickNumberInRange(1, 9));
//        }
    }
}

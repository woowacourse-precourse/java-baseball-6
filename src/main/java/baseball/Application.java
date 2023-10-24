package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 필요한 변수 선언
        int[] computerNumbers = new int[3];
        int [] result;
        String gameOver = "1";

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(!gameOver.equals("2")){
            // 무작위 세 자리 숫자 생성
            for(int i = 0; i < 3; i++){
                computerNumbers[i] = Randoms.pickNumberInRange(1, 9);
            }

            do{
                int[] userNumbers = getUserNumbers();
                result = compareNumbers(computerNumbers, userNumbers);

                // 스트라이크, 볼 판별
                if(result[0] == 0 && result[1] == 0){
                    System.out.println("낫싱");
                }else if(result[0] != 0 && result[1] == 0){
                    System.out.println(result[0] + "스트라이크");
                }else if(result[1] != 0 && result[0] == 0){
                    System.out.println(result[1] + "볼");
                }else{
                    System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
                }
            }while(result[0] != 3);

            if(result[0] == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameOver = Console.readLine();
            }
        }
    }

    // 숫자 입력받기
    public static int[] getUserNumbers(){
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if(input.length() != 3){
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        int[] result = new int[3];
        for(int i = 0; i < 3; i++){
            result[i] = Character.getNumericValue(input.charAt(i));
        }
        return result;
    }

    // 정답과 입력값 비교하기
    public static int[] compareNumbers(int[] computerNumbers, int[] userNumbers){
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < 3; i++){
            if(computerNumbers[i] == userNumbers[i]){
                strike++;
            }else if(contains(computerNumbers, userNumbers[i])){
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    // 볼 구할 때 사용하는 포함값 구하기
    public static boolean contains(int[] arr, int target){
        for(int i : arr){
            if(i == target){
                return true;
            }
        }
        return false;
    }
}

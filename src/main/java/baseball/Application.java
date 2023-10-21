package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> comArrayList = new ArrayList<>();
        List<Integer> humanArrayList = new ArrayList<>();
        getComNumber(comArrayList);
        System.out.println("숫자 야구 게임을 시작합니다.");
//        for (int number : comArrayList) {
//            System.out.print(number);
//        }
        int answerStatus = 1;
        while (answerStatus == 1) {
            int ball = 0;
            int strike = 0;
            System.out.print("숫자를 입력해주세요 : ");
            String humanInput = Console.readLine();
            //String으로 받았기 때문에 각각의 인덱스들을 int값으로 변리
            char[] digits = humanInput.toCharArray();
            for (char digitChar : digits) {
                int digit = Character.getNumericValue(digitChar);
                humanArrayList.add(digit);
            }
            //==을 쓸수도 있지만 equals함수를 사용
            for (int i = 0; i < 3; i++) {
                if (Objects.equals(comArrayList.get(i), humanArrayList.get(i))) {
                    strike++;
                } else if (comArrayList.contains(humanArrayList.get(i))) {
                    ball++;
                }
            }
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                //원래있던 comArrayList를 없애주고 다시 getComNumber를 실행시켜서 깊은 복사로 적용
                List<Integer> restart = new ArrayList<>();
                getComNumber(restart);
                comArrayList.clear();
                for (int i = 0; i < 3; i++){
                    comArrayList.add(restart.get(i));
                }
                answerStatus = Integer.parseInt(Console.readLine());
            } else {
                if (strike == 0){
                    System.out.println(ball + "볼");
                }
                else if(ball == 0){
                    System.out.println(strike + "스트라이크");
                }
                else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }
            humanArrayList.clear();
        }
    }
    //컴퓨터 랜덤넘버 생성 함수
    private static void getComNumber(List<Integer> comArrayList){
        while (comArrayList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comArrayList.contains(randomNumber)) {
                comArrayList.add(randomNumber);
            }
        }
    }
}
package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }//컴퓨터 숫자 생성 while문
            while (true) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                System.out.print("숫자를 입력해주세요 : ");
                String num = String.valueOf(Console.readLine());

                List<Integer> me = new ArrayList<>();
                for (int i = 0; i < num.length(); i++) {
                    char currentCharacter = num.charAt(i);
                    me.add(Character.getNumericValue(currentCharacter));
                }
                List<Integer> result = baseball(computer, me);
                //스트라이크,볼,낫싱 판별//
                if(result.get(0).equals(0) && result.get(1).equals(0)){
                    System.out.println("낫싱");
                }
                else{
                    if(result.get(0).equals(0)){
                        System.out.println(result.get(1)+"볼");
                    } else if (result.get(1).equals(0)) {
                        if(result.get(0).equals(3)){
                            System.out.println("3스트라이크");
                        }else {
                            System.out.println(result.get(0)+"스트라이크");
                        }

                    }else {
                        System.out.println(result.get(1)+"볼 "+result.get(0)+"스트라이크");
                    }
                }
            }//사용자 입력 while문
        }//전체 게임 while문


    }//메인함수

    public static List<Integer> baseball(List<Integer> com, List<Integer> me) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0,0));
        int strike= 0;
        int ball =0;
        for (int i = 0; i < 3; i++) {
            if (com.get(i).equals(me.get(i))) {
                strike += 1;
                result.set(0, strike);
            } else if (me.contains(com.get(i))) {
                ball += 1;
                result.set(1, ball);
            }
        }
        return result;
    }//baseball 메소드
}

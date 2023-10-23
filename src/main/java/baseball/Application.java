package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean game = true;
        while (game) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }//컴퓨터 숫자 생성 while문
            while (game) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                System.out.print("숫자를 입력해주세요 : ");
                String num  = Console.readLine();
                //IllegalArgumentException
                if (num.length()!=3){
                    throw  new IllegalArgumentException("세자리 수를 입력하세요");
                }
                List<Integer> me = new ArrayList<>();
                for (int i = 0; i < num.length(); i++) {
                    char currentCharacter = num.charAt(i);
                    me.add(Character.getNumericValue(currentCharacter));
                }
                List<Integer> result = baseball(computer, me);
                //스트라이크,볼,낫싱 판별//
                if (result.get(0).equals(0) && result.get(1).equals(0)) {
                    System.out.println("낫싱");
                } else {
                    if (result.get(0).equals(0)) {
                        System.out.println(result.get(1) + "볼");
                    } else if (result.get(1).equals(0)) {
                        if (result.get(0).equals(3)) {
                            System.out.println("3스트라이크\n" +
                                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                            int data = Integer.parseInt(Console.readLine());
                            if (data == 2) {
                                game = false;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println(result.get(0) + "스트라이크");
                        }

                    } else {
                        System.out.println(result.get(1) + "볼 " + result.get(0) + "스트라이크");
                    }
                }
            }//사용자 입력 while문
        }//전체 게임 while문


    }//메인함수

    public static List<Integer> baseball(List<Integer> com, List<Integer> me) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0));
        int strike = 0;
        int ball = 0;
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

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {

    static final int CNT_SIZE = 3;
    static final int OUT_CNT = 3;
    static List<Integer> mixNum(List<Integer> computer) {       //컴퓨터로부터 랜덤숫자
        while (computer.size() < CNT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int play = 1;                               //초기 1
        List<Integer> computer = new ArrayList<>(); //컴퓨터가 뽑은 숫자
        mixNum(computer);                           //숫자 랜덤 뽑기

        int strike = 0;
        int ball = 0;

        do{
            int N = Integer.parseInt(Console.readLine());   //플레이어가 숫자 입력

            List<Integer> input = new ArrayList<>();        //플레이어가 입력하는 숫자 리스트
            HashSet<Integer> check = new HashSet<>();       //중복 체크를 위한 HashSet

            int first = N/100;                              //플레이어가 입력한 숫자의 100의 자리
            int second = (N%100)/ 10;                       //플레이어가 입력한 숫자의 10의 자리
            int third = N%10;                               //플레이어가 입력한 숫자의 1의 자리

            check.add(first);                               //HashSet에 숫자 하나씩 추가
            check.add(second);
            check.add(third);

            if((check.size() != CNT_SIZE) || String.valueOf(N).length() != CNT_SIZE)    //플레이어가 입력한 문자 길이가 3이 아니거나, HashSet 크기가 3이 아닐때
                throw new IllegalArgumentException();

            input.add(first);
            input.add(second);
            input.add(third);

            for (int i = 0; i < 3; i++) {                           //컴퓨터가 뽑은 숫자와 플레이어가 입력한 숫자 비교
                if (!computer.contains(input.get(i))) continue;     //플레이어가 입력한 숫자가 컴퓨터가 뽑은 숫자 리스트에 포함 되어 있지 않을 때
                if (computer.get(i) == input.get(i))                //같은 자리에 숫자가 있을 때
                    strike++;
                else ball++;                                        //포함만 되어 잇을 때
            }

            if (strike == 0 && ball == 0) {                         //스트라이크, 볼 카운터가 0일 때
                System.out.println("낫싱");
            } else if (strike == OUT_CNT) {                         //스트라이크 카운트가 3일 때
                System.out.println("3스트라이크 \n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                play = Integer.parseInt(Console.readLine());
                if(play == 1) {                                     //게임이 끝난 후 1 입력시
                    strike = 0;                                     //스트라이크 초기화
                    computer = new ArrayList<>();                   //컴퓨터가 뽑은 숫자 배열 초기화
                    mixNum(computer);                               //숫자를 다시 뽑음
                }else break;
            } else if (strike > 0 && ball > 0) {                    //스트라이크 카운트와 볼 카운트 둘다 0보다 클 때
                System.out.println(ball + "볼 " + strike + "스트라이크");
                strike = 0;
                ball = 0;
            } else if (strike == 0) {                               //스트라이크 카운트가 0일 때
                System.out.println(ball + "볼");
                ball = 0;
            } else {                                                //볼 카운트가 0 일때
                System.out.println(strike + "스트라이크");
                strike = 0;
            }
        }while (play == 1);
    }
}


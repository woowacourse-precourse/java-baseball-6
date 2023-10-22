package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        String input;
        String output;
        int ball, strike;
        int i, j;
        int n;

        System.out.println("숫자 야구 게임을 시작합니다.");

        //1. 랜덤한 3개의 수 생성 하기
        while(computer.size() < 3){
            n = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(n))
                computer.add(n);
        }
        //System.out.println("컴퓨터 숫자 확인용: " + computer);

        //2. 사용자 값 입력 받기
        while(!computer.equals(user)) {
            user.clear();

            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            for(i = 0; i < 3; i++) {
                user.add((Integer) (input.charAt(i) - '0'));
            }

            //3. 볼의 개수, 스트라이크 개수 출력 하기
            output = "";
            ball = 0;
            strike = 0;
            for(i = 0; i < 3; i++){
                if(computer.contains(user.get(i))) {
                    if(computer.get(i).equals(user.get(i)))
                        strike++;
                    else
                        ball++;
                }
            }
            if (ball == 0 && strike == 0)
                output += "낫싱";
            else {
                if (ball >= 1)
                    output += ball + "볼";
                if (ball >= 1 && strike >= 1)
                    output += " ";
                if (strike >= 1)
                    output += strike + "스트라이크";

                if (strike == 3)
                    output += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            }
            //System.out.println("볼/스트라이크 확인용: " + ball + " / " + strike);
            System.out.println(output);
        }
    }
}

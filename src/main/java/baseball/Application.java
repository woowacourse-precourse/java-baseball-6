package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restart = "1";

        while(restart.equals("1")) {
            // TODO: 랜덤 숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            // TODO: 사용자 입력 받기
            List<Integer> userNum;
            while(true){
                int strike = 0, ball = 0;
                userNum = new ArrayList<>();
                System.out.print("숫자를 입력해주세요 : ");
                String[] input = Console.readLine().split("");
                // 사용자 입력 예외처리
                if(!isValid(input)) {
                    throw new IllegalArgumentException("서로 다른 3글자를 입력하세요");
                }
                for(String s: input){
                    userNum.add(Integer.parseInt(s));
                }
                //컴퓨터와 사용자 입력 비교
                for(int i = 0;i < 3;i++){
                    if(Objects.equals(computer.get(i),userNum.get(i))){
                        strike++;
                        continue;
                    }
                    if(computer.contains(userNum.get(i))){
                        ball++;
                    }
                }
                //결과 출력
                checkResult(strike,ball);
                if(strike == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    restart = Console.readLine();
                    break;
                }

            }
        }
    }

    private static boolean isValid(String[] input){
        String tmp = "";
        if(input.length < 3 || input.length > 3){
            return false;
        }
        for(String s: input){
            if(!tmp.contains(s)){
                tmp += s;
            }
        }
        if(tmp.length() != 3){
            return false;
        }
        return true;
    }

    private static void checkResult(int strike, int ball){
        StringBuilder answer = new StringBuilder();
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }
        if(ball != 0) {
            answer.append(ball).append("볼 ");
        }
        if(strike != 0){
            answer.append(strike).append("스트라이크");
        }
        System.out.println(answer.toString().trim());
    }


}

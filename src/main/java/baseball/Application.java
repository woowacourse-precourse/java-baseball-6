package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 문제 출제
        System.out.println("숫자 야구 게임을 시작합니다");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 문제 풀기
        System.out.print("숫자를 입력해주세요 : ");
        String answer= Console.readLine();

        // 입력값에 대한 예외 처리 필요

        // 힌트 출력
        List<Integer> user = new ArrayList<>();
        for(int i=0;i<3;i++){
            user.add(Integer.parseInt(Character.toString(answer.charAt(i))));
        }
        int strike=0;
        int ball=0;
        for(int i=0;i<3;i++){
            if(Objects.equals(user.get(i), computer.get(i))){
                strike+=1;
            }
            else if(computer.contains(user.get(i))) {
                ball += 1;
            }
        }

        if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        if(strike==0 && ball!=0){
            System.out.println(strike+"스트라이크");
        }
        else if(strike!=0 && ball==0){
            System.out.println(ball+"볼");
        }
        else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }



    }
}

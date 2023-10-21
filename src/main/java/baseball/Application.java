package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = new ArrayList<>();
        while(answer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
        }


    }
}

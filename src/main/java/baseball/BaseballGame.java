package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validator.Validator;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int strike, ball;
    Validator validator = new Validator();

    // 1. 게임 시작
    public void sayStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    // 2. computer input 받기
    public List<Integer> getRandomThreeNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    // 3. 유저로부터 3자리 수 받기
    public List<Integer> getThreeNum() throws IllegalArgumentException{
        List<Integer> user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validator.isRightSize(input);
        for (int i=0; i<3; i++) {
            char charValue = input.charAt(i);
            String stringValue = String.valueOf(charValue);
            Integer intValue = validator.changeToInteger(stringValue);;

            validator.isRightRange(intValue);
            validator.isContain(user, intValue);
            user.add(intValue);
        }
        return user;
    }
    // 4-1. strike, ball 판별
    public void calculateBallStrike(List<Integer>user, List<Integer>computer){
        strike = 0;
        ball = 0;
        for (int i=0; i<user.size(); i++) {
            for (int j=0; j< computer.size(); j++) {
                if (user.get(i).equals(computer.get(j))) {
                    if (i == j) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }
                }
            }
        }
    }
    // 4-2. strike, ball 출력
    public void sayBallStrike(int ball, int strike){
        // else 사용 X
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        } else if (ball != 0 && strike == 0){
            System.out.printf("%d볼", ball);
        } else if (ball == 0 && strike != 0) {
            System.out.printf("%d스트라이크", strike);
        } else if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        System.out.println();
    }
    // 5-1. 게임 종료 (3스트라이크 시)
    public void sayEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    // 5-2. 게임 재시작 할 지 정하기
    public Boolean determineRestart() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } // 입력값이 1, 2가 아닐 때
        throw new IllegalArgumentException();
    }
}

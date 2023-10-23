package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int strike = 0;
        int ball =0;
        System.out.println("숫자 야구 게임을 시작합니다.");

        //컴퓨터 함수 부분
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        //입력 부문
        String user = Console.readLine();
        System.out.println(user);
        check(user); // 예외처리


    }

    //예외 처리
    public static void check(String user) throws IllegalArgumentException{
        boolean isNumeric = true;
        for(int i = 0; i < user.length(); i++) {
            if (!Character.isDigit(user.charAt(i))) {
                isNumeric = false;
            }
        }
        if(user.length() != 3 || !isNumeric){
            throw new IllegalArgumentException("3자리 정수를 입력해주세요");
        }
    }
}


package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
//        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = camp.nextstep.edu.missionutils.Console.readLine();
            if(userInput.length() != 3) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }
            for(int i = 0; i < userInput.length(); i++) {
                if(!check(userInput.charAt(i))) {
                    throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
                }
            }
            List<Integer> userInputList = new ArrayList<>();
            for(int i = 0; i < userInput.length(); i++) {
                if(userInputList.contains(userInput.charAt(i) - '0')) {
                    throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
                }
                userInputList.add(userInput.charAt(i) - '0');
            }
            System.out.println(userInputList);
        }
//        숫자를 입력해주세요 : 123
//        1볼 1스트라이크
//        숫자를 입력해주세요 : 145
//        1볼
//        숫자를 입력해주세요 : 671
//        2볼
//        숫자를 입력해주세요 : 216
//        1스트라이크
//        숫자를 입력해주세요 : 713
//        3스트라이크
//        3개의 숫자를 모두 맞히셨습니다! 게임 종료
//        게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
//        1
//        숫자를 입력해주세요 : 123
//        1볼


    public static boolean check(char c) {
        if(c >= '1' && c <= '9') {
            return true;
        }
        return false;
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static boolean computerPower, gamePower;
    public static void main(String[] args) {

        // [대기 화면]
        computerPower = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(computerPower){
            List<Integer> randomAnswer = generateRandomAnswer();

            // [게임 시작]
            boolean gamePower = true;
            while(gamePower){
                // 사용자 입력값 대기...
                Set<Integer> userGuessSet = readUserGuess();
//                formatCheck(userGuessSet) ? compareAnswer(randomAnswer, userGuessSet) : turnOff();

                if(userGuessSet.size() != 3){
                    computerPower = false;
                    gamePower = false;
                    throw new IllegalArgumentException("잘못된 형식의 입력입니다. 프로그램을 종료합니다.");
                }

            }
        }

    }

    public static boolean formatCheck(Set<Integer> set){
        return set.size()==3 ? true : false;
    }

    public static Set<Integer> readUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String userGuessStr = Console.readLine();
        // 형식 확인
        // 1. 입력이 3자리 수 인가
        // 2. 3자리중 중복이 없는가
        // set<int>에다 저장하고 size가 3인가 확인.
        Set<Integer> userGuessSet = new LinkedHashSet<>();
        userGuessSet.add(userGuessStr.charAt(0)-'0');
        userGuessSet.add(userGuessStr.charAt(1)-'0');
        userGuessSet.add(userGuessStr.charAt(2)-'0');
        return userGuessSet;
    }

    public static List<Integer> generateRandomAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

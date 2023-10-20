package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static final int allowableLength = 3;
    private static final boolean playingGame = true;
    public static String creatNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : computer) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
    public static boolean isAllDigit(String str){
        // 모두 숫자인지 확인
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isValidLength(String str){
        return str.length() == allowableLength;
    }
    public static boolean isValidNumber(String str) {
        // 1~9로 이루어졌는지 확인
        if(!str.matches("^[1-9]{3}$")){
            return false;
        }
        // 중복된 숫자 있는지 확인
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static int countBallAndStrike(String computeNumber, String userNumber){
        int cntBS = 0;

        char[] computeNumberArray = computeNumber.toCharArray();
        char[] userNumberArray = userNumber.toCharArray();

        Set<Character> computeNumberHS = new HashSet<>();
        Set<Character> userNumberHS = new HashSet<>();

        for (char c : computeNumberArray) {
            computeNumberHS.add(c);
        }
        for (char u : userNumberArray) {
            userNumberHS.add(u);
        }

//        for(char c : computeNumberHS){
//            if(userNumberHS.contains(c))
//                cntBS++;
//        }
        // 교집합 생성
        computeNumberHS.retainAll(userNumberHS);
        return computeNumberHS.size();
    }

    public  static  int countStrike(String computeNumber, String userNumber){
        int cntS = 0;
        for(int i=0; i < allowableLength; i++){
            if(computeNumber.charAt(i) == userNumber.charAt(i)){
                cntS++;
            }
        }
        return cntS;
    }

    public static String hintProvider(int cntB, int cntS){
        if(cntB == 0 && cntS == 0){
            return "낫싱";
        }
        if(cntB == 0){
            return "%d스트라이크".formatted(cntS);
        }
        if(cntS == 0){
            return  "%d볼".formatted(cntB);
        }
        return "%d볼 %d스트라이크".formatted(cntB, cntS);
    }
    public static void main(String[] args){
        // Randoms.pickNumberInRange(시작, 끝) - 시작 이상, 끝 이하
        // int computeNumber = Randoms.pickNumberInRange(111, 999) -> "게임종료_후_재시작" 에러 발생
        String computeNumber = creatNumber();
        System.out.println(computeNumber);
        System.out.println("숫자 야구 게임을 시작합니다.");
        // Console.readLine()은 String을 입력으로 받음.
        while(playingGame) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumber = Console.readLine();
//            System.out.print(userNumber);

            if(!isAllDigit(userNumber) || !isValidLength(userNumber) || !isValidNumber(userNumber)){
                throw new IllegalArgumentException();
            }

            int cntBS = countBallAndStrike(computeNumber, userNumber);
            int cntS = countStrike(computeNumber, userNumber);
            int cntB = cntBS - cntS;

            System.out.printf("cntB %d cntS %d".formatted(cntBS, cntS));
            System.out.println();
            if (cntS == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String reGame = Console.readLine();
                System.out.println(reGame);
                if (reGame.equals("2")) {
//                    playingGame = false; -> "예외_테스트" 에러
                    break;
                }
                else {
                    computeNumber = creatNumber();
                    System.out.println(computeNumber);
                }
            }
            else {
                System.out.print("힌트: ");
                System.out.println(hintProvider(cntB, cntS));
            }
        }
        System.out.println("게임이 종료되었습니다.");
    }
}

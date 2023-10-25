package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static List<Integer> createComputerNumber(){
        List<Integer> computerNumber = new ArrayList<>();
            while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static List<Integer> getUserNumber(){
        List<Integer> userNumber = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String getUserNumber = Console.readLine();
        boolean[] duplicationNumber = new boolean[10];

        for (char c: getUserNumber.toCharArray()) {
            int number = Character.getNumericValue(c);

            if (duplicationNumber[number]) {
                throw new IllegalArgumentException("중복된 숫자입니다.");
            }else if (number == 0) {
                throw new IllegalArgumentException("잘못된 숫자입니다.");
            }

            userNumber.add(number);
            duplicationNumber[number] = true;
        }

        if(userNumber.size() != 3){
            throw new IllegalArgumentException("잘못된 범위의 숫자입니다.");
        }

        return userNumber;
    }

    public static boolean checkAnswerNumber(List<Integer> computerNumber, List<Integer> userNumber){
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerNumber.get(i) == userNumber.get(j) && i == j) {
                    strikeCount++;
                }else if (computerNumber.get(i) == userNumber.get(j) && i != j) {
                    ballCount++;
                }
            }
        }

        switch (strikeCount) {
            case 3:
                System.out.println(strikeCount + "스트라이크");
                return true;
            case 0:
                if (ballCount == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(ballCount + "볼");
                }
                return false;
            default:
                if (ballCount == 0) {
                    System.out.println(ballCount + "스트라이크");
                } else {
                    System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                }
                return false;
        }
    }

    public static void playBaseballGame(){
        String playGame = "1";
        
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumber = createComputerNumber();
        while ("1".equals(playGame)) {
        	System.out.println(computerNumber);
        	List<Integer> userNumber = getUserNumber();

            if (checkAnswerNumber(computerNumber, userNumber)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                playGame = Console.readLine();
                if (!("1".equals(playGame) || "2".equals(playGame))) {
                	throw new IllegalArgumentException("잘못된 숫자입니다.");
                } else if (("1").equals(playGame)) {
                    computerNumber = createComputerNumber();
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playBaseballGame();
    }

}

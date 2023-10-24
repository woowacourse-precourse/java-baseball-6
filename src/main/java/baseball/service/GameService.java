package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameService {
    private final Scanner scanner = new Scanner(System.in);
    private List<Integer> computer;

    public void playGame() {

    }

    List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();
        List<Integer> userNumber = new ArrayList<>();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) < '1' || userInput.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            userNumber.add(userInput.charAt(i) - '0');
        }
        return userNumber;
    }

    boolean isUserNumberCorrect(List<Integer> userNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(userNumber.get(i))) {
                strike++;
            } else if (computer.contains(userNumber.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if(ball == 0 && strike == 0){
            System.out.print("낫싱");
        }
        if(ball > 0){
            System.out.print(ball + "볼 ");
        }
        if(strike > 0){
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
        return false;
    }

    public boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = scanner.nextLine();

        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")){
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

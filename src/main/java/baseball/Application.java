package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final int DIGIT_COUNT = 3;
    private Scanner scanner;

    public List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> convertInputToNumbers(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        if (input.length() > DIGIT_COUNT || input.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (input.length() == 3){
            for (char ch : input.toCharArray()) {
                int number = Character.getNumericValue(ch);
                if (number < 1 || number > 9) {
                    throw new IllegalArgumentException();
                }
                userNumbers.add(number);
            }
        }
        else{
            int zeroNum = DIGIT_COUNT - input.length();
            for (int i=0; i < zeroNum; i++){
                userNumbers.add(0);
            }
            for (char ch : input.toCharArray()) {
                int number = Character.getNumericValue(ch);
                if (number < 1 || number > 9) {
                    throw new IllegalArgumentException();
                }
                userNumbers.add(number);
            }
        }


        return userNumbers;
    }

    public void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumbers = generateRandomNumbers();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scanner.nextLine();
            List<Integer> userNumbers = convertInputToNumbers(userInput);

            int strikes = 0;
            int balls = 0;

            // compare userNumber
            for (int i = 0; i < DIGIT_COUNT; i++) {
                if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                    strikes++;
                } else if (computerNumbers.contains(userNumbers.get(i))) {
                    balls++;
                }
            }

            if (strikes > 0 || balls > 0){
                if (strikes == 3){
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int checkRestart = Integer.parseInt(scanner.nextLine());
                    if (checkRestart == 1) {
                        computerNumbers = generateRandomNumbers();
                    }
                    else{
                        break;     // end game
                    }
                }else {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
                }

            }
            else{
                    System.out.println("낫싱");
            }

        }
    }

    public static void main(String[] args) {
        Application game = new Application();
        game.playGame();
        game.scanner.close(); // 프로그램 종료 시 scanner를 닫아줍니다.
    }
}

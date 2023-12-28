package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Application {



    public static void main(String[] args) {
        // TODO: 프로그램 구현

        startGame();


    }

    private static void startGame() {

        do {
            playGame();
        } while (isRestart());
    }

    private static void playGame() {
        List<Integer> computerNumber = generateNumbers();
        System.out.println("숫자야구 게임을 시작합니다");
        boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println("숫자를 입력해주세요");
            int[] userInput = getUserInput();
            List<String> result = calResult(userInput, computerNumber);


            for (String res : result) {
                System.out.println(res);
            }

            if (result.contains("3스트라이크")) {
                gameFinished = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 그 외의 숫자를 입력하세요.");

            }
        }
    }

     static List<Integer> generateNumbers() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    //스트라이크, 볼, 낫싱 계산
    static List<String> calResult(int[] inputNumber, List<Integer> computerNumber) {

        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(inputNumber[i])) {
                strikes++;
            } else if (computerNumber.contains(inputNumber[i])) {
                balls++;
            }
        }

        List<String> results = new ArrayList<>();
        if (strikes > 0) {
            results.add(strikes + "스트라이크");
        }
        if (balls > 0) {
            results.add(balls + "볼");
        }
        if (strikes == 0 && balls == 0) {
            results.add("낫싱");
        }

        return results;

    }

    private static Scanner scanner = new Scanner(System.in);
    private static int[] getUserInput() throws IllegalArgumentException{

        String input = scanner.nextLine();
        isDuplicate(input);
        isNumber(input);
        isThree(input);

        //입력문자열을 숫자 배열로 저장
        int[] numbers = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }
        return numbers;
    }

    //입력예외1: 입력 숫자 중복 체크
    static void isDuplicate(String input) {
        HashSet<String> uniqueValue = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            uniqueValue.add(String.valueOf(input.charAt(i)));
        }
        if (uniqueValue.size() != 3) throw new IllegalArgumentException(" 중복된 값은 입력이 불가능합니다.");
    }

    //입력예외2: 숫자인지 체크
    static void isNumber(String input) {
        if (!input.matches("\\d+")) throw new IllegalArgumentException(" 숫자가 아닌 값은 입력이 불가능합니다.");
    }

    //입력예외3: 숫자가 3개인지
    static void isThree(String input) {
        if (!(input.length() == 3)) throw new IllegalArgumentException(" 3개의 숫자를 입력해주세요");
    }


    //종료입력
    private static boolean isRestart(){
        String input = scanner.nextLine();
        return Integer.parseInt((input)) == 1;
    }

}

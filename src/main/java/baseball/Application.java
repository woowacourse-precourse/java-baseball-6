package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    private static final int GAME_NUMBER_COUNT = 3;
    private static List<Integer> computerNumber;
    private static int ballCount;
    private static int strikeCount;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continueGame;
        do{
            generateRandomNumbers();
            strikeCount = 0;

            while (strikeCount<GAME_NUMBER_COUNT){
                System.out.println("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                if (!isValidInput(userInput)) {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                    continue;
                }

                List<Integer> userNumbers = Arrays.stream(userInput.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                compareNumbers(userNumbers);
                printResult(ballCount, strikeCount);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            continueGame = askForRestart();

        } while (continueGame);

        System.out.println("게임을 종료합니다. 감사합니다.");
    }


        public static List<Integer> generateRandomNumbers() {
            computerNumber = new ArrayList<>();
            while (computerNumber.size() < GAME_NUMBER_COUNT) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }
            return computerNumber;
        }

        public static void compareNumbers(List<Integer> userInput){
            ballCount = 0;
            strikeCount = 0;

            for(int i=0; i<GAME_NUMBER_COUNT; i++){
                if(userInput.get(i).equals(computerNumber.get(i))){
                    strikeCount++;
                } else if (computerNumber.contains(userInput.get(i))) {
                    ballCount++;
                }
            }
        }

        public static boolean isValidInput(String input) {
            if (input.length() != GAME_NUMBER_COUNT) {
                throw new IllegalArgumentException(GAME_NUMBER_COUNT + "자리의 자연수를 입력하세요.");
            }

            Set<Character> uniqueChars = new HashSet<>();
            for(char ch:input.toCharArray()){
                if(ch<'1'||ch>'9'||!uniqueChars.add(ch)){
                    throw new IllegalArgumentException("1부터 9까지의 자연수가 중복이 없도록 입력하세요.");
                }
            }
            return true;
        }

        public static void printResult(int ball, int strike){
            if (strike == 0 && ball == 0){
                System.out.println("낫싱");
                return;
            }
            if (strike == 3) {
                System.out.println("3스트라이크");
                return;
            }
            if (ball > 0 && strike > 0) {
                System.out.printf("%d볼 %d스트라이크", ball, strike);
            } else if (ball > 0) {
                System.out.printf("%d 볼", ball);
            } else if (strike > 0) {
                System.out.printf("%d 스트라이크", strike);
            }
            System.out.println();
        }

        public static boolean askForRestart() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            while (true) {
                String userInput = Console.readLine();
                if("1".equals(userInput)) {
                    return true;
                } else if ("2".equals(userInput)) {
                    return false;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            }
        }

    }


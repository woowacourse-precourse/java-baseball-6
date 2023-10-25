package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static class NumberBaseballGame {
        List<Integer> computerNumbers = new ArrayList<>();

        public NumberBaseballGame() {
            generateComputerNumbers();
        }

        private void generateComputerNumbers() {
            while (computerNumbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (computerNumbers.contains((randomNumber))) {
                    continue;
                } else {
                    computerNumbers.add(randomNumber);
                }
            }
        }

        private boolean contains(int[] array, int number) {
            for (int value : array) {
                if (value == number) {
                    return true;
                }
            }
            return false;
        }

        public void playGame() {
            System.out.print("숫자야구게임을 시작합니다.\n");
            while (true) {
                System.out.print("숫자를 입력하세요 : ");
                String input = Console.readLine();
                List<Integer> playerNum = new ArrayList<>();
                for (String number : input.split("")) {
                    playerNum.add(Integer.parseInt(number));
                }
                if (!isValidGuess(playerNum)) {
                    throw new IllegalArgumentException("입력값이 올바르지 않습니다. 1부터 9까지 서로 다른 3자리의 수를 입력해주세요.");
                }


                int[] countCorrects = calculateResult(computerNumbers, playerNum);
                //System.out.println(Arrays.toString(countCorrects));

                if (countCorrects[1] == 3) {
                    System.out.println("축하합니다! 정답을 맞췄습니다.");
                    System.out.print("게임을 계속하려면 1, 종료하려면 2를 입력하세요: ");
                    String choiceInput = Console.readLine();
                    int choice = Integer.parseInt(choiceInput);
                    if (choice == 2) {
                        System.out.println("게임을 종료합니다.");
                        break;
                    } else if (choice != 1) {
                        throw new IllegalArgumentException("올바른 선택을 입력하세요 (1 또는 2).");
                    } else{
                        playGame();
                    }
                    break;
                }
            }
        }

        private boolean isValidGuess(List<Integer> playerNum) {
            // player가 입력한 값을 담은 list의 길이가 3보다 작거나 3보다 큰 경우처리
            if (playerNum.size() < 3 || playerNum.size() > 4) {
                return false;
            }
            // player가 입력한 값을 담은 list의 요소 값 중 동일한 값이 존재하는 경우처리
            if (playerNum.get(0) == playerNum.get(1) || playerNum.get(1) == playerNum.get(2) || playerNum.get(0) == playerNum.get(2)) {
                return false;
            }
            return true;
        }

        public int[] calculateResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
            int correct = 0;
            System.out.println(computerNumbers);
            for(int i = 0; i < playerNumbers.size(); i++){
                if(computerNumbers.contains(playerNumbers.get(i))){
                    correct += 1;
                }
            }
            int[] result = new int[2]; // [볼, 스트라이크]

            int strike = 0;

            for (int i = 0; i < playerNumbers.size(); i++) {
                if (computerNumbers.get(i) == playerNumbers.get(i)) {
                    strike += 1; // 스트라이크
                }
            result[1] = strike;
            result[0] = correct-strike;
            }

            if(correct == 0){ // 숫자가 하나도 맞지 않는 경우
                System.out.println("낫싱");
            } else if(result[1] == 0){ // 스트라이크가 0이고 볼만 있는 경우
                System.out.println(result[0]+"볼");
            } else if(result[0] == 0){ // 볼이 0이고 스트라이크만 있는 경우
                System.out.println(result[1]+"스트라이크");
            } else {
                System.out.println(result[0]+"볼 "+result[1]+"스트라이크");
            }
            return result;
        }

    }
        public static void main(String[] args) {
            NumberBaseballGame game = new NumberBaseballGame();
            game.playGame();
        }
    }
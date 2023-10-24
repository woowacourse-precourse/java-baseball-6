package baseball;
        import camp.nextstep.edu.missionutils.Console;
        import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");

        while (true) {
            int[] number = new int[3];
            while (getUniqueCount(number) < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!containsNumber(number, randomNumber)) {
                    addNumber(number, randomNumber);
                }
            }

            while (true) {
                int ballCounter = 0;
                int strikeCounter = 0;

                System.out.println("숫자를 입력해주세요");
                int playerInput = Integer.parseInt(Console.readLine());

                if (playerInput < 100 || playerInput > 999 || String.valueOf(playerInput).contains("0")) {
                    throw new IllegalArgumentException("IllegalArgumentException");
                }

                int[] playerGuess = new int[3];
                for (int i = 0; i < 3; i++) {
                    playerGuess[i] = Integer.parseInt(String.valueOf(playerInput).substring(i, i + 1));
                }

                for (int i = 0; i < 3; i++) {
                    if (containsNumber(number, playerGuess[i])) {
                        if (playerGuess[i] == number[i]) {
                            strikeCounter++;
                        } else {
                            ballCounter++;
                        }
                    }
                }

                if (ballCounter + strikeCounter == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(ballCounter + "볼 " + strikeCounter + "스트라이크");
                }

                if (strikeCounter == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = Integer.parseInt(Console.readLine());
            if (restart == 1) {
                continue;
            } else if (restart == 2) {
                break;
            } else {
                throw new IllegalArgumentException("IllegalArgumentException");
            }
        }
    }

    private static boolean containsNumber(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    private static void addNumber(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = number;
                break;
            }
        }
    }

    private static int getUniqueCount(int[] array) {
        int count = 0;
        for (int value : array) {
            if (value != 0) {
                count++;
            }
        }
        return count;
    }
}


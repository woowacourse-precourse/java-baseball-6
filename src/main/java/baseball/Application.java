package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

                System.out.println("숫자 야구 게임을 시작합니다.");

                while (true) {
                    int answer = generateRandomNumber();

                    while (true) {
                        System.out.print("숫자를 입력하세요 : ");
                        String input = Console.readLine();

                        if (input.equals("2")) {
                            return;
                        } else if (input.equals("1")) {
                            break;
                        } else if (input.length() != 3 || !input.matches("\\d{3}")) {
                            System.out.println("세 자리 숫자를 입력하세요.");
                            continue;
                        }

                        try {
                            int guess = Integer.parseInt(input);
                            int strikes = calculateStrikes(guess, answer);
                            int balls = calculateBalls(guess, answer);

                            if (strikes == 3) {
                                System.out.println("3 스트라이크!\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                                        "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                                break;
                            } else if (strikes > 0 || balls > 0) {
                                System.out.println(strikes + " 스트라이크, " + balls + " 볼");
                            } else {
                                System.out.println("낫싱");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("잘못된 입력입니다. 세 자리 숫자를 입력하세요.");
                        }
                    }
                }
            }

            private static int generateRandomNumber() {
                int number = Randoms.pickNumberInRange(100, 999);
                while (containsZero(number)) {
                    number = Randoms.pickNumberInRange(100, 999);
                }
                return number;
            }

            private static boolean containsZero(int number) {
                return String.valueOf(number).contains("0");
            }

            private static int calculateStrikes(int guess, int answer) {
                int strikes = 0;
                for (int i = 0; i < 3; i++) {
                    if (getDigit(guess, i) == getDigit(answer, i)) {
                        strikes++;
                    }
                }
                return strikes;
            }

            private static int calculateBalls(int guess, int answer) {
                int balls = 0;
                for (int i = 0; i < 3; i++) {
                    int guessDigit = getDigit(guess, i);
                    for (int j = 0; j < 3; j++) {
                        if (guessDigit == getDigit(answer, j) && i != j) {
                            balls++;
                        }
                    }
                }
                return balls;
            }

            private static int getDigit(int number, int position) {
                return Integer.parseInt(String.valueOf(number).substring(position, position + 1));
            }
        }

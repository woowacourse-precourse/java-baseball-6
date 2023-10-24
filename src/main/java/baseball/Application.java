package baseball;

import java.util.List;
public class Application {

        private static final int MIN_NUMBER = 1;
        private static final int MAX_NUMBER = 9;
        private static final int NUMBER_COUNT = 3;

        private List<Integer> computerNumbers;
        private List<Integer> playerNumbers;

        public static void main(String[] args) {
            // TODO: 프로그램 구현
            Application app = new Application();
            app.startGame();
        }

        // 메인 로직
        public void startGame() {
            boolean isGameContinue = true;

            while (isGameContinue) {
                this.computerNumbers = generateRandomNumbers();
                boolean isMatch = false;

                while (!isMatch) {
                    this.playerNumbers = getPlayerNumbers();
                    isMatch = checkMatch();
                    printResult();
                }

                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isGameContinue = isRestartGame();
            }
        }

        // 상대방(컴퓨터) : 1부터 9까지 중복되지 않는 세개의 랜덤 숫자 생성
        private List<Integer> generateRandomNumbers() {
            return null;
        }

        // 플레이어 : 사용자로부터 입력받은 문자열이 세 자리, 중복되지 않고, 범위 내에 있는지 확인 / 예외 발생 시  Console.readLine()
        private List<Integer> getPlayerNumbers() {
            return null;
        }

        // 입력받은 문자열이 유효한 값 인지 확인하는 메서드 / 예외 발생 시 IllegalArgumentException
        private void validate(String input) {

        }


        // 플레이어 : 사용자가 입력한 숫자와 일치하는지 확인
        private boolean checkMatch() {
            return computerNumbers.equals(playerNumbers);
        }
                // 스트라이크, 볼의 개수 계산한 결과 출력 메서드
                private void printResult() {

                }

        // 재시작 or 종료할지 결정하는 메서드 / 예외 발생 시 Console.readLine()
        private boolean isRestartGame() {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return false;
            }
        }



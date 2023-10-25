package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;

public class Application {
    static final int NUMBER_SIZE = 3;
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            while(true) {
                // 3자리 숫자 만들기
                ArrayList<Integer> answer = new ArrayList<>();
                while(answer.size() < NUMBER_SIZE) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!answer.contains(randomNumber)) {
                        answer.add(randomNumber);
                    }
                }

                while(true) {
                    System.out.print("숫자를 입력해주세요 : ");
                    // 사용자가 입력한 숫자를 정답과 비교하여 출력하기
                    int input = Integer.parseInt(Console.readLine());

                    // 입력 유효성 검사 (100 ~ 999 사이)
                    if (input >= Math.pow(10, NUMBER_SIZE) || input < Math.pow(10, NUMBER_SIZE - 1)) {
                        throw new IllegalArgumentException();
                    }

                    // 입력 배열 생성 및 입력 유효성 검사 (서로 다른 세 자리의 수)
                    ArrayList<Integer> question = new ArrayList<>();
                    for (int i = NUMBER_SIZE - 1; i >= 0; i--) {
                        int divider = (int)(Math.pow(10, i));
                        int number = input / divider % 10;
                        if (question.contains(number)) {
                            throw new IllegalArgumentException();
                        }
                        question.add(number);
                    }

                    int strike = 0;
                    int ball = 0;
                    for (int i = 0; i < NUMBER_SIZE; i++) {
                        int target = question.get(i);
                        if (answer.contains(target)) {
                            if (answer.indexOf(target) == i) {
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }

                    // 입력에 대한 비교 결과 출력
                    StringBuilder sb = new StringBuilder();
                    if (ball > 0) {
                        sb.append(ball).append("볼 ");
                    }
                    if (strike > 0) {
                        sb.append(strike).append("스트라이크");
                    }
                    if (ball == 0 && strike == 0) {
                        sb.append("낫싱");
                    }
                    System.out.println(sb);

                    if(strike == NUMBER_SIZE) {
                        // 모든 숫자를 맞춰 게임이 종료됨
                        System.out.println(NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        int process = Integer.parseInt(Console.readLine());
                        if (process == 1) {
                            break;
                        } else if (process == 2){
                            return;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }
}

package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean newGame = true;
        while (newGame) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            //랜덤한 정답 생성
            List<Integer> answer = randomAnswerMaker();

            boolean correctAnswer = false;
            while (!correctAnswer) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                //입력값 잘못되었을때 에러 발생후 종료
                if (Integer.parseInt(input) < 100 || Integer.parseInt(input) > 999) {
                    throw new IllegalArgumentException();
                }
                List<Integer> inputList = inputToList(input);
                if (inputList.size() != 3) {
                    throw new IllegalArgumentException();
                }

                //한글자씩 뜯어서 자리 맞는지 비교, 볼 스트라이크 세고 반환
                HashMap<String, Integer> checkedResult = inputChecker(answer, inputList);
                correctAnswer = resultPrinter(checkedResult);
            }
            //게임 종료 후 다시 시작하거나 종료하기
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int again = Integer.parseInt(Console.readLine());
            if (again == 2) {
                newGame = false;
            }
            if (again !=1 && again != 2) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<Integer> inputToList(String input) {
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            int inputNumber = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (!inputList.contains(inputNumber) &&
                    1 <= inputNumber && inputNumber <= 9) {
                inputList.add(inputNumber);
            }
        }
        return inputList;
    }

    private static List<Integer> randomAnswerMaker() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static HashMap<String, Integer> inputChecker(List<Integer> answer, List<Integer> input) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i <= 2; i++) {
            int number = input.get(i);
            //answer에 있는 number의 인덱스가 i와 같으면 스트라이크에 +1, -1이 아니면 볼에 +1
            if (answer.indexOf(number) == i) {
                strike++;
            } else if (answer.contains(number)) {
                ball++;
            }
        }
        HashMap<String, Integer> result = new HashMap<>();
        result.put("볼", ball);
        result.put("스트라이크", strike);
        return result;
    }

    private static boolean resultPrinter(HashMap<String, Integer> result) {
        //스트라이크와 볼 개수에 따라서 출력
        int strike = result.get("스트라이크");
        int ball = result.get("볼");

        StringBuilder stringBuilder = new StringBuilder();
        if (ball != 0) {
            stringBuilder.append(ball).append("볼");
        }
        if (strike != 0) {
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(strike).append("스트라이크");
        }
        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫싱");
        }
        System.out.println(stringBuilder);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }
}




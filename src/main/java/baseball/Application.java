package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        int continueGame = 1;

        int cnt = 0;
        List<Integer> computer = new ArrayList<>();

        int winOrLose = 0;

        while (continueGame == 1) {

            if (cnt == 0) {
                generateRandomValue(computer); // 컴퓨터 랜덤값 생성
            }

            List<Integer> user;

            try {
                user = inputValue();
            } catch (IllegalArgumentException e) {
                System.out.println("게임 종료" + e);
                break;
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("3글자가 아닙니다.");
            }

            System.out.print(user.get(0));
            System.out.print(user.get(1));
            System.out.println(user.get(2));

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                if (computer.get(i).equals(user.get(i))) {
                    strike++;
                } else if (computer.contains(user.get(i))) {
                    ball++;
                }
            }

            String result = "";


            if (ball > 0) {
                result += ball + "볼 ";
            }
            if (strike > 0) {
                result += strike + "스트라이크 ";
            }
            if (strike == 0 && ball == 0) {
                result += "낫싱";
            }
            if (strike == 3) {
                result += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
                winOrLose = 1;
            }

            System.out.println(result);

            if (winOrLose == 1) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                continueGame = Integer.parseInt(Console.readLine());
                if (continueGame == 1) {
                    cnt = 0;
                    winOrLose = 0;
                    computer.clear();
                }
                if (continueGame == 2) {
                    continueGame = 0;
                }
            }
        }
    }

    public static void generateRandomValue(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomValue)) {
                computer.add(randomValue);
            }
        }
    }

    public static List<Integer> inputValue() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String inputVal = Console.readLine();

        if (inputVal.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        if (inputVal.length() != 3) {
            throw new NoSuchElementException("3자리 숫자를 입력해주세요.");
        }

        List<Integer> user;
        user = Stream.of(inputVal.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        try {
            Integer.parseInt(inputVal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
        if (user.get(0).equals(user.get(1)) || user.get(0).equals(user.get(2)) || user.get(1).equals(user.get(2))) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }


        return user;
    }
}
package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            startBaseballShell();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        Console.close();
    }

    private Application() {
    }

    private static List<Integer> computer;
    private static List<Integer> user;

    public static void startBaseballShell() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        setComputer();
        while (true) {
            String answer = getInput("숫자를 입력해주세요 : ", "\\d\\d\\d");
            setUser(answer);
        }
    }

    private static void setComputer() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private static void setUser(String string) {
        user = Arrays.stream(string.split(""))
                .mapToInt(Integer::valueOf)
                .boxed()
                .toList();
    }

    public static String getInput(String message, String regex) {
        System.out.print(message);
        String userInput = Console.readLine();
        isMatches(userInput, regex);
        return userInput;
    }

    public static boolean isMatches(String string, String regex) {
        if (string.matches(regex)) {
            return true;
        }
        throw new IllegalArgumentException(string + " 은(는) 형식에 맞지 않습니다.");
    }


}
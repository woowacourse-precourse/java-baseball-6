package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
           //상대방(컴퓨터)가 1부터 9까지 서로 다른 수 3개를 뽑음
            List<Integer> computer = ComputerRandom.comInput();

            boolean checkResult = true;
            while (checkResult) {
                int strikeCount = 0;
                int ballCount = 0;

                System.out.print("숫자를 입력해주세요 : ");
                String user = Console.readLine();

                //사용자가 잘못 입력했는지 체크
                ExcepCheck.excepCheck(user);

                ArrayList<Integer> userInput = new ArrayList<>(3);
                for (int i = 0; i < 3; i++) {
                    userInput.add(Integer.parseInt(user.substring(i, i + 1)));
                    if (userInput.get(i) == 0) { //사용자가 0을 입력하면 에러 발생
                        throw new IllegalArgumentException();
                    }
                }


                for (int i = 0; i < 3; i++) {
                    if (computer.get(i).equals(userInput.get(i))) {
                        strikeCount += 1;
                    } else if (userInput.contains(computer.get(i))) {
                        ballCount += 1;
                    }
                }

                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    checkResult = false;
                } else {
                    System.out.println(resultMessage(strikeCount, ballCount));
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String replay = Console.readLine();
            if (replay.equals("1")) {
                continue;
            } else if (replay.equals("2")) {
                break;
            } else { //1, 2가 아닌 수가 나오면 에러 발생
                throw new IllegalArgumentException();
            }
        }
    }

    private static String resultMessage(int strikeCount, int ballCount) {
        String resultMessage = "";

        if (strikeCount > 0) {
            resultMessage += strikeCount + "스트라이크";
        }

        if (ballCount > 0) {
            if (strikeCount > 0) {
                resultMessage += " ";
            }
            resultMessage += ballCount + "볼";
        }

        if (resultMessage.isEmpty()) {
            resultMessage = "낫싱";
        }
        return resultMessage;
    }
}


class ComputerRandom{
    public static List<Integer> comInput(){
        //상대방(컴퓨터)가 1부터 9까지 서로 다른 수 3개를 뽑음
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

class ExcepCheck{
    public static void excepCheck(String user) {
        // 3자리 수가 아니면 에러 발생
        if (user.length() != 3) {
            throw new IllegalArgumentException();
        }
        //중복될 경우 에러 발생
        if (user.substring(0, 1).equals(user.substring(1, 2)) || user.substring(0, 1).equals(user.substring(2, 3))
                || user.substring(1, 2).equals(user.substring(2, 3))) {
            throw new IllegalArgumentException();
        }
    }
}
package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    //컴퓨터의 3자리수 생성
    public static ArrayList<Integer> createComputerNumber() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 플레이어의 수 입력
    public static ArrayList<Integer> createPlayerNumber() {
        ArrayList<Integer> player = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String inputNum = Console.readLine();
            String[] inputNums = inputNum.split("");
            if (inputNums[0].equals(inputNums[1])
                    || inputNums[1].equals(inputNums[2])
                    || inputNums[0].equals(inputNums[2])) {
                throw new IllegalArgumentException();
            } else if (inputNum.length() != 3) {
                throw new IllegalArgumentException();
            } else if (inputNum.contains("0")) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < 3; i++) {
                player.add(Integer.parseInt(inputNum.split("")[i]));
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return player;
    }

    //스트라이크,볼,낫싱 판별하기
    public static boolean isStrikeBall(ArrayList<Integer> computer, ArrayList<Integer> player) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
                ball--;
            }
        }

        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < player.size(); j++) {
                if (computer.get(i).equals(player.get(j))) {
                    ball++;
                }
            }
        }

        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball <= 0 && strike <= 0) {
            System.out.println("낫싱");
        } else if (ball <= 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike <= 0) {
            System.out.println(ball + "볼");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    //재시작 여부 묻기
    public static boolean isRestart() {
        String restart = "";
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            restart = Console.readLine();
            if (!(restart.equals("1") || restart.equals("2"))) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (restart.equals("1")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IllegalAccessException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        ArrayList<Integer> computer = createComputerNumber();
        while (true) {
            ArrayList<Integer> player = createPlayerNumber();
            if (isStrikeBall(computer, player)) {
                if (isRestart()) {
                    computer = createComputerNumber();
                    continue;
                }
                break;
            }
        }
    }
}
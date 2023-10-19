package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();
            if (restart.equals("2")) {
                break;
            }
        }
    }

    public static void playGame() {
        ArrayList<Integer> computerPickList = initComputerPickList();
        System.out.println("숫자 야구 게임을 시작합니다.");
        int strike = 0;
        while (true) {
            ArrayList<Integer> playerPackList = initPlayerPickList();
            strike = referee(computerPickList, playerPackList);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static ArrayList<Integer> initComputerPickList() {
        ArrayList<Integer> computerPickList = new ArrayList<>();

        while (computerPickList.size() < 3) {
            int computerRandonPick = Randoms.pickNumberInRange(1, 9);
            if (!computerPickList.contains(computerRandonPick)) {
                computerPickList.add(computerRandonPick);
            }
        }

        return computerPickList;
    }

    public static ArrayList<Integer> initPlayerPickList() { // 아마 여기 메서드에서 예외처리가 되야 할듯함
        System.out.print("숫자를 입력해주세요 : ");
        String playerPick = Console.readLine();
        ArrayList<Integer> playerPickList = new ArrayList<>();

        if (playerPick.length() > 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < playerPick.length(); i++) {
            playerPickList.add(Integer.parseInt(String.valueOf(playerPick.charAt(i))));
        }

        return playerPickList;
    }

    public static int referee(ArrayList<Integer> computerPickList, ArrayList<Integer> playerPickList) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerPickList.size(); i++) { //심판 판정
            if (Objects.equals(computerPickList.get(i), playerPickList.get(i))) {
                strike++;
            } else if (computerPickList.contains(playerPickList.get(i))) {
                ball++;
            }
        }

        if (strike > 0 && ball > 0) { //볼과 스트라이크 갯수에 따라서 call
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else{
            System.out.println("낫싱");
        }
        return strike;
    }

}

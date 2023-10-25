package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> computer; //컴퓨터의 숫자
    public static List<Integer> player; //플레이어의 숫자
    public static boolean CONTINUE_GAME = true; //재시작, 종료 구분하는 변수
    public static boolean SUCCESS; //게임 종료 여부 확인하는 변수

    public static void main(String[] args) {

        gameStart(); //게임 시작 문구 출력

        while (CONTINUE_GAME) {
            game();
        }
    }

    private static void game() {

        SUCCESS = false;
        setComputerNum(); //컴퓨터의 숫자 세팅

        //숫자 3개를 다 맞힐 때까지 반복
        while (!SUCCESS) {
            setPlayerNum(); //플레이어의 숫자 세팅

            //플레이어와 컴퓨터의 숫자 비교 로직

        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); //숫자 3개 다 맞혔다면 게임 종료
        checkRestart(); //재시작, 종료 여부 확인
    }

    //플레이어의 숫자 세팅하는 함수
    private static void setPlayerNum() throws IllegalArgumentException {
        player = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        char[] player_chArr = Console.readLine().toCharArray();
        for (char c : player_chArr) {
            int num = c - '0';
            //서로 다른 수가 아닌 경우
            if (player.contains(num)) {
                throw new IllegalArgumentException();
            } else {
                player.add(num);
            }
        }
        //숫자 3개가 아닌 경우
        if (player.size() != 3) throw new IllegalArgumentException();
        //숫자가 아닌 경우
        for (int i = 0; i < 3; i++) {
            if (!(1 <= player.get(i) && player.get(i) <= 9)) {
                throw new IllegalArgumentException();
            }
        }
    }

    //컴퓨터의 숫자 세팅하는 함수
    private static void setComputerNum() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}


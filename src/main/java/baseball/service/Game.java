package baseball.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.service.handler.Computer;
import baseball.service.handler.Hint;
import baseball.service.handler.Player;


public class Game {

    public static final int NUMBER_OF_DIGITS = 3;       //자리수
    private static final int START_RANGE = 1;        //랜덤 시작 범위
    private static final int END_RANGE = 9;          //랜덤 끝 범위

    //게임 재시작/종료 flag
    private static final String NEW_GAME_FLAG = "1";
    private static final String EXIT_GAME_FLAG = "2";

    //게임 메시지
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = NUMBER_OF_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE =
            "게임을 새로 시작하려면 " + NEW_GAME_FLAG + ", 종료하려면 " + EXIT_GAME_FLAG + "를 입력하세요.";

    /**
     * Initialization Computer Data
     *
     * @return Initialization Computer
     */
    private Computer initComputer() {
        return new Computer(START_RANGE, END_RANGE, NUMBER_OF_DIGITS);
    }

    /**
     * Initialization Game Data
     * <p>
     * When start game, show game Message
     * </p>
     */
    public void initGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    /**
     * run game
     */
    public void runGame() {
        Computer computer = initComputer(); //컴퓨터 최기화

        Hint hint = new Hint(); //hint 선언

        //strike가 NUMBER_OF_DIGITS와 같을 때까지 반복
        //답을 맞출 때까지 반복
        while (hint.getStrike() != NUMBER_OF_DIGITS) {
            hint.resetHint();   //hint reset

            System.out.print(GET_NUMBER_MESSAGE);   //숫자 입력시 메시지
            Player player = new Player();
            player.inputNumber();   //플레이어 입력받기

            //show hint
            hint.showHint(player.getPlayer_number(), computer.getComputerNumber());
        }

        System.out.println(SUCCESS_MESSAGE);    //성공 메시지 출력
        System.out.println(NEW_GAME_CHECK_MESSAGE); //재실행/종료 메시지 출력
        String restart_flag = readLine();   //재실행/종료 flag 입력

        //재실행이면 restart game
        if (isRestart(restart_flag)) {
            restartGame();
        }
    }


    /**
     * Restart game
     */
    private void restartGame() {
        runGame();
    }

    /**
     * 재실행 여부 확인
     *
     * @param restart_flag : 재실행/종료 flag
     * @return (true : 재실행, false : 종료)
     */
    private boolean isRestart(String restart_flag) {

        //재실행/종료 flag가 아닌 값일경우 IllegalArgumentException()
        if (!restart_flag.equals(EXIT_GAME_FLAG) && !restart_flag.equals(NEW_GAME_FLAG)) {
            throw new IllegalArgumentException();
        }

        return !restart_flag.equals(EXIT_GAME_FLAG);
    }


}

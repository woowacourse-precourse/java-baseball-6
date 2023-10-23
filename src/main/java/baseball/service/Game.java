package baseball.service;

import baseball.service.handler.Computer;


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


    private Computer initComputer() {
        //컴퓨터 랜덤 수 초기화
        return new Computer(START_RANGE, END_RANGE, NUMBER_OF_DIGITS);
    }

    public void compareNumbers(String computer_number, String player_number, int strikeCnt, int ballCnt) {
        int length = player_number.length();
        //입력한 수의 자리수 만큼 반복
        for (int i = 0; i < length; i++) {
            char player_i_num = player_number.charAt(i);  //i번쨰 자리수의 수
            if (computer_number.contains(String.valueOf(player_i_num))) {
                if (computer_number.charAt(i) == player_i_num) {
                    strikeCnt++;
                } else {
                    ballCnt++;
                }
            }
        }

        String resultout = "";
        if (ballCnt == 0 && strikeCnt == 0) {
            resultout = "낫싱";

        } else {
            if (ballCnt != 0) {
                resultout += ballCnt + "볼";
            }
            if (strikeCnt != 0) {
                if (!resultout.equals("")) {
                    resultout += " ";
                }
                resultout += strikeCnt + "스트라이크";
            }
        }

        System.out.println(resultout);

    }


}

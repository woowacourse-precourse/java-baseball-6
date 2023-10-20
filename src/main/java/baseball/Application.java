package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.System;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자야구 게임을 시작합니다.");
        final int BASEBALL_GAME_NUMBER_LENGTH = 3;
        final int BASEBALL_SUCCESS_STRIKE_COUNT = 3;
        final String STRIKE = "스트라이크";
        final String SPACE = " ";
        final String BALL = "볼";
        final String NOTHING = "낫싱";
        final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        final int START = 1;
        final int END = 2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString;

        while (true) {
            int game;
            int strikeCount = 0;
            int ballCount = 0;
            int usernum;
            List<Integer> user = new ArrayList<>();
            //숫자 랜덤 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);

                }
            }


            while (true) {

                System.out.print("숫자를 입력해주세요 : ");
                try {
                    inputString = Console.readLine();
                    for (char c : inputString.toCharArray()) {
                        // 각 문자를 정수로 변환하여 리스트에 추가
                        user.add(Character.getNumericValue(c));
                    }
                    if(user.size() != BASEBALL_GAME_NUMBER_LENGTH){
                        throw new IllegalArgumentException("Input must be an 3digit integer.");
                    }
                } finally {
                }
                for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
                    for (int j = 0; j < i; j++) {
                        if(user.get(j) == user.get(i)) {
                            //유저가 입력한 i인덱스에 들어갈 숫자가 중복된 숫자인지 확인
                            throw new IllegalArgumentException("Do not input duplicate numbers.");
                        }
                    }
                }
                for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
                    for (int j = 0; j < BASEBALL_GAME_NUMBER_LENGTH; j++) {
                        //numArr의 i번째 인덱스와 inputArr의 모든 원소들을 비교
                        if (computer.get(i) == user.get(j) && i == j) {
                            //같은 숫자가 있고 인덱스도 같으면 스트라이크
                            strikeCount++;
                        } else if (computer.get(i) == user.get(j) && i != j) {
                            //같은 숫자만 있으면 볼
                            ballCount++;
                        }
                    }
                }
                if (strikeCount != 0 || ballCount != 0) {
                    System.out.println(ballCount + BALL + SPACE + strikeCount + STRIKE);
                } else {
                    System.out.println(NOTHING);
                }

                if (strikeCount == BASEBALL_SUCCESS_STRIKE_COUNT) {
                    System.out.println(SUCCESS);
                    break;
                }
                user.clear();
                strikeCount = 0;
                ballCount = 0;
            }

            System.out.print(RESTART);

            try {
                inputString = Console.readLine();
                game = Integer.parseInt(inputString);
                if (game != START && game != END) {
                    throw new IllegalArgumentException("Input must be either '1' or '2'.");
                } else if (game == START) {
                    continue;
                } else if (game == END) {
                    break;
                }
            } finally {
            }
        }
    }
}



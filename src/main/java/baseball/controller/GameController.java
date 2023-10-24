package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.AppConstants;
import baseball.model.GameScoreDTO;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
    private static final int disitLimit = (int) AppConstants.NUM_DISIT_LIMIT.getVal();
    private boolean isGameOver = false;
    private List<Integer> computer;

    public void gameStart() {
        // todo view 컴포넌트 만들어야 함
        System.out.println(AppConstants.MSG_START_GAME.getVal());
        initializeNewGame();
        while (isContinueGame()) {
            System.out.println(AppConstants.MSG_INPUT_NUMBER.getVal());
            List<Integer> user = getUserInput();
            GameService baseballService = new GameService(computer, user);
            GameScoreDTO gameScoreDTO = baseballService.calculate();
            checkScore(gameScoreDTO);
        }
    }
    private boolean isContinueGame() {
        if (!isGameOver) {
            return true;
        }
        System.out.println(AppConstants.MSG_RESTART_GAME.getVal());
        String input = Console.readLine();
        String regex = (String) AppConstants.REGEX_CONINUE_VALUE.getVal();
        if (input.matches(regex)) {
            if ("1".equals(input)) {
                initializeNewGame();
                return true;
            }
        } else {
            throw new IllegalArgumentException((String) AppConstants.ERR_INVALID_RESTART_VALUE.getVal());
        }

        return false;
    }

    private void initializeNewGame() {
        computer = generateRandomNumbers();
        isGameOver = false;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        int begin = (int) AppConstants.NUM_BEGIN_RANGE.getVal();
        int end = (int) AppConstants.NUM_END_RANGE.getVal();
        while (computer.size() < disitLimit) {
            int randomNumber = Randoms.pickNumberInRange(begin, end);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private List<Integer> getUserInput() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            validateInput(input);

            return parseInput(input);
        } catch (Exception e) {
            throw new IllegalArgumentException((String) AppConstants.ERR_WRONG_INPUT.getVal());
        }
    }

    private void validateInput(String input) {
        String regex = (String) AppConstants.REGEX_VALID_INPUT.getVal();
        if (!input.matches(regex)) {
            throw new IllegalArgumentException((String) AppConstants.ERR_INVALID_NUMBER_INPUT.getVal());
        }
    }

    private List<Integer> parseInput(String input) {
        List<Integer> resultList = new ArrayList<>();
        String[] splitArray = input.split("");
        for (String string : splitArray) {
            int num = Integer.parseInt(string);
            resultList.add(num);
        }
        return resultList;
    }

    private void checkScore(GameScoreDTO gameScoreDTO) {
        int strike = gameScoreDTO.getStrike();
        int ball = gameScoreDTO.getBall();

        if (strike == 3) {
            // 3 스트라이크인 경우
            System.out.println(strike + (String) AppConstants.RESULT_GAME_STRIKE.getVal());
            setGameOver();
        } else if (strike > 0 && ball > 0) {
            // 볼과 스트라이크 모두 있는 경우
            System.out.println(ball + (String) AppConstants.RESULT_GAME_BALL.getVal() + " "+
                    strike + (String) AppConstants.RESULT_GAME_STRIKE.getVal());
        } else if (strike > 0) {
            // 스트라이크만 있는 경우
            System.out.println(strike + (String) AppConstants.RESULT_GAME_STRIKE.getVal());
        } else if (ball > 0) {
            // 볼만 있는 경우
            System.out.println(ball + (String) AppConstants.RESULT_GAME_BALL.getVal());
        } else {
            // 스트라이크와 볼이 없는 경우
            System.out.println((String) AppConstants.RESULT_GAME_FAIL_MSG.getVal());
        }
    }
    private void setGameOver () {
        isGameOver = true;
        System.out.println(AppConstants.MSG_END_GAME.getVal());
    }
}

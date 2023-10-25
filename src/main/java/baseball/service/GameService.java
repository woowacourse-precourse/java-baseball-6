package baseball.service;

import baseball.model.GameModel;
import baseball.model.UserModel;
import baseball.utils.Parse;
import baseball.utils.Random;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

        int size;
        GameModel gameModel;
        UserModel userModel = new UserModel();
        Parse parse = new Parse();
        OutputView outputView = new OutputView();

        public void setGame(int size, int start, int end) {
            this.size = size;
            gameModel = new GameModel(Random.getRandomNumbers(size, start, end));
        }

        public void playGame() {
            int strike = 0;
            while (strike != 3) {
                play();
                outputView.computeResult(gameModel.getBallCount(), gameModel.getStrikeCount());
                strike = gameModel.getStrikeCount();
            }
        }

        private void play() {
            gameModel.initBaseBall();
            userModel.setUserNumbers(getUserNumber());
            computeScore();
        }

        private int[] getUserNumber() throws IllegalArgumentException {
            InputView.inputData();
            String input = Console.readLine();
            return parse.parseUserInput(input, size);
        }

        private void computeScore() {
            for (int i = 0; i < size; i++) {
                compute(gameModel.getGameNumbers(), userModel.getUserNumbers(), i);
            }
        }

        private void compute(int[] gameNumber, int[] userNumber, int index) {
            int temp = -1;
            for (int i = 0; i < gameNumber.length; i++) {
                if (gameNumber[i] == userNumber[index]) {
                    temp = i;
                    break;
                }
            }
            incCount(index, temp);
        }

        private void incCount(int index, int temp) {
            if (temp != index && temp != -1) {
                gameModel.incBallCount();
            }
            if (temp == index) {
                gameModel.incStrikeCount();
            }
        }
    }

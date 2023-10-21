package baseball;

import baseball.compare.Compare;
import baseball.compare.CompareImpl;
import baseball.computer.RandomChoice;
import baseball.computer.RandomChoiceImpl;
import baseball.parsing.Parsing;
import baseball.parsing.ParsingImpl;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.start();
    }

}

package baseball.controller;

import baseball.PlayGame;
import baseball.menu.Resume;
import baseball.view.ViewInput;
import baseball.view.ViewOutput;

import java.io.IOException;
import java.util.stream.IntStream;

public class RunController {

    public static ViewOutput viewOutput = new ViewOutput();
    public static ViewInput viewInput = new ViewInput();
    public static PlayGame playGame = new PlayGame();

    public void run() throws IOException {
        viewOutput.startGame();
        playGame.play();

        int selectMenuNum;
        do {
            selectMenuNum = viewInput.continueOrEnd();

            if (selectMenuNum == 1) {
                int reSelectMenuNum = selectMenuNum;
                IntStream.rangeClosed(1, Resume.values().length)
                        .filter(m -> m == reSelectMenuNum)
                        .mapToObj(selected -> Resume.values()[selected - 1])
                        .findFirst()
                        .ifPresentOrElse(
                                resume -> {
                                    try {
                                        resume.execute();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                },
                                () -> System.out.println("없는 보기입니다. 다시 입력하세요.")
                        );
            } else if (selectMenuNum == 2) {
                Resume.END.execute();
            } else {
                System.out.println("올바른 번호를 입력하십시오.");
            }
        } while (selectMenuNum != 2);
    }
}

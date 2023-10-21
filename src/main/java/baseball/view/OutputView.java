package baseball.view;

import baseball.domain.BallStatus;
import baseball.domain.Referee;
import baseball.domain.Result;
import org.junit.platform.commons.support.HierarchyTraversalMode;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printResult(Map<BallStatus, Integer> ballStatusMap) {

        String result = ballStatusMap.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(BallStatus.NOTHING))
                .map(entry -> String.format("%s%s", entry.getValue(), entry.getKey().getName()))
                .collect(Collectors.joining(" "));
        System.out.println(result);


    }

    public static boolean isEnd(Map<BallStatus, Integer> ballStatusMap) {
        return (ballStatusMap.get(BallStatus.STRIKE) == 3);

        }
    }


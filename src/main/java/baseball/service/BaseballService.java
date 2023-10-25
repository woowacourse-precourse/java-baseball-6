package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballService {
    public BaseballNumbers makeBaseballNumbers() {
        List<Integer> randomNumbers = getRandomNumbers();
        return BaseballNumbers.from(randomNumbers.stream()
                .map(BaseballNumber::from)
                .collect(Collectors.toList()));
    }

    public BaseballNumbers inputBaseballNumbers() {
        return InputView.inputBaseballNumbers();
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> fullRandomNumbers = IntStream.rangeClosed(BaseballNumber.MIN_BASEBALL_NUMBER, BaseballNumber.MAX_BASEBALL_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(fullRandomNumbers);
        List<Integer> randomNumbers = fullRandomNumbers.subList(0, BaseballNumbers.BASEBALL_NUMBERS_COUNT);
        return randomNumbers;
    }

    public Map<String, Integer> matchBaseballNumbers(BaseballNumbers computerNumbers, BaseballNumbers userNumbers) {
        List<String> resultList = computerNumbers.matchNumbersIndex(userNumbers);
        return matchResult(resultList);
    }

    public Map<String, Integer> matchResult(List<String> resultList) {
        Map<String, Integer> resultInfo = new HashMap<String, Integer>();
        List<String> matchList = new ArrayList<>(new HashSet<String>(resultList));
        Collections.sort(matchList);

        for(String resultStr : matchList) {
            resultInfo.put(resultStr, Collections.frequency(resultList, resultStr));
        }
        return new TreeMap<>(resultInfo);
    }

    public int calculateMatchResult(Map<String, Integer> matchedResultInfo) {
        OutputView.outputMatch(matchedResultInfo);

        if(matchedResultInfo.containsKey("스트라이크") && matchedResultInfo.get("스트라이크") == 3) {
            OutputView.outputStrike();
            return restartGame();
        }
        return 0;
    }

    public int restartGame() {
        return InputView.restartGame();
    }
}
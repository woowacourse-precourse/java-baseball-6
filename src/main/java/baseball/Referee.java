package baseball;

import java.util.EnumMap;
import java.util.List;

public class Referee {
	public Result compare(Numbers answerNumbers, Numbers compareNumbers){
		Result result = new Result(new EnumMap<>(ResultKind.class));

		List<Number> balls = filterSame(answerNumbers, compareNumbers);

		for (Number number : balls) {
			int answerIndex = answerNumbers.getIndex(number);
			int compareIndex = compareNumbers.getIndex(number);

			if(answerIndex == compareIndex) {
				result.add(ResultKind.STRIKE);
			}
			if(answerIndex != compareIndex) {
				result.add(ResultKind.BALL);
			}
		}
		return result;
	}

	private List<Number> filterSame(Numbers answerNumbers, Numbers compareNumbers){
		return compareNumbers.getBalls()
				.stream()
				.filter(answerNumbers::isContain).toList();
	}
}


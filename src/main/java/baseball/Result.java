package baseball;

import java.util.Map;

public class Result {

	private static final int ZERO = 0;
	private final Map<ResultKind, Integer> result;

	public Result(Map<ResultKind, Integer> result) {
		this.result = result;
	}

	public void add(ResultKind resultKind) {
		result.put(resultKind, result.getOrDefault(resultKind, 0) + 1);
	}

	public Integer getCount(ResultKind kind) {
		return result.getOrDefault(kind, ZERO);
	}

	public boolean isNothing() {
		return isSize(ResultKind.BALL, ZERO) && isSize(ResultKind.STRIKE, ZERO);
	}

	public boolean isSize(ResultKind kind, Integer size) {
		return getCount(kind).equals(size);
	}
}

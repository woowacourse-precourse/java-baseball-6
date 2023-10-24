package baseball.utils.input;

import java.util.List;

public interface Selector {

	List<Long> selectNumbers();

	Long selectEndOption();

	Long getSelectNumbersSize();
}

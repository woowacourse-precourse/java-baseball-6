package baseball.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ComputerBaseballGameNumberRepository {
	private List<Integer> computerBaseballGameNumberList;

	public ComputerBaseballGameNumberRepository() {
	}

	public List<Integer> getComputerBaseballGameNumberList() {
		return computerBaseballGameNumberList;
	}

	// start: Builder 패턴
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private ComputerBaseballGameNumberRepository gameNumberRepository =
				new ComputerBaseballGameNumberRepository();

		public Builder getComputerBaseballGameNumberList(List<Integer> computerBaseballGameNumberList) {
			gameNumberRepository.computerBaseballGameNumberList = computerBaseballGameNumberList;
			return this;
		}

		public ComputerBaseballGameNumberRepository build() {
			return gameNumberRepository;
		}
	}
	// end: Builder 패턴


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ComputerBaseballGameNumberRepository that = (ComputerBaseballGameNumberRepository) o;
		return Objects.equals(computerBaseballGameNumberList, that.computerBaseballGameNumberList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(computerBaseballGameNumberList);
	}
}

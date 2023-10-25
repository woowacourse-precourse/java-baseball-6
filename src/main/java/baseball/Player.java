package baseball;

public class Player {
	private final Numbers numbers;

	public Player(Numbers numbers) {
		this.numbers = numbers;
    }

	public Player(NumbersGenerator generator) {
        this(generator.generateNumbers());
    }

	public Numbers read(){
		return numbers;
	}
}



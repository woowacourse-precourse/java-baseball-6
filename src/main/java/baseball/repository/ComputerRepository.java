package baseball.repository;

import baseball.domain.Computer;

public class ComputerRepository {
    
    private Computer computer;

    public void save(String computer) {
        this.computer = new Computer(computer);
    }
    
    public String getNumber() {
        return computer.getNumber();
    }
}

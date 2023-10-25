package service;

import model.Computer;

public class ComputerService {

    private static ComputerService instance = new ComputerService();
    private static Computer computer = Computer.getInstance();

    private ComputerService() { }

    public static ComputerService getInstance() {
        if (instance == null) {
            instance = new ComputerService();
        }
        return instance;
    }

    public void startGame() {
        computer.setRandomNumber();
    }
}

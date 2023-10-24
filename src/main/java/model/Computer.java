package model;

public class Computer {
    private StringBuilder selectComputers;

    public Computer(StringBuilder selectComputers) {
        try {
            this.selectComputers = selectComputers;
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Exception occur Computer Class: NullPointerException");
        }
    }

    public StringBuilder getterSelectComputerNum() {

        return new StringBuilder(selectComputers);
    }
}

package baseball;


import baseball.common.seeder.DataSourceSeeder;
import baseball.controller.ControllerResolver;

public class Application {
    private static final DataSourceSeeder dataSourceSeeder = new DataSourceSeeder();
    private static final ControllerResolver controllerResolver = new ControllerResolver();

    public static void main(String[] args) {
        dataSourceSeeder.seed();
        controllerResolver.run();
    }
}
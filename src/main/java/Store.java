import java.sql.SQLException;


public class Store {

    enum MenuStatus {
        MAIN_MENU,

    }
    static String url = "jdbc:sqlite:D:\\DimaStudy\\Databases\\cardealership";
    static DBConnectionManager connMgr;

    public static void main(String[] args) throws SQLException, InterruptedException {
        ConsoleUI.start(url);
        connMgr = new DBConnectionManager(url);

        MenuStatus st = MenuStatus.MAIN_MENU;
        while(true){
            int cmd = ConsoleUI.getCommand();

            switch (cmd){
                case 1:
                    showCars();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    removeCar();
                    break;
                case 4:
                    showClients();
                    break;
                case 5:
                case 0:
                    return;
            }
        }
    }

    private static void showCars() throws SQLException
    {
        connMgr.showTable("Car");
    }

    private static void addCar() {
        Car car = new Car();
        while (true) {
            String typeStr = ConsoleUI.getLineWith("type ('p' or 't')");

            if (typeStr.compareTo("p") == 0) {
                car.type = CarType.PASSCAR;
                break;
            } else if (typeStr.compareTo("t") == 0) {
                car.type = CarType.TRUCK;
                break;
            }
        }

        car.brand = ConsoleUI.getLineWith("brand");
        car.model = ConsoleUI.getLineWith("model");

        try {
            connMgr.insert("Car", car);
        } catch (SQLException e) {

        }
    }

    private static void removeCar(){}

    private static void showClients(){}
}

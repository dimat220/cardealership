import java.sql.ResultSet;
import java.sql.SQLException;


public class Store {

    static final String CAR_HEADER = "CarID | CarType | Brand | Model | Price";
    static final String CAR_ENTRY_TEMPLATE = "%d | %s | %s | %s | %d";
    static String url = "jdbc:sqlite:D:\\DimaStudy\\Databases\\cardealership";
    static DBConnectionManager connMgr;

    public static void main(String[] args) throws SQLException, InterruptedException {
        ConsoleUI.start(url);
        connMgr = new DBConnectionManager(url);

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
            ConsoleUI.getLineWith("Press 'Enter' to continue...");
        }
    }

    private static void showCars() throws SQLException
    {
        ResultSet res = connMgr.showTable("Car");
        int count = 0;
        ConsoleUI.printLine(CAR_HEADER);
        while (res.next()) {
            int carID = res.getInt("CarID");
            CarType carType = CarType.values()[res.getInt("CarType")];
            String brand = res.getString("Brand");
            String model = res.getString("Model");
            int price = res.getInt("Price");
            ConsoleUI.printLine(String.format(CAR_ENTRY_TEMPLATE, carID, carType.ordinal() == 0 ? 'p' : 't' , brand, model, price));
            count++;
        }
        ConsoleUI.printLine("Total " + count + " cars");
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

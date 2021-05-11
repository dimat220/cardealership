enum CarType{
    PASSCAR,
    TRUCK
}

public class Car implements DBStored {
    public static final String fields = "(CarType, Brand, Model)";

    public CarType type;
    String brand;
    String model;

    public Car(CarType type, String model, String brand) {
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

    public Car() {
    }

    public String getFields()
    {
        return fields;
    }

    public String getValues()
    {
        StringBuilder str = new StringBuilder("(");
        str.append(type.ordinal());
        str.append(", \"");
        str.append(brand);
        str.append("\", \"");
        str.append(model);
        str.append("\")");
        return str.toString();
    }
}

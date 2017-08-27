public class Tesla extends Car {

    public Tesla() {
        super("Tesla Model S", "graphite", 1);
    }

    @Override
    public String startEngine() {
        return "Starts engine of a Tesla Model 3";
    }

    @Override
    public String accelerate() {
        return "Tesla Model 3 accelerates soudlesly 4mph";
    }

    @Override
    public String brake() {
        return "Tesla Model 3 stops in place";
    }

}

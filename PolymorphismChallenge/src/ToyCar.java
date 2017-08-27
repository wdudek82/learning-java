public class ToyCar extends Car {

    public ToyCar() {
        super("A Toy Car", "red", 0);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " Toy car has no engine";
    }

    @Override
    public String accelerate() {
        return "You push a toy car and it's roll a bit faster!";
    }

    @Override
    public String brake() {
        return "Oops! A toy car has no brakes! It crashes into a wall!";
    }

}

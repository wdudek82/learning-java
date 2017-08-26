public class Room {

    private CeilingLamp ceilingLamp;
    private Window window;

    public Room(CeilingLamp ceilingLamp, Window window) {
        this.ceilingLamp = ceilingLamp;
        this.window = window;
    }

    public CeilingLamp getCeilingLamp() {
        return ceilingLamp;
    }

    public void setCeilingLamp(CeilingLamp ceilingLamp) {
        this.ceilingLamp = ceilingLamp;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public void useTheSwitch() {
        ceilingLamp.setIsOn(!ceilingLamp.getIsOn());
    }

    public void turnOnTheLamp() {
        if (ceilingLamp.getIsOn()) {
            System.out.println("The Lamp was already On!");
        } else {
            ceilingLamp.setIsOn(true);
        }
    }

    public void turnOffTheLamp() {
        if (!ceilingLamp.getIsOn()) {
            System.out.println("The Lamp was already Off!");
        } else {
            ceilingLamp.setIsOn(false);
        }
    }

}

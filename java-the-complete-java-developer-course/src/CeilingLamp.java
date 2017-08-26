public class CeilingLamp {

    private int numBulbs;
    private String color;
    private boolean isOn;

    public CeilingLamp(int numBulbs, String color, boolean isOn) {
        this.numBulbs = numBulbs;
        this.color = color;
        this.isOn = isOn;
    }

    public int getNumBulbs() {
        return numBulbs;
    }

    public void setNumBulbs(int numBulbs) {
        this.numBulbs = numBulbs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;

        String lampState = isOn ? "On" : "Off";
        System.out.println("The lamp is now " + lampState);
    }

    public void turnOn() {
        setIsOn(true);
    }

    public void turnOff() {
        setIsOn(false);
    }



}

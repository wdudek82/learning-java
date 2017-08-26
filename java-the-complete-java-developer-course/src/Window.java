public class Window {

    private int shuttersNum;
    private boolean isOpen;

    public Window(int shuttersNum, boolean isOpen) {
        this.shuttersNum = shuttersNum;
        this.isOpen = isOpen;
    }

    public int getShuttersNum() {
        return shuttersNum;
    }

    public void setShuttersNum(int shuttersNum) {
        this.shuttersNum = shuttersNum;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

}

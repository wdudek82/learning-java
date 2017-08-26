public class Printer {

    private int tonerLevel = 0;
    private boolean isDuplex;
    private int pagesPrinted = 0;

    public Printer(int tonerLevel, boolean isDuplex) {
        setTonerLevel(tonerLevel);
        this.isDuplex = isDuplex;
    }

    public int getTonerLevel() {
        System.out.println("Toner level is: " + tonerLevel + "%");
        return tonerLevel;
    }

    public void setTonerLevel(int tonerLevel) {
        int finalTonerLevel = this.tonerLevel + tonerLevel;

        if (finalTonerLevel > -1 && finalTonerLevel <= 100) {
            this.tonerLevel = finalTonerLevel;
        } else if (finalTonerLevel > 100) {
            System.out.println("Toner overflow!");
            this.tonerLevel = 100;
        }
    }

    public boolean getDuplex() {
        System.out.println("Is duplex: " + isDuplex);
        return isDuplex;
    }

    public void setDuplex(boolean isDuplex) {
        this.isDuplex = isDuplex;
    }

    public int getPagesPrinted() {
        System.out.println("Printer printed " + pagesPrinted + " page(s)");
        return pagesPrinted;
    }

    public void print(String content, int copies) {
        if (tonerLevel >= copies) {
            for (int i = 1; i <= copies; i++) {
                System.out.printf("===== PRINTING %d/%d ===== " + content + "\n", i, copies);
                pagesPrinted += 1;
                tonerLevel -= 1;
            }
        } else {
            System.out.printf("Insuficient toner level to print %d pages!\n", copies);
        }
    }

}

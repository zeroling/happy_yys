package Back;

public enum MessageType {
    // mouse
    WM_LBUTTONUP(514),
    WM_LBUTTONDOWN(513);

    private int value;
    MessageType(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    @Override
    public String toString() {
        return "" + this.value;
    }
}
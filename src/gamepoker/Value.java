package gamepoker;

public class Value {
    private String str;
    private int i;
    public Value(String str, int i) {
        this.str = str;
        this.i = i;
    }

    public String getName() {
        return str;
    }

    public int getValue() {
        return i;
    }

    public boolean Equals(Value value1, Value value2) {
        return (value1.getName() == value2.getName())&&(value1.getValue() == value2.getValue());
    }
}

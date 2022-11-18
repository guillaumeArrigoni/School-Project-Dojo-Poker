package gamepoker;

import gamepoker.exception.IncorrectColorException;
import gamepoker.exception.PokerException;

import java.util.Arrays;

public class Color {
    private String name;

    public static final Color Tr;
    public static final Color Pi;
    public static final Color Co;
    public static final Color Ca;

    static {
        try {
            Tr = new Color("Tr");
            Pi = new Color("Pi");
            Co = new Color("Co");
            Ca = new Color("Ca");
        } catch (PokerException e) {
            throw new RuntimeException(e);
        }
    }

    public Color(String name) throws PokerException {
        if (!validColorName(name)) {
            throw new IncorrectColorException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        // If the object is compared with itself then return true
        if (object == this) {
            return true;
        }
        // Check if object is an instance of Color or not
        if (!(object instanceof Color)) {
            return false;
        }
        // Typecast object to Color so that we can compare both data
        Color color2 = (Color) object;

        // Compare the data members and return accordingly
        return color2.name.equals(this.name);
    }

    /**
     * Check if the name past in parameter is valid
     *
     * @param name that must be validated
     * @return True if the name is valid or false if not
     */
    private boolean validColorName(String name) {
        return Arrays.asList("Tr", "Pi", "Co", "Ca").contains(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

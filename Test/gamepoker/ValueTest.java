package gamepoker;

import gamepoker.exception.IncorrectValueException;
import gamepoker.exception.PokerException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValueTest {

    private static Stream<Arguments> provideValueStringConstructor() throws PokerException {
        return Stream.of(
                Arguments.of(new Value("8"), "8", 8, Value.HUIT),
                Arguments.of(new Value("3"), "3", 3, Value.TROIS),
                Arguments.of(new Value("A"), "A", 14, Value.AS),
                Arguments.of(new Value("R"), "R", 13, Value.ROI),
                Arguments.of(new Value("2"), "2", 2, Value.DEUX)
        );
    }

    private static Stream<Arguments> provideValueIntConstructor() throws PokerException {
        return Stream.of(
                Arguments.of(new Value(8), "8", 8, Value.HUIT),
                Arguments.of(new Value(3), "3", 3, Value.TROIS),
                Arguments.of(new Value(14), "A", 14, Value.AS),
                Arguments.of(new Value(13), "R", 13, Value.ROI),
                Arguments.of(new Value(2), "2", 2, Value.DEUX)
        );
    }


    @ParameterizedTest
    @MethodSource({"provideValueStringConstructor", "provideValueIntConstructor"})
    void getPositionMethodTestParameterized(Value theValue, String theName, int thePosition) {
        assertEquals(thePosition, theValue.getPosition());
    }

    @ParameterizedTest
    @MethodSource({"provideValueStringConstructor", "provideValueIntConstructor"})
    void getNameMethodTestParameterized(Value theValue, String theName) {
        assertEquals(theName, theValue.getName());
    }

    @ParameterizedTest
    @MethodSource({"provideValueStringConstructor", "provideValueIntConstructor"})
    void toStringMethodTestParameterized(Value theValue, String theName) {
        assertEquals(theName, theValue.toString());
    }

    @ParameterizedTest
    @MethodSource({"provideValueStringConstructor", "provideValueIntConstructor"})
    void equalsMethodTestParameterized(Value theValue, String theName, int thePosition, Value correspondingValue) {
        assertEquals(correspondingValue, theValue);
        assertEquals(theValue, theValue);
        assertNotEquals(thePosition, theValue);
        assertNotEquals(theName, theValue);
        assertNotEquals(Value.DAME, theValue);
    }

    @Test
    void compareToMethodTest() {
        assertEquals(1, Value.AS.compareTo(Value.DEUX));
        assertEquals(0, Value.DEUX.compareTo(Value.DEUX));
        assertEquals(-1, Value.DEUX.compareTo(Value.AS));
    }

    @Test
    void assertExceptionWithIncorrectValueTest() {
        assertThrows(IncorrectValueException.class, () -> new Value("1"));
        assertThrows(IncorrectValueException.class, () -> new Value(""));
        assertThrows(IncorrectValueException.class, () -> new Value("As"));
        assertThrows(IncorrectValueException.class, () -> new Value(15));
        assertThrows(IncorrectValueException.class, () -> new Value(1));
        assertThrows(IncorrectValueException.class, () -> new Value(null));
    }
}

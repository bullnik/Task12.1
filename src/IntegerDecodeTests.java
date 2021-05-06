import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class IntegerDecodeTests {

    @Test
    public void shouldThrowNumFormatExOnZeroStringLength() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.decode("");
        });
    }

    @Test
    public void testPositiveNumbers() {
        Assertions.assertEquals(100, Integer.decode("+100"));
        Assertions.assertEquals(100, Integer.decode("100"));
    }

    @Test
    public void testNegativeNumbers() {
        Assertions.assertEquals(-100, Integer.decode("-100"));
    }

    @Test
    public void testHexadecimalRadix() {
        Assertions.assertEquals(100, Integer.decode("#64"));
        Assertions.assertEquals(100, Integer.decode("0x64"));
        Assertions.assertEquals(100, Integer.decode("0X64"));
    }

    @Test
    public void testOctalRadix() {
        Assertions.assertEquals(100, Integer.decode("0144"));
    }

    @Test
    public void testZero() {
        Assertions.assertEquals(0, Integer.decode("0"));
        Assertions.assertEquals(0, Integer.decode("+0"));
        Assertions.assertEquals(0, Integer.decode("-0"));
    }

    @Test
    public void shouldThrowNumFormatExOnWrongSighCharPos() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
           Integer.decode("1+00");
        });

        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.decode("100-");
        });
    }

    @Test
    public void shouldThrowExceptionOnNonNumberString() {
        Assertions.assertThrows(Exception.class, () -> {
            Integer.decode("fafjdslk;fjsda");
        });
    }

    @Test
    public void testMinValue() {
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode("-2147483648"));
    }

    @Test
    public void testMaxValue() {
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode("2147483647"));
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode("+2147483647"));
    }
}

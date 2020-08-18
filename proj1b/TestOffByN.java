import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static OffByN offBy3 = new OffByN(3);

    @Test
    public void TestequalChars() {

        assertTrue(offBy3.equalChars('a','d'));
        assertFalse(offBy3.equalChars('a','g'));

    }
}

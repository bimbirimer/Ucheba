import org.example.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    // ДОПОЛНИТЕЛЬНЫЕ тесты на граничные значения:

    @Test
    void shouldCalculateForRegisteredExactLimit() {
        BonusService service = new BonusService();
        long amount = 16_667; // 16_667 * 3 / 100 = 500,01, после округления вниз (long) = 500
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredExactLimit() {
        BonusService service = new BonusService();
        long amount = 50_000; // 50_000 * 1 / 100 = 500
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
}
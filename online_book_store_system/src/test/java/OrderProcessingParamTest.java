import com.example.OrderException;
import com.example.OrderProcessing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class OrderProcessingParamTest {
    OrderProcessing orderProc = new OrderProcessing();

    @BeforeEach
    void setUp() {
        orderProc.setStock("1234567890", 10); // Set stock for a specific ISBN
    }

    @ParameterizedTest
    @CsvSource({
            "1234567890, 1, true",
            "1234567890, 11, false",
            "9876543210, 1, false",
    })
    void testProcessOrder(String isbn, int quantity, boolean expectedOutcome) {
        if (expectedOutcome) {
            assertDoesNotThrow(() -> orderProc.processOrder(isbn, quantity));
        } else {
            assertThrows(OrderException.class, () -> orderProc.processOrder(isbn, quantity));
        }
    }
}

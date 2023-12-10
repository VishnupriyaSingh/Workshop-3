import com.example.OrderException;
import com.example.OrderProcessing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderProcessingTest {
    OrderProcessing orderProc = new OrderProcessing();

    @BeforeEach
    void setUp() {
        orderProc.setStock("1234567890", 10);
    }

    @Test
    void testProcessValidOrder() {
        assertDoesNotThrow(() -> orderProc.processOrder("1234567890", 1));
    }

    @Test
    void testProcessOrderForUnavailableBook() {
        assertThrows(OrderException.class, () -> orderProc.processOrder("9876543210", 1));
    }

    @Test
    void testProcessOrderWithInsufficientStock() {
        assertThrows(OrderException.class, () -> orderProc.processOrder("1234567890", 11));
    }
}

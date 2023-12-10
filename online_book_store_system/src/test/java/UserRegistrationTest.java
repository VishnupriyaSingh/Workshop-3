import com.example.RegistrationException;
import com.example.UserRegistration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
    UserRegistration userReg = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userReg.registerUser("alice123", "Password@123", "alice@example.com", "1234567890"));
    }

    @Test
    void testInvalidEmailRegistration() {
        assertThrows(RegistrationException.class, () -> userReg.registerUser("alice123", "Password@123", "alice.com", "1234567890"));
    }

    @Test
    void testDuplicateUserRegistration() {
        assertDoesNotThrow(() -> userReg.registerUser("bob123", "Password@123", "bob@example.com", "1234567890"));
        assertThrows(RegistrationException.class, () -> userReg.registerUser("bob123", "Password@123", "bob@example.com", "1234567890"));
    }
}
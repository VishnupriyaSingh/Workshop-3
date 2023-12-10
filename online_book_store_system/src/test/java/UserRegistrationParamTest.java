import com.example.RegistrationException;
import com.example.UserRegistration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationParamTest {
    UserRegistration userReg = new UserRegistration();

    @ParameterizedTest
    @CsvSource({
            "alice123, Password@123, alice@example.com, 1234567890, true",
            "bob, short, bob@example.com, 1234567890, false",
            "carol, Password@123, invalidemail, 1234567890, false",
    })
    void testUserRegistration(String username, String password, String email, String phone, boolean expectedOutcome) {
        if (expectedOutcome) {
            assertDoesNotThrow(() -> userReg.registerUser(username, password, email, phone));
        } else {
            assertThrows(RegistrationException.class, () -> userReg.registerUser(username, password, email, phone));
        }
    }
}

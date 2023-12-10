import static org.junit.jupiter.api.Assertions.*;

import com.example.StudentRegistration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StudentRegistrationParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "123, John Doe, johndoe@example.com, 1234567890, true",
            "124, , jane@example.com, 1234567890, false",
            "125, Jane Doe, invalid_email, 1234567890, false",
            "126, Jane Doe, jane@example.com, , false"
    })
    public void testRegisterStudent(String id, String name, String email, String phone, boolean expectedOutcome) {
        StudentRegistration registration = new StudentRegistration();
        boolean isValid = true;
        try {
            registration.registerStudent(id, name, email, phone);
        } catch (Exception e) {
            isValid = false;
        }
        assertEquals(expectedOutcome, isValid);
    }
}

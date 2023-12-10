import static org.junit.jupiter.api.Assertions.*;

import com.example.DuplicateRegistrationException;
import com.example.InvalidStudentDetailException;
import com.example.StudentRegistration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentRegistrationTest {

    private StudentRegistration registration;

    @BeforeEach
    public void setUp() {
        registration = new StudentRegistration();
    }

    @Test
    public void testValidRegistration() {
        assertDoesNotThrow(() -> registration.registerStudent("123", "John Doe", "johndoe@example.com", "1234567890"));
    }

    @Test
    public void testInvalidEmailRegistration() {
        assertThrows(InvalidStudentDetailException.class, () ->
                registration.registerStudent("123", "John Doe", "invalid_email", "1234567890"));
    }

    @Test
    public void testDuplicateRegistration() {
        assertDoesNotThrow(() -> registration.registerStudent("123", "John Doe", "johndoe@example.com", "1234567890"));
        assertThrows(DuplicateRegistrationException.class, () ->
                registration.registerStudent("123", "Jane Doe", "janedoe@example.com", "0987654321"));
    }
}

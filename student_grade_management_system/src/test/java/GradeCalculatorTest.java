import static org.junit.jupiter.api.Assertions.*;

import com.example.GradeCalculationException;
import com.example.GradeCalculator;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class GradeCalculatorTest {

    private GradeCalculator calculator = new GradeCalculator();

    @Test
    public void testValidGradeCalculation() {
        Map<String, Double> grades = new HashMap<>();
        grades.put("CS101", 85.0);
        assertDoesNotThrow(() -> {
            double result = calculator.calculateFinalGrade(grades);
            assertEquals(85.0, result, 0.001);
        });
    }

    @Test
    public void testGradeCalculationWithEmptyGrades() {
        Map<String, Double> grades = new HashMap<>();
        assertThrows(GradeCalculationException.class, () ->
                calculator.calculateFinalGrade(grades));
    }
}

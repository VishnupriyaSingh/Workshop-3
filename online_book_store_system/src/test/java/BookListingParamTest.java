import com.example.BookException;
import com.example.BookListing;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class BookListingParamTest {
    BookListing bookList = new BookListing();

    @ParameterizedTest
    @CsvSource({
            "The Great Gatsby, F. Scott Fitzgerald, 1234567890, 10.99, true",
            "1984, George Orwell, invalidisbn, 8.99, false",
    })
    void testAddBook(String title, String author, String isbn, double price, boolean expectedOutcome) {
        if (expectedOutcome) {
            assertDoesNotThrow(() -> bookList.addBook(title, author, isbn, price));
        } else {
            assertThrows(BookException.class, () -> bookList.addBook(title, author, isbn, price));
        }
    }
}

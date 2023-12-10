import com.example.BookException;
import com.example.BookListing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookListingTest {
    BookListing bookList = new BookListing();

    @Test
    void testAddValidBook() {
        assertDoesNotThrow(() -> bookList.addBook("Test Book", "Test Author", "1234567890", 9.99));
    }

    @Test
    void testAddBookWithInvalidISBN() {
        assertThrows(BookException.class, () -> bookList.addBook("Test Book", "Test Author", "invalidisbn", 9.99));
    }
}

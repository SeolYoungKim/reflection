package di;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() {
        BookRepository object = ContainerService.getObject(BookRepository.class);
        assertThat(object).isNotNull();
    }

    @Test
    public void getObject_BookService() {
        BookService object = ContainerService.getObject(BookService.class);
        assertThat(object).isNotNull();
        assertThat(object.bookRepository).isNotNull();
    }


}

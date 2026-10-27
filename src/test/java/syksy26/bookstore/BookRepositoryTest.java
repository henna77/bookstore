package syksy26.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import syksy26.bookstore.domain.Book;
import syksy26.bookstore.domain.BookRepository;
import syksy26.bookstore.domain.Category;
import syksy26.bookstore.domain.CategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("Fire & Blood");

        assertThat(books.get(0).getAuthor()).isEqualTo("George R. R. Martin");
    }

    @Test
    public void createNewBook() {
        Book book = new Book(
                "Fourth Wing",
                "Rebecca Yarros",
                2023,
                "123456789",
                19.99);

        book.setCategory(crepository.findByName("Fantasy").get(0));

        repository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        List<Book> books = repository.findByTitle("Fire & Blood");

        Book book = books.get(0);

        repository.delete(book);

        assertThat(repository.findById(book.getId())).isEmpty();
    }

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = crepository.findByName("Fantasy");

        assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Romance");

        crepository.save(category);

        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        Category category = new Category("Romance");

        crepository.save(category);
        crepository.delete(category);

        assertThat(crepository.findById(category.getCategoryid())).isEmpty();
    }
}
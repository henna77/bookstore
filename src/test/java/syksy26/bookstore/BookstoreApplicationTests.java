package syksy26.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import syksy26.bookstore.web.BookController;
import syksy26.bookstore.web.BookRestController;

@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	@Autowired
	private BookRestController bookRestController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(bookRestController).isNotNull();
	}
}

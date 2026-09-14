package syksy26.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import syksy26.bookstore.domain.Book;
import syksy26.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {

			repository.save(new Book(
					"Fire & Blood",
					"George R. R. Martin",
					2018,
					"978-1-524-79628-0",
					15.90));

			repository.save(new Book(
					"The Princess and the Queen",
					"George R. R. Martin",
					2013,
					"978-0-345-53832-3",
					19.90));
		};
	}

}

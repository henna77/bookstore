package syksy26.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import syksy26.bookstore.domain.Book;
import syksy26.bookstore.domain.BookRepository;
import syksy26.bookstore.domain.Category;
import syksy26.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category category1 = new Category("Fantasy");
			Category category2 = new Category("Horror");

			categoryRepository.save(category1);
			categoryRepository.save(category2);

			Book book1 = new Book(
					"Fire & Blood",
					"George R. R. Martin",
					2018,
					"978-1-524-79628-0",
					15.90);

			book1.setCategory(category1);
			repository.save(book1);

			Book book2 = new Book(
					"The Princess and the Queen",
					"George R. R. Martin",
					2013,
					"978-0-345-53832-3",
					19.90);

			book2.setCategory(category1);
			repository.save(book2);

			Book book3 = new Book(
					"IT",
					"Stephen King",
					1986,
					"978-1-5011-4207-4",
					14.90);

			book3.setCategory(category2);
			repository.save(book3);
		};

	}
}
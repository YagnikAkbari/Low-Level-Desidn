package com.library.seeder;

import java.time.Year;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.Category;
import com.library.entity.Genre;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.MasterDataService;

public class SeedBook {
  public static void seed(AuthorService authorService, MasterDataService masterDataService, BookService bookService) {
    Author author = new Author("Yagnik Akbari");
    int authorId = authorService.addAuthor(author);
    Genre genre = new Genre("Sci-fi");
    Category category = new Category("Universe");
    Category category2 = new Category("Study");
    Genre genreExtra = new Genre("Education");
    Category categoryExtra = new Category("Practice");
    int genreId = masterDataService.addGenre(genre);
    int categoryId = masterDataService.addCategory(category);
    int categoryId2 = masterDataService.addCategory(category2);
    int genreExtraId = masterDataService.addGenre(genreExtra);
    int categoryExtraId = masterDataService.addCategory(categoryExtra);
    Book.Builder bookBuilder = new Book.Builder("Python for beginner.", "ISDN001", authorId);
    bookBuilder.setPublishedYear(Year.of(2023));
    bookBuilder.setGenre(genreId);
    bookBuilder.setGenre(genreExtraId);
    bookBuilder.setCategory(categoryId);
    bookBuilder.setCategory(categoryId2);
    bookBuilder.setCategory(categoryExtraId);
    Book book = bookBuilder.build();
    bookService.addBook(book);

    // --------------------------------------------------------

    Author author1 = new Author("Isaac Asimov");
    int authorId1 = authorService.addAuthor(author1);
    Genre genre1 = new Genre("Sci-Fi");
    Category category1a = new Category("Space");
    Category category1b = new Category("Robotics");
    Genre genre1Extra = new Genre("Adventure");
    Category category1Extra = new Category("Classics");
    int genreId1 = masterDataService.addGenre(genre1);
    int categoryId1a = masterDataService.addCategory(category1a);
    int categoryId1b = masterDataService.addCategory(category1b);
    int genreId1Extra = masterDataService.addGenre(genre1Extra);
    int categoryId1Extra = masterDataService.addCategory(category1Extra);

    Book.Builder builder1 = new Book.Builder(
        "Foundation",
        "ISBN001",
        authorId1);
    builder1.setPublishedYear(Year.of(1951));
    builder1.setGenre(genreId1);
    builder1.setGenre(genreId1Extra);
    builder1.setCategory(categoryId1a);
    builder1.setCategory(categoryId1b);
    builder1.setCategory(categoryId1Extra);

    Book book1 = builder1.build();
    bookService.addBook(book1);

    // --------------------------------------------------------

    Author author2 = new Author("J.K. Rowling");
    int authorId2 = authorService.addAuthor(author2);
    Genre genre2 = new Genre("Fantasy");
    Category category2a = new Category("Magic");
    Category category2b = new Category("Adventure");
    Category category2Extra = new Category("School Life");
    Genre genre2Extra = new Genre("Young Adult");
    int genreId2 = masterDataService.addGenre(genre2);
    int categoryId2a = masterDataService.addCategory(category2a);
    int categoryId2b = masterDataService.addCategory(category2b);
    int categoryId2Extra = masterDataService.addCategory(category2Extra);
    int genreId2Extra = masterDataService.addGenre(genre2Extra);

    Book.Builder builder2 = new Book.Builder(
        "Harry Potter and the Sorcerer's Stone",
        "ISBN002",
        authorId2);
    builder2.setPublishedYear(Year.of(1997));
    builder2.setGenre(genreId2);
    builder2.setGenre(genreId2Extra);
    builder2.setCategory(categoryId2a);
    builder2.setCategory(categoryId2b);
    builder2.setCategory(categoryId2Extra);

    Book book2 = builder2.build();
    bookService.addBook(book2);

    // --------------------------------------------------------

    Author author3 = new Author("George Orwell");
    int authorId3 = authorService.addAuthor(author3);
    Genre genre3 = new Genre("Dystopian");
    Category category3a = new Category("Politics");
    Category category3b = new Category("Society");
    Genre genre3Extra = new Genre("Classic");
    Category category3Extra = new Category("Political Fiction");
    int genreId3 = masterDataService.addGenre(genre3);
    int categoryId3a = masterDataService.addCategory(category3a);
    int categoryId3b = masterDataService.addCategory(category3b);
    int genreId3Extra = masterDataService.addGenre(genre3Extra);
    int categoryId3Extra = masterDataService.addCategory(category3Extra);

    Book.Builder builder3 = new Book.Builder(
        "1984",
        "ISBN003",
        authorId3);
    builder3.setPublishedYear(Year.of(1949));
    builder3.setGenre(genreId3);
    builder3.setGenre(genreId3Extra);
    builder3.setCategory(categoryId3a);
    builder3.setCategory(categoryId3b);
    builder3.setCategory(categoryId3Extra);

    Book book3 = builder3.build();
    bookService.addBook(book3);

    // --------------------------------------------------------

    Author author4 = new Author("Yuval Noah Harari");
    int authorId4 = authorService.addAuthor(author4);
    Genre genre4 = new Genre("History");
    Category category4a = new Category("Human Evolution");
    Category category4b = new Category("Civilization");
    int genreId4 = masterDataService.addGenre(genre4);
    int categoryId4a = masterDataService.addCategory(category4a);
    int categoryId4b = masterDataService.addCategory(category4b);

    Book.Builder builder4 = new Book.Builder(
        "Sapiens",
        "ISBN004",
        authorId4);
    builder4.setGenre(genreId4);
    builder4.setCategory(categoryId4a);
    builder4.setCategory(categoryId4b);

    Book book4 = builder4.build();
    bookService.addBook(book4);

    // --------------------------------------------------------

    Author author5 = new Author("Robert C. Martin");
    int authorId5 = authorService.addAuthor(author5);
    Genre genre5 = new Genre("Programming");
    Category category5a = new Category("Software Engineering");
    Category category5b = new Category("Clean Code");
    int genreId5 = masterDataService.addGenre(genre5);
    int categoryId5a = masterDataService.addCategory(category5a);
    int categoryId5b = masterDataService.addCategory(category5b);

    Book.Builder builder5 = new Book.Builder(
        "Clean Code",
        "ISBN005",
        authorId5);
    builder5.setGenre(genreId5);
    builder5.setCategory(categoryId5a);
    builder5.setCategory(categoryId5b);

    Book book5 = builder5.build();
    bookService.addBook(book5);

    // --------------------------------------------------------

    Author author6 = new Author("Frank Herbert");
    int authorId6 = authorService.addAuthor(author6);
    Genre genre6 = new Genre("Sci-Fi");
    Category category6a = new Category("Desert");
    Category category6b = new Category("Politics");
    Genre genre6Extra = new Genre("Adventure");
    Category category6Extra = new Category("Epic");
    int genreId6 = masterDataService.addGenre(genre6);
    int categoryId6a = masterDataService.addCategory(category6a);
    int categoryId6b = masterDataService.addCategory(category6b);
    int genreId6Extra = masterDataService.addGenre(genre6Extra);
    int categoryId6Extra = masterDataService.addCategory(category6Extra);

    Book.Builder builder6 = new Book.Builder(
        "Dune",
        "ISBN006",
        authorId6);
    builder6.setPublishedYear(Year.of(1965));
    builder6.setGenre(genreId6);
    builder6.setGenre(genreId6Extra);
    builder6.setCategory(categoryId6a);
    builder6.setCategory(categoryId6b);
    builder6.setCategory(categoryId6Extra);

    Book book6 = builder6.build();
    bookService.addBook(book6);

    // --------------------------------------------------------

    Author author7 = new Author("Dan Brown");
    int authorId7 = authorService.addAuthor(author7);
    Genre genre7 = new Genre("Thriller");
    Category category7a = new Category("Mystery");
    Category category7b = new Category("Symbolism");
    int genreId7 = masterDataService.addGenre(genre7);
    int categoryId7a = masterDataService.addCategory(category7a);
    int categoryId7b = masterDataService.addCategory(category7b);

    Book.Builder builder7 = new Book.Builder(
        "The Da Vinci Code",
        "ISBN007",
        authorId7);
    builder7.setGenre(genreId7);
    builder7.setCategory(categoryId7a);
    builder7.setCategory(categoryId7b);

    Book book7 = builder7.build();
    bookService.addBook(book7);

    // --------------------------------------------------------

    Author author8 = new Author("Stephen Hawking");
    int authorId8 = authorService.addAuthor(author8);
    Genre genre8 = new Genre("Science");
    Category category8a = new Category("Physics");
    Category category8b = new Category("Cosmology");
    int genreId8 = masterDataService.addGenre(genre8);
    int categoryId8a = masterDataService.addCategory(category8a);
    int categoryId8b = masterDataService.addCategory(category8b);

    Book.Builder builder8 = new Book.Builder(
        "A Brief History of Time",
        "ISBN008",
        authorId8);
    builder8.setGenre(genreId8);
    builder8.setCategory(categoryId8a);
    builder8.setCategory(categoryId8b);

    Book book8 = builder8.build();
    bookService.addBook(book8);

    // --------------------------------------------------------

    Author author9 = new Author("J.R.R. Tolkien");
    int authorId9 = authorService.addAuthor(author9);
    Genre genre9 = new Genre("Fantasy");
    Category category9a = new Category("Adventure");
    Category category9b = new Category("Middle Earth");
    int genreId9 = masterDataService.addGenre(genre9);
    int categoryId9a = masterDataService.addCategory(category9a);
    int categoryId9b = masterDataService.addCategory(category9b);

    Book.Builder builder9 = new Book.Builder(
        "The Hobbit",
        "ISBN009",
        authorId9);
    builder9.setGenre(genreId9);
    builder9.setCategory(categoryId9a);
    builder9.setCategory(categoryId9b);

    Book book9 = builder9.build();
    bookService.addBook(book9);

    // --------------------------------------------------------

    Author author10 = new Author("Andrew Hunt");
    int authorId10 = authorService.addAuthor(author10);
    Genre genre10 = new Genre("Programming");
    Category category10a = new Category("Best Practices");
    Category category10b = new Category("Development");
    int genreId10 = masterDataService.addGenre(genre10);
    int categoryId10a = masterDataService.addCategory(category10a);
    int categoryId10b = masterDataService.addCategory(category10b);

    Book.Builder builder10 = new Book.Builder(
        "The Pragmatic Programmer",
        "ISBN010",
        authorId10);
    builder10.setGenre(genreId10);
    builder10.setCategory(categoryId10a);
    builder10.setCategory(categoryId10b);

    Book book10 = builder10.build();
    bookService.addBook(book10);

    // --------------------------------------------------------

    Author author11 = new Author("Agatha Christie");
    int authorId11 = authorService.addAuthor(author11);
    Genre genre11 = new Genre("Mystery");
    Category category11a = new Category("Crime");
    Category category11b = new Category("Detective");
    int genreId11 = masterDataService.addGenre(genre11);
    int categoryId11a = masterDataService.addCategory(category11a);
    int categoryId11b = masterDataService.addCategory(category11b);

    Book.Builder builder11 = new Book.Builder(
        "Murder on the Orient Express",
        "ISBN011",
        authorId11);
    builder11.setGenre(genreId11);
    builder11.setCategory(categoryId11a);
    builder11.setCategory(categoryId11b);

    Book book11 = builder11.build();
    bookService.addBook(book11);

    // --------------------------------------------------------

    Author author12 = new Author("Walter Isaacson");
    int authorId12 = authorService.addAuthor(author12);
    Genre genre12 = new Genre("Biography");
    Category category12a = new Category("Innovation");
    Category category12b = new Category("Technology");
    int genreId12 = masterDataService.addGenre(genre12);
    int categoryId12a = masterDataService.addCategory(category12a);
    int categoryId12b = masterDataService.addCategory(category12b);

    Book.Builder builder12 = new Book.Builder(
        "Steve Jobs",
        "ISBN012",
        authorId12);
    builder12.setGenre(genreId12);
    builder12.setCategory(categoryId12a);
    builder12.setCategory(categoryId12b);

    Book book12 = builder12.build();
    bookService.addBook(book12);

    // --------------------------------------------------------

    Author author13 = new Author("Sun Tzu");
    int authorId13 = authorService.addAuthor(author13);
    Genre genre13 = new Genre("Strategy");
    Category category13a = new Category("War");
    Category category13b = new Category("Leadership");
    int genreId13 = masterDataService.addGenre(genre13);
    int categoryId13a = masterDataService.addCategory(category13a);
    int categoryId13b = masterDataService.addCategory(category13b);

    Book.Builder builder13 = new Book.Builder(
        "The Art of War",
        "ISBN013",
        authorId13);
    builder13.setGenre(genreId13);
    builder13.setCategory(categoryId13a);
    builder13.setCategory(categoryId13b);

    Book book13 = builder13.build();
    bookService.addBook(book13);

    // --------------------------------------------------------

    Author author14 = new Author("James Clear");
    int authorId14 = authorService.addAuthor(author14);
    Genre genre14 = new Genre("Self Help");
    Category category14a = new Category("Habits");
    Category category14b = new Category("Productivity");
    Category category14Extra = new Category("Psychology");
    int genreId14 = masterDataService.addGenre(genre14);
    int categoryId14a = masterDataService.addCategory(category14a);
    int categoryId14b = masterDataService.addCategory(category14b);
    int categoryId14Extra = masterDataService.addCategory(category14Extra);

    Book.Builder builder14 = new Book.Builder(
        "Atomic Habits",
        "ISBN014",
        authorId14);
    builder14.setPublishedYear(Year.of(2018));
    builder14.setGenre(genreId14);
    builder14.setCategory(categoryId14a);
    builder14.setCategory(categoryId14b);
    builder14.setCategory(categoryId14Extra);

    Book book14 = builder14.build();
    bookService.addBook(book14);

    // --------------------------------------------------------

    Author author15 = new Author("George R.R. Martin");
    int authorId15 = authorService.addAuthor(author15);
    Genre genre15 = new Genre("Fantasy");
    Category category15a = new Category("Kingdoms");
    Category category15b = new Category("Politics");
    int genreId15 = masterDataService.addGenre(genre15);
    int categoryId15a = masterDataService.addCategory(category15a);
    int categoryId15b = masterDataService.addCategory(category15b);

    Book.Builder builder15 = new Book.Builder(
        "A Game of Thrones",
        "ISBN015",
        authorId15);
    builder15.setGenre(genreId15);
    builder15.setCategory(categoryId15a);
    builder15.setCategory(categoryId15b);

    Book book15 = builder15.build();
    bookService.addBook(book15);
  }
}

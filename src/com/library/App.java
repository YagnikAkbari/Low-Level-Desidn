package com.library;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.Branch;
import com.library.entity.Category;
import com.library.entity.Genre;
import com.library.entity.Library;
import com.library.entity.LibraryBook;
import com.library.entity.Patron;
import com.library.entity.Reservation;
import com.library.enums.BookSearchField;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.BorrowingRepository;
import com.library.repository.InventoryRepository;
import com.library.repository.LibraryRepository;
import com.library.repository.MasterDataRepository;
import com.library.repository.PatronRepository;
import com.library.repository.ReservationRepository;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.BorrowingService;
import com.library.service.InventoryService;
import com.library.service.LibraryService;
import com.library.service.MasterDataService;
import com.library.service.NotificationService;
import com.library.service.PatronService;
import com.library.service.ReservationService;

public class App {
  private static class Context {
    final AuthorService authorService;
    final MasterDataService masterDataService;
    final LibraryService libraryService;
    final BookService bookService;
    final InventoryService inventoryService;
    final PatronService patronService;
    final BorrowingService borrowingService;
    final ReservationService reservationService;

    Context() {
      AuthorRepository authorRepo = new AuthorRepository();
      MasterDataRepository masterDataRepo = new MasterDataRepository();
      LibraryRepository libraryRepo = new LibraryRepository();
      BookRepository bookRepo = new BookRepository();
      InventoryRepository inventoryRepo = new InventoryRepository();
      PatronRepository patronRepo = new PatronRepository();
      BorrowingRepository borrowingRepo = new BorrowingRepository();
      ReservationRepository reservationRepo = new ReservationRepository();
      NotificationService notificationService = new NotificationService();

      this.authorService = new AuthorService(authorRepo);
      this.masterDataService = new MasterDataService(masterDataRepo);
      this.libraryService = new LibraryService(libraryRepo);
      this.bookService = new BookService(bookRepo);
      this.inventoryService = new InventoryService(inventoryRepo, notificationService);
      this.patronService = new PatronService(patronRepo);
      this.borrowingService = new BorrowingService(borrowingRepo, inventoryService, notificationService,
          reservationRepo);
      this.reservationService = new ReservationService(reservationRepo, inventoryService, notificationService);
    }
  }

  @FunctionalInterface
  private interface CheckedRunnable {
    void run() throws Exception;
  }

  public static void run() {
    Context context = new Context();
    try (Scanner scanner = new Scanner(System.in)) {
      boolean running = true;
      while (running) {
        printMainMenu();
        String choice = scanner.nextLine().trim();
        switch (choice) {
          case "1":
            runSafely(() -> manageLibraries(scanner, context));
            break;
          case "2":
            runSafely(() -> manageBranches(scanner, context));
            break;
          case "3":
            runSafely(() -> manageAuthors(scanner, context));
            break;
          case "4":
            runSafely(() -> manageGenres(scanner, context));
            break;
          case "5":
            runSafely(() -> manageCategories(scanner, context));
            break;
          case "6":
            runSafely(() -> manageBooks(scanner, context));
            break;
          case "7":
            runSafely(() -> manageInventory(scanner, context));
            break;
          case "8":
            runSafely(() -> managePatrons(scanner, context));
            break;
          case "9":
            runSafely(() -> manageBorrowing(scanner, context));
            break;
          case "10":
            runSafely(() -> manageReservations(scanner, context));
            break;
          case "11":
            runSafely(() -> searchBooks(scanner, context));
            break;
          case "12":
            runSafely(() -> recommendBooks(scanner, context));
            break;
          case "0":
            running = false;
            break;
          default:
            System.out.println("Invalid menu option.");
        }
      }
    }
  }

  public static void main(String[] args) {
    run();
  }

  private static void manageLibraries(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nLibrary Menu");
      System.out.println("1. Add library");
      System.out.println("2. Update library");
      System.out.println("3. Delete library");
      System.out.println("4. List libraries");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            String name = readRequiredString(scanner, "Library name");
            int id = context.libraryService.addLibrary(new Library(name));
            System.out.println("Library created with id " + id);
          });
          break;
        case "2":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Library id");
            Library current = context.libraryService.getLibraryById(id);
            String name = readStringOrDefault(scanner, "Library name", current.getName());
            Library updated = new Library(name);
            updated.setId(current.getId());
            context.libraryService.updateLibrary(updated);
            System.out.println("Library updated.");
          });
          break;
        case "3":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Library id");
            context.libraryService.removeLibrary(id);
            System.out.println("Library deleted.");
          });
          break;
        case "4":
          printCollection("Libraries", context.libraryService.listLibrary());
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void manageBranches(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nBranch Menu");
      System.out.println("1. Add branch");
      System.out.println("2. Update branch");
      System.out.println("3. Delete branch");
      System.out.println("4. List branches");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            String name = readRequiredString(scanner, "Branch name");
            String location = readRequiredString(scanner, "Branch location");
            int libraryId = readRequiredInt(scanner, "Library id");
            ensureLibraryExists(context, libraryId);
            int id = context.libraryService.addBranch(new Branch(name, location, libraryId));
            System.out.println("Branch created with id " + id);
          });
          break;
        case "2":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Branch id");
            Branch current = context.libraryService.getBranchById(id);
            String name = readStringOrDefault(scanner, "Branch name", current.getName());
            String location = readStringOrDefault(scanner, "Branch location", current.getLocation());
            int libraryId = readIntOrDefault(scanner, "Library id", current.getLibraryId());
            ensureLibraryExists(context, libraryId);
            Branch updated = new Branch(name, location, libraryId);
            updated.setId(current.getId());
            context.libraryService.updateBranch(updated);
            System.out.println("Branch updated.");
          });
          break;
        case "3":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Branch id");
            context.libraryService.removeBranch(id);
            System.out.println("Branch deleted.");
          });
          break;
        case "4":
          printCollection("Branches", context.libraryService.listBranch());
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void manageAuthors(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nAuthor Menu");
      System.out.println("1. Add author");
      System.out.println("2. Update author");
      System.out.println("3. Delete author");
      System.out.println("4. List authors");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            String name = readRequiredString(scanner, "Author name");
            int id = context.authorService.addAuthor(new Author(name));
            System.out.println("Author created with id " + id);
          });
          break;
        case "2":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Author id");
            Author current = context.authorService.getAuthorById(id);
            String name = readStringOrDefault(scanner, "Author name", current.getName());
            Author updated = new Author(name);
            updated.setId(current.getId());
            context.authorService.updateAuthor(updated);
            System.out.println("Author updated.");
          });
          break;
        case "3":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Author id");
            context.authorService.removeAuthor(id);
            System.out.println("Author deleted.");
          });
          break;
        case "4":
          printCollection("Authors", context.authorService.listAuthor());
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void manageGenres(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nGenre Menu");
      System.out.println("1. Add genre");
      System.out.println("2. Update genre");
      System.out.println("3. Delete genre");
      System.out.println("4. List genres");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            String name = readRequiredString(scanner, "Genre name");
            int id = context.masterDataService.addGenre(new Genre(name));
            System.out.println("Genre created with id " + id);
          });
          break;
        case "2":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Genre id");
            Genre current = context.masterDataService.getGenreById(id);
            String name = readStringOrDefault(scanner, "Genre name", current.getName());
            Genre updated = new Genre(name);
            updated.setId(current.getId());
            context.masterDataService.updateGenre(updated);
            System.out.println("Genre updated.");
          });
          break;
        case "3":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Genre id");
            context.masterDataService.removeGenre(id);
            System.out.println("Genre deleted.");
          });
          break;
        case "4":
          printCollection("Genres", context.masterDataService.listGenre());
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void manageCategories(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nCategory Menu");
      System.out.println("1. Add category");
      System.out.println("2. Update category");
      System.out.println("3. Delete category");
      System.out.println("4. List categories");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            String name = readRequiredString(scanner, "Category name");
            int id = context.masterDataService.addCategory(new Category(name));
            System.out.println("Category created with id " + id);
          });
          break;
        case "2":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Category id");
            Category current = context.masterDataService.getCategoryById(id);
            String name = readStringOrDefault(scanner, "Category name", current.getName());
            Category updated = new Category(name);
            updated.setId(current.getId());
            context.masterDataService.updateCategory(updated);
            System.out.println("Category updated.");
          });
          break;
        case "3":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Category id");
            context.masterDataService.removeCategory(id);
            System.out.println("Category deleted.");
          });
          break;
        case "4":
          printCollection("Categories", context.masterDataService.listCategory());
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void manageBooks(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nBook Menu");
      System.out.println("1. Add book");
      System.out.println("2. Update book");
      System.out.println("3. Delete book");
      System.out.println("4. List books");
      System.out.println("5. View book by id");
      System.out.println("6. Search books");
      System.out.println("7. Recommend books");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> createBook(scanner, context));
          break;
        case "2":
          runSafely(() -> updateBook(scanner, context));
          break;
        case "3":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Book id");
            context.bookService.removeBook(id);
            System.out.println("Book deleted.");
          });
          break;
        case "4":
          printCollection("Books", context.bookService.listBook());
          break;
        case "5":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Book id");
            System.out.println(context.bookService.getBookById(id));
          });
          break;
        case "6":
          runSafely(() -> searchBooks(scanner, context));
          break;
        case "7":
          runSafely(() -> recommendBooks(scanner, context));
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void manageInventory(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nInventory Menu");
      System.out.println("1. Create inventory record");
      System.out.println("2. Add copies");
      System.out.println("3. Remove copies");
      System.out.println("4. Delete inventory record");
      System.out.println("5. Transfer copies");
      System.out.println("6. List inventory");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            int branchId = readRequiredInt(scanner, "Branch id");
            int bookId = readRequiredInt(scanner, "Book id");
            int copies = readRequiredInt(scanner, "Total copies");
            ensureBranchExists(context, branchId);
            ensureBookExists(context, bookId);
            ensurePatronlessInventorySlot(context, branchId, bookId);
            int id = context.inventoryService.createInventory(new LibraryBook(branchId, bookId, copies));
            System.out.println("Inventory created with id " + id);
          });
          break;
        case "2":
          runSafely(() -> {
            int branchId = readRequiredInt(scanner, "Branch id");
            int bookId = readRequiredInt(scanner, "Book id");
            int copies = readRequiredInt(scanner, "Copies");
            context.inventoryService.addCopies(branchId, bookId, copies);
            System.out.println("Copies added.");
          });
          break;
        case "3":
          runSafely(() -> {
            int branchId = readRequiredInt(scanner, "Branch id");
            int bookId = readRequiredInt(scanner, "Book id");
            int copies = readRequiredInt(scanner, "Copies");
            context.inventoryService.removeCopies(branchId, bookId, copies);
            System.out.println("Copies removed.");
          });
          break;
        case "4":
          runSafely(() -> {
            int inventoryId = readRequiredInt(scanner, "Inventory id");
            context.inventoryService.removeInventory(inventoryId);
            System.out.println("Inventory record deleted.");
          });
          break;
        case "5":
          runSafely(() -> {
            int fromBranchId = readRequiredInt(scanner, "From branch id");
            int toBranchId = readRequiredInt(scanner, "To branch id");
            int bookId = readRequiredInt(scanner, "Book id");
            int copies = readRequiredInt(scanner, "Copies");
            ensureBranchExists(context, fromBranchId);
            ensureBranchExists(context, toBranchId);
            ensureBookExists(context, bookId);
            context.inventoryService.transferBookToBranch(fromBranchId, toBranchId, bookId, copies);
            System.out.println("Copies transferred.");
          });
          break;
        case "6":
          printCollection("Inventory", context.inventoryService.listLibraryBooks());
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void managePatrons(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nPatron Menu");
      System.out.println("1. Add patron");
      System.out.println("2. Update patron");
      System.out.println("3. Delete patron");
      System.out.println("4. List patrons");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            String name = readRequiredString(scanner, "Patron name");
            String mobile = readRequiredString(scanner, "Mobile number");
            String email = readRequiredString(scanner, "Email");
            context.patronService.addPatron(new Patron(name, mobile, email));
            System.out.println("Patron created.");
          });
          break;
        case "2":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Patron id");
            Patron current = context.patronService.getPatronById(id);
            String name = readStringOrDefault(scanner, "Patron name", current.getName());
            String mobile = readStringOrDefault(scanner, "Mobile number", current.getMobile_no());
            String email = readStringOrDefault(scanner, "Email", current.getEmail());
            Patron updated = new Patron(name, mobile, email);
            updated.setId(current.getId());
            context.patronService.updatePatron(updated);
            System.out.println("Patron updated.");
          });
          break;
        case "3":
          runSafely(() -> {
            int id = readRequiredInt(scanner, "Patron id");
            context.patronService.removePatron(id);
            System.out.println("Patron deleted.");
          });
          break;
        case "4":
          printCollection("Patrons", context.patronService.listPatron());
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void manageBorrowing(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nBorrowing Menu");
      System.out.println("1. Borrow book");
      System.out.println("2. Return book");
      System.out.println("3. List borrowings");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            int branchId = readRequiredInt(scanner, "Branch id");
            int bookId = readRequiredInt(scanner, "Book id");
            int patronId = readRequiredInt(scanner, "Patron id");
            int copies = readRequiredInt(scanner, "Copies");
            ensureBranchExists(context, branchId);
            ensureBookExists(context, bookId);
            ensurePatronExists(context, patronId);
            ensureInventoryExists(context, branchId, bookId);
            context.borrowingService.borrowBook(branchId, bookId, patronId, copies);
            System.out.println("Borrow recorded.");
          });
          break;
        case "2":
          runSafely(() -> {
            int branchId = readRequiredInt(scanner, "Branch id");
            int bookId = readRequiredInt(scanner, "Book id");
            int patronId = readRequiredInt(scanner, "Patron id");
            int copies = readRequiredInt(scanner, "Copies");
            ensureBranchExists(context, branchId);
            ensureBookExists(context, bookId);
            ensurePatronExists(context, patronId);
            ensureInventoryExists(context, branchId, bookId);
            context.borrowingService.returnBook(branchId, bookId, patronId, copies);
            System.out.println("Return recorded.");
          });
          break;
        case "3":
          printCollection("Borrowings", context.borrowingService.listBorrowings());
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void manageReservations(Scanner scanner, Context context) {
    boolean back = false;
    while (!back) {
      System.out.println("\nReservation Menu");
      System.out.println("1. Create reservation");
      System.out.println("2. Cancel reservation");
      System.out.println("3. List reservations");
      System.out.println("4. Fulfill reservation");
      System.out.println("0. Back");
      System.out.print("Choose: ");
      String choice = scanner.nextLine().trim();
      switch (choice) {
        case "1":
          runSafely(() -> {
            int branchId = readRequiredInt(scanner, "Branch id");
            int bookId = readRequiredInt(scanner, "Book id");
            int patronId = readRequiredInt(scanner, "Patron id");
            ensureBranchExists(context, branchId);
            ensureBookExists(context, bookId);
            ensurePatronExists(context, patronId);
            ensureInventoryExists(context, branchId, bookId);
            Reservation reservation = new Reservation(branchId, bookId, patronId, java.time.LocalDate.now());
            int id = context.reservationService.reserveBook(reservation);
            System.out.println("Reservation created with id " + id);
          });
          break;
        case "2":
          runSafely(() -> {
            int reservationId = readRequiredInt(scanner, "Reservation id");
            context.reservationService.cancelReservation(reservationId);
            System.out.println("Reservation cancelled.");
          });
          break;
        case "3":
          printCollection("Reservations", context.reservationService.listReservation());
          break;
        case "4":
          runSafely(() -> {
            int branchId = readRequiredInt(scanner, "Branch id");
            int bookId = readRequiredInt(scanner, "Book id");
            context.borrowingService.fulfillReservation(branchId, bookId);
            System.out.println("Reservation fulfilment processed.");
          });
          break;
        case "0":
          back = true;
          break;
        default:
          System.out.println("Invalid menu option.");
      }
    }
  }

  private static void createBook(Scanner scanner, Context context) {
    String title = readRequiredString(scanner, "Book title");
    String isbn = readRequiredString(scanner, "ISBN");
    Year year = readOptionalYear(scanner, "Published year");
    int authorId = readRequiredInt(scanner, "Author id");
    ensureAuthorExists(context, authorId);
    List<Integer> genreIds = readIdList(scanner, "Genre ids (comma separated, optional)");
    List<Integer> categoryIds = readIdList(scanner, "Category ids (comma separated, optional)");
    ensureGenreIdsExist(context, genreIds);
    ensureCategoryIdsExist(context, categoryIds);

    Book.Builder builder = new Book.Builder(title, isbn, authorId);
    if (year != null) {
      builder.setPublishedYear(year);
    }
    for (Integer genreId : genreIds) {
      builder.setGenre(genreId);
    }
    for (Integer categoryId : categoryIds) {
      builder.setCategory(categoryId);
    }

    Book book = builder.build();
    context.bookService.addBook(book);
    System.out.println("Book created with id " + book.getId());
  }

  private static void updateBook(Scanner scanner, Context context) {
    int id = readRequiredInt(scanner, "Book id");
    Book current = context.bookService.getBookById(id);
    Year year = readOptionalYearOrDefault(scanner, "Published year", current.getPublishedYear());
    int authorId = readIntOrDefault(scanner, "Author id", current.getAuthorId());
    ensureAuthorExists(context, authorId);
    List<Integer> genreIds = readIdListOrDefault(scanner, "Genre ids (comma separated)", current.getGenreIds());
    List<Integer> categoryIds = readIdListOrDefault(scanner, "Category ids (comma separated)",
        current.getCategoryIds());
    ensureGenreIdsExist(context, genreIds);
    ensureCategoryIdsExist(context, categoryIds);

    Book.Builder builder = new Book.Builder(current.getTitle(), current.getISBN(), authorId);
    if (year != null) {
      builder.setPublishedYear(year);
    }
    for (Integer genreId : genreIds) {
      builder.setGenre(genreId);
    }
    for (Integer categoryId : categoryIds) {
      builder.setCategory(categoryId);
    }
    Book updated = builder.build();
    updated.setId(current.getId());
    context.bookService.updateBook(updated);
    System.out.println("Book updated.");
  }

  private static void searchBooks(Scanner scanner, Context context) {
    System.out.print("Search field [1=TITLE, 2=AUTHOR, 3=ISBN]: ");
    String fieldInput = scanner.nextLine().trim();
    BookSearchField field;
    switch (fieldInput) {
      case "2":
        field = BookSearchField.AUTHOR;
        break;
      case "3":
        field = BookSearchField.ISBN;
        break;
      default:
        field = BookSearchField.TITLE;
        break;
    }
    String search = readRequiredString(scanner, "Search text");
    printCollection("Search results", context.bookService.searchBooks(search, field));
  }

  private static void recommendBooks(Scanner scanner, Context context) {
    int authorId = readOptionalInt(scanner, "Author id", 0);
    int genreId = readOptionalInt(scanner, "Genre id", 0);
    int categoryId = readOptionalInt(scanner, "Category id", 0);
    if (authorId > 0) {
      ensureAuthorExists(context, authorId);
    }
    if (genreId > 0) {
      ensureGenreExists(context, genreId);
    }
    if (categoryId > 0) {
      ensureCategoryExists(context, categoryId);
    }
    printCollection("Recommendations", context.bookService.recommendBook(authorId, genreId, categoryId));
  }

  private static void runSafely(CheckedRunnable runnable) {
    try {
      runnable.run();
    } catch (Exception exception) {
      System.out.println("Error: " + exception.getMessage());
    }
  }

  private static void printMainMenu() {
    System.out.println("\nLibrary Management");
    System.out.println("1. Libraries");
    System.out.println("2. Branches");
    System.out.println("3. Authors");
    System.out.println("4. Genres");
    System.out.println("5. Categories");
    System.out.println("6. Books");
    System.out.println("7. Inventory");
    System.out.println("8. Patrons");
    System.out.println("9. Borrowing");
    System.out.println("10. Reservations");
    System.out.println("11. Search books");
    System.out.println("12. Recommend books");
    System.out.println("0. Exit");
    System.out.print("Choose: ");
  }

  private static void printCollection(String title, List<?> items) {
    System.out.println("\n" + title);
    if (items == null || items.isEmpty()) {
      System.out.println("No data found.");
      return;
    }
    for (Object item : items) {
      System.out.println(item);
    }
  }

  private static String readRequiredString(Scanner scanner, String label) {
    System.out.print(label + ": ");
    String value = scanner.nextLine().trim();
    if (value.isEmpty()) {
      throw new IllegalArgumentException(label + " is required.");
    }
    return value;
  }

  private static String readStringOrDefault(Scanner scanner, String label, String currentValue) {
    System.out.print(label + " [" + safeValue(currentValue) + "]: ");
    String value = scanner.nextLine().trim();
    if (value.isEmpty()) {
      return currentValue;
    }
    return value;
  }

  private static int readRequiredInt(Scanner scanner, String label) {
    System.out.print(label + ": ");
    String raw = scanner.nextLine().trim();
    if (raw.isEmpty()) {
      throw new IllegalArgumentException(label + " is required.");
    }
    try {
      return Integer.parseInt(raw);
    } catch (NumberFormatException exception) {
      throw new IllegalArgumentException(label + " must be a valid number.");
    }
  }

  private static int readIntOrDefault(Scanner scanner, String label, int defaultValue) {
    System.out.print(label + " [" + defaultValue + "]: ");
    String raw = scanner.nextLine().trim();
    if (raw.isEmpty()) {
      return defaultValue;
    }
    try {
      return Integer.parseInt(raw);
    } catch (NumberFormatException exception) {
      throw new IllegalArgumentException(label + " must be a valid number.");
    }
  }

  private static int readOptionalInt(Scanner scanner, String label, int defaultValue) {
    System.out.print(label + " [" + defaultValue + "]: ");
    String raw = scanner.nextLine().trim();
    if (raw.isEmpty()) {
      return defaultValue;
    }
    try {
      return Integer.parseInt(raw);
    } catch (NumberFormatException exception) {
      throw new IllegalArgumentException(label + " must be a valid number.");
    }
  }

  private static Year readOptionalYear(Scanner scanner, String label) {
    System.out.print(label + " (YYYY, optional): ");
    String raw = scanner.nextLine().trim();
    if (raw.isEmpty()) {
      return null;
    }
    try {
      return Year.parse(raw);
    } catch (Exception exception) {
      throw new IllegalArgumentException(label + " must be a valid year.");
    }
  }

  private static Year readOptionalYearOrDefault(Scanner scanner, String label, Year currentValue) {
    System.out.print(label + " [" + safeValue(currentValue) + "]: ");
    String raw = scanner.nextLine().trim();
    if (raw.isEmpty()) {
      return currentValue;
    }
    try {
      return Year.parse(raw);
    } catch (Exception exception) {
      throw new IllegalArgumentException(label + " must be a valid year.");
    }
  }

  private static List<Integer> readIdList(Scanner scanner, String label) {
    System.out.print(label + ": ");
    String raw = scanner.nextLine().trim();
    if (raw.isEmpty()) {
      return new ArrayList<>();
    }
    return parseIdList(raw, label);
  }

  private static List<Integer> readIdListOrDefault(Scanner scanner, String label, List<Integer> defaultValue) {
    System.out.print(label + " [" + safeValue(defaultValue) + "]: ");
    String raw = scanner.nextLine().trim();
    if (raw.isEmpty()) {
      return new ArrayList<>(defaultValue == null ? new ArrayList<>() : defaultValue);
    }
    return parseIdList(raw, label);
  }

  private static List<Integer> parseIdList(String raw, String label) {
    String[] parts = raw.split(",");
    List<Integer> ids = new ArrayList<>();
    for (String part : parts) {
      String value = part.trim();
      if (value.isEmpty()) {
        continue;
      }
      try {
        int id = Integer.parseInt(value);
        if (id <= 0) {
          throw new IllegalArgumentException(label + " must contain positive numbers only.");
        }
        ids.add(id);
      } catch (NumberFormatException exception) {
        throw new IllegalArgumentException(label + " must contain valid numbers.");
      }
    }
    return ids;
  }

  private static void ensureAuthorExists(Context context, int authorId) {
    if (!context.authorService.authorExists(authorId)) {
      throw new IllegalArgumentException("Author not found");
    }
  }

  private static void ensureGenreExists(Context context, int genreId) {
    if (!context.masterDataService.genreExists(genreId)) {
      throw new IllegalArgumentException("Genre not found");
    }
  }

  private static void ensureCategoryExists(Context context, int categoryId) {
    if (!context.masterDataService.categoryExists(categoryId)) {
      throw new IllegalArgumentException("Category not found");
    }
  }

  private static void ensureLibraryExists(Context context, int libraryId) {
    if (!context.libraryService.libraryExists(libraryId)) {
      throw new IllegalArgumentException("Library not found");
    }
  }

  private static void ensureBranchExists(Context context, int branchId) {
    if (!context.libraryService.branchExists(branchId)) {
      throw new IllegalArgumentException("Branch not found");
    }
  }

  private static void ensureBookExists(Context context, int bookId) {
    if (!context.bookService.bookExists(bookId)) {
      throw new IllegalArgumentException("Book not found");
    }
  }

  private static void ensurePatronExists(Context context, int patronId) {
    if (!context.patronService.patronExists(patronId)) {
      throw new IllegalArgumentException("Patron not found");
    }
  }

  private static void ensureInventoryExists(Context context, int branchId, int bookId) {
    if (!context.inventoryService.hasLibraryBook(branchId, bookId)) {
      throw new IllegalArgumentException("Inventory record not found for branch " + branchId + " and book " + bookId);
    }
  }

  private static void ensurePatronlessInventorySlot(Context context, int branchId, int bookId) {
    if (context.inventoryService.hasLibraryBook(branchId, bookId)) {
      throw new IllegalArgumentException(
          "Inventory record already exists for branch " + branchId + " and book " + bookId);
    }
  }

  private static void ensureGenreIdsExist(Context context, List<Integer> genreIds) {
    for (Integer genreId : genreIds) {
      ensureGenreExists(context, genreId);
    }
  }

  private static void ensureCategoryIdsExist(Context context, List<Integer> categoryIds) {
    for (Integer categoryId : categoryIds) {
      ensureCategoryExists(context, categoryId);
    }
  }

  private static String safeValue(Object value) {
    return value == null ? "none" : String.valueOf(value);
  }
}

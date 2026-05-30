# Library Module

This folder contains the standalone `com.library` console application for managing:

- libraries and branches
- authors, genres, and categories
- books and branch inventory
- patrons, borrowing, and reservations
- notifications for borrowing and reservation events

## Package Overview

- `entity` - domain objects and value holders
- `repository` - in-memory data access layer
- `service` - business logic and validation orchestration
- `validators` - input validation rules
- `enums` - shared enum types
- `utils` - helper utilities such as ID generation
- `exception` - custom exception types
- `seeder` - optional bootstrap data

## Class Diagram

The diagram below shows the main relationships inside the `com.library` module only.

```text
┌──────────────────────────────────────────────────────────────────────────────┐
│                                  App                                         │
└──────────────────────────────────────────────────────────────────────────────┘
   │
   ├──> AuthorService ───> AuthorRepository
   ├──> MasterDataService ─> MasterDataRepository
   ├──> LibraryService ───> LibraryRepository
   ├──> BookService ──────> BookRepository
   ├──> InventoryService ──> InventoryRepository
   ├──> PatronService ─────> PatronRepository
   ├──> BorrowingService ──> BorrowingRepository
   │          │              ├──> ReservationRepository
   │          │              └──> InventoryService
   │          └──────────────> NotificationService
   ├──> ReservationService ─> ReservationRepository
   │          │              ├──> InventoryService
   │          │              └──> NotificationService
   └──> NotificationService ─> Notifier
                             ├──|> EmailNotifier
                             └──|> SMSNotifier

ENTITY RELATIONSHIPS

┌──────────┐      1    *      ┌──────────┐
│ Library  │──────────────────│ Branch   │
└──────────┘                  └──────────┘
                                   │
                                   │ 1
                                   │
                                   * 
                             ┌────────────┐
                             │ LibraryBook│
                             └────────────┘
                             ▲            ▲
                             │            │
                         ┌────┴───┐   ┌────┴───┐
                         │  Book   │   │ Branch │
                         └─────────┘   └────────┘

┌──────────┐      1    *      ┌──────────┐
│ Author   │──────────────────│ Book     │
└──────────┘                  └──────────┘
                                   │
                                   ├──────> Genre
                                   └──────> Category

┌──────────┐      1    *      ┌────────────┐
│ Patron   │──────────────────│ Borrowing  │
└──────────┘                  └────────────┘
                                   ▲
                                   │
                          ┌────────┼────────┐
                          │        │        │
                       Branch    Book    Patron

┌──────────┐      1    *      ┌────────────┐
│ Patron   │──────────────────│ Reservation│
└──────────┘                  └────────────┘
                                   ▲
                                   │
                          ┌────────┼────────┐
                          │        │        │
                       Branch    Book    Patron
```

## Notes

- `LibraryBook` acts as the inventory link between a `Branch` and a `Book`.
- `BorrowingService` and `ReservationService` both coordinate inventory changes and notifications.
- `NotificationService` broadcasts messages through the notifier implementations.

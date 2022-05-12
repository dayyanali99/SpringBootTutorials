package com.springboottutorials.springboottutorials.web.rest;

import com.springboottutorials.springboottutorials.entity.Book;
import com.springboottutorials.springboottutorials.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor // Automatically makes a constructor with bookService para and Autowires it.
public class BookController
{
    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> bookList = this.bookService.getAllBooks();
        if (bookList.size() <= 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(bookList));
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") int id)
    {
        Book book = this.bookService.getBookById(id);
        // Setting response code
        Optional<Book> bookOptional = Optional.ofNullable(book);
        if (bookOptional.isPresent())
            return ResponseEntity.of(bookOptional);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        Book savedBook = this.bookService.addBook(book);
        if (savedBook != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int id)
    {
        this.bookService.deleteBook(id);
        if (this.bookService.bookExistsById(id))
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable("bookId") int id)
    {
        Book updatedBook = this.bookService.updateBook(book,id);
        return ResponseEntity.of(Optional.of(updatedBook));
    }
}

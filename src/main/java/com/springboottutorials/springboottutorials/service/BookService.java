package com.springboottutorials.springboottutorials.service;

import com.springboottutorials.springboottutorials.dao.BookRepository;
import com.springboottutorials.springboottutorials.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService
{
    public final BookRepository bookRepository;

    public List<Book> getAllBooks()
    {

        return this.bookRepository.findAll();
    }

    public Book addBook(Book book)
    {
        return this.bookRepository.save(book);
    }

    public Book getBookById(int id)
    {
//        Optional<Book> book = BOOK_LIST.stream().filter(b->b.getId()==id).findFirst();
//        return book.orElse(null);

        return this.bookRepository.findById(id);
    }

    public void deleteBook(int id)
    {
//        return BOOK_LIST.removeIf(book -> book.getId() == id);
        this.bookRepository.deleteBookById(id);
    }

    public Book updateBook(Book paraBook, int id)
    {
//        for (Book book : BOOK_LIST)
//        {
//            if (book.getId() == id)
//            {
//                BOOK_LIST.set(BOOK_LIST.indexOf(book),paraBook);
//                return paraBook;
//            }
//        }
//        return null;

        Book bookToUpdate = this.bookRepository.findById(id);
        bookToUpdate.setId(id);
        bookToUpdate.setTitle(paraBook.getTitle());
        bookToUpdate.setAuthor(paraBook.getAuthor());
        return this.bookRepository.save(bookToUpdate);
    }

    public boolean bookExistsById(int id)
    {
        return this.bookRepository.existsBookById(id);
    }
}

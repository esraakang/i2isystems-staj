package com.example.bookapi.controller;

import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.exception.BookNotFoundException;
import com.example.bookapi.exception.BookIdMismatchException;

import jakarta.validation.Valid;  // Validasyon için
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated; // Validasyon için
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Validated  // Validasyon aktif et
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@Valid @RequestBody Book book) { // @Valid eklendi
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }





    @PutMapping("/{id}")
    public Book updateBook(@Valid @RequestBody Book book, @PathVariable Long id) {
        if (!Long.valueOf(book.getId()).equals(id)) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }


}

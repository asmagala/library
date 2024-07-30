package com.kodilla.library.controller;

import com.kodilla.library.domain.BookDto;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    @GetMapping
    public List<BookDto> getBooks() {
        return BookMapper.toBookDtoList(service.getBooks());
    }

    @PostMapping
    public void createBook(@RequestBody BookDto bookDto) {
        service.createBook(BookMapper.toBook(bookDto));
    }

    @DeleteMapping
    public void deleteBook(@PathVariable("index") int index) {
        service.deleteBook(index);
    }
}

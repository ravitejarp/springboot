package com.ravi.spring.springboot.controllers;

import com.ravi.spring.springboot.dao.entities.Book;
import com.ravi.spring.springboot.dao.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    private BookRepository bookRepository;

    @Autowired
    public ReadingListController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping(value="/{reader}")
    public String readers(@PathVariable("reader") String reader, Model model){
        List<Book> readingList = bookRepository.findByReader(reader);
        if(readingList != null){
            model.addAttribute("books",readingList);
        }
        return "readingList";
    }

    @PostMapping(value = "/{reader}")
    public String updateReader(@PathVariable("reader") String reader,Book book){
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/{reader}";


    }
}

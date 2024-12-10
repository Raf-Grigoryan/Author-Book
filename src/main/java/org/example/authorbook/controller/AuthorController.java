package org.example.authorbook.controller;

import org.example.authorbook.entity.Author;
import org.example.authorbook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public String getAuthorPage(ModelMap modelMap) {
        modelMap.addAttribute("authors", authorRepository.findAll());
        return "author";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorRepository.deleteById(id);
        return "redirect:/author";
    }

    @GetMapping("/add")
    public String addAuthor() {
        return "addAuthor";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute("author") Author author) {
        System.out.println(author);
        authorRepository.save(author);
        return "redirect:/author";
    }
}

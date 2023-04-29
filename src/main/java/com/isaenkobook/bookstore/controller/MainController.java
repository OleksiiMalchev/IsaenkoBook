package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.BookMeta;
import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import com.isaenkobook.bookstore.service.BookMetaService;
import com.isaenkobook.bookstore.service.BookService;
import com.isaenkobook.bookstore.service.CartService;
import com.isaenkobook.bookstore.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private ResourceBundleMessageSource messageSource;
    @Autowired
    private BookMetaService bookMetaService;

    @Autowired
    private BookService bookService;




    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        return "main_new";
    }

    @GetMapping("/change-locale")
    public String changeLocale(@RequestParam("locale") String locale,HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        messageSource.setBasename(locale);
        return "redirect:"+referer;
    }

    @GetMapping("/book-page")
    public String bookPage(@RequestParam("article") String article,Model model) {
        Set<String> basenameSet = messageSource.getBasenameSet();
        String locale = basenameSet.iterator().next();
        BookMeta byArticle = bookMetaService.findByArticleAndLocale(article,locale);
        model.addAttribute("image",byArticle);
        List<BookRespDTO> ukrainian = bookService.findBooksByLangAndArticle("UKRAINIAN", article);
        model.addAttribute("ukrainian",ukrainian);
        List<BookRespDTO> russian = bookService.findBooksByLangAndArticle("RUSSIAN", article);
        model.addAttribute("russian",russian);
        List<BookRespDTO> english = bookService.findBooksByLangAndArticle("ENGLISH", article);
        model.addAttribute("english",english);
        return "book_page_test";
    }

}

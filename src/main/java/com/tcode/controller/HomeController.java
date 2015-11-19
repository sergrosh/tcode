package com.tcode.controller;

import com.tcode.common.PaginationBean;
import com.tcode.persistence.model.Note;
import com.tcode.persistence.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sergey on 11/20/2015.
 */
@Controller
public class HomeController {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private PaginationBean paginationBean;

    @RequestMapping(Mappings.NOTES + "/{pageNum}.page")
    public ModelAndView load(@PathVariable int pageNum) {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.HOME);
        Page<Note> page = noteRepository.findAll(paginationBean.defaultPageable(pageNum - 1));
        modelAndView.addObject("page", page);
        return modelAndView;
    }

    @RequestMapping(Mappings.INDEX_PAGE)
    public ModelAndView homePage() {
        return load(1);
    }

    @ModelAttribute("notes")
    public Iterable<Note> allNotes() {
        return noteRepository.findAll();

    }

    @RequestMapping("/error.page")
    public String error() {
        return TilesDefinition.ERROR_PAGE;
    }
}

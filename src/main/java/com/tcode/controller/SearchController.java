package com.tcode.controller;

import com.tcode.common.PaginationBean;
import com.tcode.persistence.repository.NoteRepository;
import com.tcode.service.SearchService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sroshchupkin on 20/11/15.
 */

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private PaginationBean paginationBean;

    @RequestMapping(Mappings.SEARCH_PAGE)
    public ModelAndView search(@RequestParam("q") String q,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNum) {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.HOME);
        if (StringUtils.isEmpty(q)) {
            modelAndView.addObject("page", noteRepository.findAll(paginationBean.defaultPageable(pageNum - 1)));
            return modelAndView;
        } else {
            modelAndView.addObject("page", searchService.search(q, paginationBean.defaultPageable(pageNum - 1)));
            modelAndView.addObject("searchString", q);
        }

        return modelAndView;
    }
}


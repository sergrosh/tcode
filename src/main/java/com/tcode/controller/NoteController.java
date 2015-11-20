package com.tcode.controller;

import com.tcode.common.Constants;
import com.tcode.persistence.model.Note;
import com.tcode.persistence.repository.NoteRepository;
import com.tcode.validator.NoteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * Created by Sergey Roshchupkin on 11/20/2015.
 */
@Controller
public class NoteController extends AbstractController {
    @Autowired
    private NoteValidator noteValidator;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private HomeController homeController;

    @RequestMapping(Mappings.NOTE_CREATE_PAGE)
    public ModelAndView createNote() {
        return new ModelAndView(TilesDefinition.CREATE_NOTE);
    }

    @RequestMapping(Mappings.NOTE_VIEW_PAGE)
    public ModelAndView preview(@RequestParam(value = Constants.ID_PARAM, required = true) String id) {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.PREVIEW_NOTE);
        modelAndView.addObject("note", noteRepository.findOne(id));
        return modelAndView;
    }

    @RequestMapping(Mappings.NOTE_EDIT_PAGE)
    public ModelAndView edit(@RequestParam(value = Constants.ID_PARAM, required = true) String id) {
        ModelAndView modelAndView = new ModelAndView(TilesDefinition.CREATE_NOTE);
        modelAndView.addObject("note", noteRepository.findOne(id));
        return modelAndView;
    }

    @RequestMapping(value = Mappings.NOTE_CREATE_DO, method = RequestMethod.POST)
    public ModelAndView save(Note note) {
        Map<String, String> errorsMap = noteValidator.isValid(note);
        if (errorsMap.isEmpty()) {
            noteRepository.save(note);
            ModelAndView view = new ModelAndView(TilesDefinition.CREATE_NOTE);
            view.addObject(note);
            view.addObject("success", true);
            return view;
        } else {
            ModelAndView view = new ModelAndView(TilesDefinition.CREATE_NOTE);
            view.addObject(note);
            view.addObject("errorsMap", errorsMap);
            return view;
        }
    }

    @RequestMapping(Mappings.ADMIN_DELETE_NOTE_DO)
    public ModelAndView deleteNote(@RequestParam String noteId) {
        noteRepository.delete(noteId);
        return homeController.load(1);
    }
}

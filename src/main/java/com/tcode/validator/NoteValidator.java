package com.tcode.validator;

import com.tcode.persistence.model.Link;
import com.tcode.persistence.model.Note;
import org.apache.commons.validator.UrlValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sergey on 11/20/2015.
 */
@Component
public class NoteValidator {

    public Map<String, String> isValid(Note note) {

        Map<String, String> errors = new HashMap<>();

        if (StringUtils.isEmpty(note.getTitle())) {
            errors.put("Note title", "is required!");
        }

        if (note.getTags() == null || note.getTags().isEmpty()) {
            errors.put("Tags", "is required! Enter at least one tag.");
        }
        if (note.getUsefulLinks() != null && !note.getUsefulLinks().isEmpty()) {
            Set<Link> usefulLinks = note.getUsefulLinks();
            UrlValidator urlValidator = new UrlValidator();

            for (Link link : usefulLinks) {
                if (!urlValidator.isValid(link.getUrl())) {
                    errors.put("Url " + link.getUrl(), "is not valid url!");
                }
            }
        }

        return errors;
    }
}


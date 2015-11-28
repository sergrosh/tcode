package com.tcode.web;

import com.tcode.persistence.model.Link;
import com.tcode.persistence.model.Note;
import com.tcode.persistence.model.Snippet;
import com.tcode.util.SecurityUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sergey on 11/25/2015.
 */
@Component
public class NoteArgumentResolver extends AbstractHandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Note.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        Note note = new Note();
        note.setId(getTrimmedParameter(webRequest, NOTE_ID));
        note.setTitle(getTrimmedParameter(webRequest, NOTE_TITLE));
        note.setDescription(getTrimmedParameter(webRequest, NOTE_DESCRIPTION));
        note.setTags(obtainTags(webRequest));
        note.setUsefulLinks(obtainLinks(webRequest));
        note.setUsername(SecurityUtils.getLoggedUser().getUsername());

        List<Snippet> snippets = obtainSnippets(webRequest);
        note.setSnippets(snippets);

        return note;
    }

    private Set<Link> obtainLinks(NativeWebRequest webRequest) {
        String linksCountStr = getTrimmedParameter(webRequest, LINKS_COUNT);
        if (StringUtils.isNumeric(linksCountStr)) {
            int count = Integer.parseInt(linksCountStr);
            Set<Link> links = new HashSet<>();
            for (int i = 0; i <= count; i++) {
                String linkUrl = getTrimmedParameter(webRequest, LINK_URL + i);
                if (StringUtils.isNotEmpty(linkUrl)) {
                    Link link = new Link();
                    link.setTitle(getTrimmedParameter(webRequest, LINK_TITLE + i));
                    link.setUrl(linkUrl);
                    links.add(link);
                }
            }
            return links;
        } else {
            throw new IllegalArgumentException("Something is going wrong! Links count not a number! = " + linksCountStr);
        }
    }

    private Set<String> obtainTags(NativeWebRequest webRequest) {
        String tags = getTrimmedParameter(webRequest, NOTE_TAGS);
        if (StringUtils.isNotEmpty(tags)) {
            HashSet<String> tagsSet = new HashSet<>();
            for (String tag : tags.split(",")) {
                tagsSet.add(tag.trim());
            }
            return tagsSet;
        } else {
            throw new IllegalStateException("Tags should be here! = " + tags);
        }
    }

    private List<Snippet> obtainSnippets(NativeWebRequest webRequest) {
        String snippetsCountStr = getTrimmedParameter(webRequest, SNIPPETS_COUNT);
        if (StringUtils.isNumeric(snippetsCountStr)) {
            int count = Integer.parseInt(snippetsCountStr);
            List<Snippet> snippets = new ArrayList<>();
            for (int i = 0; i <= count; i++) {
                String snippetCode = getTrimmedParameter(webRequest, SNIPPET_CODE + i);
                if (StringUtils.isNotEmpty(snippetCode)) {
                    Snippet snippet = new Snippet();
                    snippet.setTitle(getTrimmedParameter(webRequest, SNIPPET_TITLE + i));
                    snippet.setDescription(getTrimmedParameter(webRequest, SNIPPETS_DESCRIPTION + i));
                    snippet.setCode(snippetCode);
                    snippet.setXtype(getTrimmedParameter(webRequest, SNIPPETS_LANGUAGE + i).split("=")[1]);
                    snippets.add(snippet);
                }
            }
            return snippets;
        } else {
            throw new IllegalArgumentException("Something is going wrong! Snippets count not a number! = " + snippetsCountStr);
        }
    }
}


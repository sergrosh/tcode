package com.tcode.persistence.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

/**
 * Created by Sergey Roshchupkin on 10/11/15.
 */
@Document
public class Note extends BaseModel {

    private String title;
    private String description;
    private List<Snippet> snippets;
    private String username;
    private NoteType noteType = NoteType.PUBLIC;
    @Indexed
    private Set<String> tags;
    private Set<Link> usefulLinks;

    public Set<Link> getUsefulLinks() {
        return usefulLinks;
    }

    public void setUsefulLinks(Set<Link> usefulLinks) {
        this.usefulLinks = usefulLinks;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Snippet> getSnippets() {
        return snippets;
    }

    public void setSnippets(List<Snippet> snippets) {
        this.snippets = snippets;
    }
}

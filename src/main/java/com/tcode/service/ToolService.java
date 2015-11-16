package com.tcode.service;

import com.tcode.persistence.model.Tool;
import com.tcode.persistence.repository.tool.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by sroshchupkin on 16/11/15.
 */
@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> findPublished() {
        return toolRepository.findByPublished(true);
    }

    public List<Tool> findUnpublished() {
        return toolRepository.findByPublished(false);
    }

    public Set<String> findPublishedCategories() {
        return toolRepository.findCategories(true);
    }

    public Set<String> findUnpublishedCategories() {
        return toolRepository.findCategories(false);
    }
}

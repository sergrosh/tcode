package com.tcode.service;

import com.tcode.persistence.model.Technology;
import com.tcode.persistence.repository.technology.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by sroshchupkin on 16/11/15.
 */
@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    public List<Technology> findPublished() {
        return technologyRepository.findByPublished(true);
    }

    public List<Technology> findUnpublished() {
        return technologyRepository.findByPublished(false);
    }

    public Set<String> findPublishedCategories() {
        return technologyRepository.findCategories(true);
    }

    public Set<String> findUnpublishedCategories() {
        return technologyRepository.findCategories(false);
    }
}

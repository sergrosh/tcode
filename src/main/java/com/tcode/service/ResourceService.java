package com.tcode.service;

import com.tcode.persistence.model.Resource;
import com.tcode.persistence.repository.resource.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by sroshchupkin on 16/11/15.
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> findPublished() {
        return resourceRepository.findByPublished(true);
    }

    public List<Resource> findUnpublished() {
        return resourceRepository.findByPublished(false);
    }

    public Set<String> findPublishedCategories() {
        return resourceRepository.findCategories(true);
    }

    public Set<String> findUnpublishedCategories() {
        return resourceRepository.findCategories(false);
    }
}

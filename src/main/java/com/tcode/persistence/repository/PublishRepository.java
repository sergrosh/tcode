package com.tcode.persistence.repository;

/**
 * Created by Sergey on 11/11/2015.
 */

import com.tcode.persistence.model.PublishModel;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public interface PublishRepository<T extends PublishModel, D extends Serializable> extends Repository<T, D> {

    List<T> findByPublished(Boolean isPublished);
}

package com.tcode.persistence.repository.technology;


import com.tcode.persistence.model.Technology;
import com.tcode.persistence.repository.PublishRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergey on 11/15/2015.
 */
@Repository
public interface TechnologyRepository extends CrudRepository<Technology , String>, PublishRepository<Technology, String>, TechnologyRepositoryCustom {
}

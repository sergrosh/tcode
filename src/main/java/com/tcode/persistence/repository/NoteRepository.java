package com.tcode.persistence.repository;

import com.tcode.persistence.model.Note;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergey Roshchupkin on 11/11/2015.
 */
@Repository
public interface NoteRepository extends PagingAndSortingRepository<Note, String> {
}
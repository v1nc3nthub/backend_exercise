package com.skylabs.exercise.service;

import com.skylabs.exercise.entities.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecordService extends PagingAndSortingRepository<Record, Long> {
    Page<Record> findAll(Pageable p);
}

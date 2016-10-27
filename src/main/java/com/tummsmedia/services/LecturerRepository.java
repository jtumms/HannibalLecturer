package com.tummsmedia.services;

import com.tummsmedia.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by john.tumminelli on 10/26/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
    Lecturer findById(int id);


}


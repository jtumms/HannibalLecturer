package com.tummsmedia.services;

import com.tummsmedia.entities.Lecturer;
import com.tummsmedia.entities.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by john.tumminelli on 10/26/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    Iterable<Review> findBylecturerId(int id);
}

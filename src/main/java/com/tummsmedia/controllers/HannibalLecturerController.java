package com.tummsmedia.controllers;
import com.tummsmedia.entities.Lecturer;
import com.tummsmedia.entities.Review;
import com.tummsmedia.services.LecturerRepository;
import com.tummsmedia.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

/*
Routes taken from app.js
url: {
        getLecturer: "/lecturers",
        createLecturer: "/lecturers",
        reviews: '/reviews?lecturerId=',
        createReview: '/reviews'
*/

/**
 * Created by john.tumminelli on 10/26/16.
 */

@RestController

@Controller
public class HannibalLecturerController {

    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    Server h2Server;

    @PostConstruct
    public void init() throws SQLException {
        h2Server = Server.createWebServer().start();

    }

    @PreDestroy
    public void destroy() {
        h2Server.stop();
    }
    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public Lecturer createLecturer(String name, String topic, String image) {
        Lecturer l = new Lecturer(name, topic, image);
        return lecturers.save(l);
    }
    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> getLecturers() {
        return lecturers.findAll();
    }
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public Review createReview(String author, String text, boolean isGood, Integer lecturerId) {
        Lecturer lecturer = lecturers.findById(lecturerId);
        Review rev = new Review(author, text, isGood, lecturer);
        return reviews.save(rev);
    }
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> getReviews(Integer lecturerId) {
        return reviews.findBylecturerId(lecturerId);

    }

}

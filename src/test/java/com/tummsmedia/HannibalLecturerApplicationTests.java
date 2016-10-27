package com.tummsmedia;

import com.tummsmedia.services.LecturerRepository;
import com.tummsmedia.services.ReviewRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HannibalLecturerApplicationTests {


	@Autowired
	ReviewRepository reviews;

	@Autowired
	LecturerRepository lecturers;

	@Autowired
	WebApplicationContext wac;

	MockMvc mockMvc;

	@Before
	public void before(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

//	String name, String topic, String image
	@Test
	public void aTestCreateLecturer() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/lecturers")
						.param("name", "Barney")
						.param("topic", "Astronomy")
						.param("image", "http://www.physics.rutgers.edu/ast/m31_sm.jpeg")
		);
		Assert.assertTrue(lecturers.count() == 1);
	}
//	String author, String text, boolean isGood, Integer lecturerId
	@Test
	public void bTestCreateReview() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/reviews")
				.param("author", "Mickey Mouse")
				.param("text", "This is a test of Create Review")
				.param("isGood", "true")
				.param("lecturerId", "2")

		);
		Assert.assertTrue(reviews.count() == 1);
	}


}

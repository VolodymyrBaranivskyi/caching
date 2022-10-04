package com.interview.caching;

import com.interview.caching.daos.interfaces.StreetDao;
import com.interview.caching.logic.services.StreetService;
import com.interview.caching.model.Street;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CachingApplicationTests {

	@Autowired
	private StreetService service;

	@Autowired
	private StreetDao streetDao;

	@Test
	void contextLoads() {
	}

	@Test
	public void get() {
		Street street1 = service.save("oneStreet");

		Assert.assertEquals (("oneStreet"), street1.getName());

	}


}

/**
 * 
 */
package com.oooffers.web.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oooffers.web.model.HotelOffersModel;
import com.oooffers.web.model.HotelOffersWrapper;

/**
 * @author Zrieq
 * 
 */

//TODO Add all needed test cases.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/root-context.xml" })
public class OooffersServiceTest {

	@Resource
	private OooffersService oooffersService;

	@Test
	public void testGetHotelOffers() {
	}
	
	@Test
	public void testGetHotelOffersWithEmptyDates() {
		try {
			HotelOffersModel hotelOffers = oooffersService.getHotelOffers(new HotelOffersWrapper());
			Assert.assertNotNull("HotelOffers is not null.", hotelOffers);
		} catch (Exception e) {
			Assert.fail("Unexpected error happened. e.message()" + e.getMessage());
		}
	}
}

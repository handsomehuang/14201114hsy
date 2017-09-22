package com.nchu.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.nchu.controller.HomeController;


public class HomeControllerTest {
	
	
	@Test
	public void testHome() {
		HomeController controller = new HomeController();
		assertEquals("index", controller.home());
	}
}

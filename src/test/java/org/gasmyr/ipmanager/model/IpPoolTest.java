package org.gasmyr.ipmanager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IpPoolTest {

	private IpPool objectToTest;

	@Test
	public void newInstance() {

		objectToTest = new IpPool("First pool", 30, 0, "192.168.1.7", "192.168.1.254");

		assertEquals(0, objectToTest.getTotalCapacity());
		assertEquals(0, objectToTest.getUseCapacity());
	}

}

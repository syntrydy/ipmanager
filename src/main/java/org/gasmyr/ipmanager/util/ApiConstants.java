package org.gasmyr.ipmanager.util;

public class ApiConstants {

	private ApiConstants() {
	}

	public static final String BASE_API_URL = "/api/v1";
	public static final String RESERVE = "/reserve";
	public static final String DYNAMIC_IP = "/dynamic";
	public static final String STATIC_IP = "/static";
	public static final String BLACKLIST_IP = "/blacklist";
	public static final String FREE_IP = "/free";
	public static final String RETRIVE_IP_RESOURCE = "/retrieve";

	// constants for JSON field
	public static final String ID = "id";
	public static final String DESCRIPTION = "description";
	public static final String USED_CAPACITY = "usedCapacity";
	public static final String TOTAL_CAPACITY = "totalCapacity";
	public static final String LOWER_BOUND = "lowerBound";
	public static final String UPPER_BOUND = "upperBound";

	//
	public static final String QUANTITY = "quantity";

}

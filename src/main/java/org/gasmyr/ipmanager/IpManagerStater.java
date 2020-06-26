package org.gasmyr.ipmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.gasmyr.ipmanager.model.IpPool;
import org.gasmyr.ipmanager.service.IpPoolService;
import org.gasmyr.ipmanager.util.ApiConstants;
import org.gasmyr.ipmanager.util.IpAddressUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class IpManagerStater {

	@Inject
	Logger logger;

	@Inject
	IpPoolService ipPoolService;

	void onStart(@Observes StartupEvent ev) {
		logger.info("=================================================================");
		logger.info("=============  STARTING API APPLICATION  ========================");
		logger.info("=================================================================");
		saveSampleDataInDb();
		logger.info("=================================================================");
		logger.info("==============  APPLICATION IS UP AND RUNNING ===================");
		logger.info("=================================================================");
	}

	@SuppressWarnings("unchecked")
	private void saveSampleDataInDb() {
		logger.info("======== Starting loading data into db ============");
		JSONParser jsonParser = new JSONParser();
		try {
			File file = new File(getClass().getClassLoader().getResource("ip-pools.json").getFile());
			Object object = jsonParser.parse(new FileReader(file));
			JSONArray ipPools = (JSONArray) object;
			Iterator<JSONObject> iterator = ipPools.iterator();
			while (iterator.hasNext()) {
				JSONObject entry = iterator.next();
				String lowerBound = (String) entry.get(ApiConstants.LOWER_BOUND);
				String upperBound = (String) entry.get(ApiConstants.UPPER_BOUND);
				IpPool ipPool = new IpPool(String.valueOf(entry.get(ApiConstants.DESCRIPTION)),
						IpAddressUtil.getTotalCapacity(lowerBound, upperBound),
						(Long) entry.get(ApiConstants.USED_CAPACITY), lowerBound, upperBound);
				ipPoolService.createIpPool(ipPool);
			}
			logger.info("======== Data loaded into db successfully ============");
		} catch (FileNotFoundException e) {
			logger.error("======== File not found ============", e);
		} catch (IOException e) {
			logger.error("", e);
		} catch (org.json.simple.parser.ParseException e) {
			logger.error("======== Error parsing the JSON file ============", e);
		}

	}

	void onStop(@Observes ShutdownEvent ev) {
		logger.info("================================================================");
		logger.info("===========  API APPLICATION STOPPED  ==========================");
		logger.info("================================================================");
	}

}

package org.gasmyr.ipmanager.service;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.gasmyr.ipmanager.model.IpPool;

@ApplicationScoped
public class IpPoolService {

	@Transactional
	public void createIpPool(IpPool ipPool) {
		if (ipPool != null) {
			ipPool.persist();
		}
	}

	public List<Inet4Address> reserveDynamicIps(int quantity) {
		
		List<IpPool> allPersons = IpPool.listAll();

		return new ArrayList<Inet4Address>();
	}
	
	public List<Inet4Address> reserveStaticIps(int quantity) {
		return new ArrayList<Inet4Address>();
	}

}

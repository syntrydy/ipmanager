package org.gasmyr.ipmanager.util;

import inet.ipaddr.AddressStringException;
import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressSeqRange;
import inet.ipaddr.IPAddressString;
import inet.ipaddr.IncompatibleAddressException;

public class IpAddressUtil {

	private IpAddressUtil() {

	}

	public static boolean bolongToRange(String lowerBound, String upperBound, String ipAddress)
			throws AddressStringException {
		IPAddress lower = new IPAddressString(lowerBound).toAddress();
		IPAddress upper = new IPAddressString(upperBound).toAddress();
		IPAddress address = new IPAddressString(ipAddress).toAddress();
		IPAddressSeqRange range = lower.toSequentialRange(upper);
		return range.contains(address);
	}

	public static int getTotalCapacity(String lowerBound, String upperBound) {
		IPAddress lower = null;
		IPAddress upper = null;
		try {
			lower = new IPAddressString(lowerBound).toAddress();
			upper = new IPAddressString(upperBound).toAddress();
		} catch (AddressStringException e) {
			e.printStackTrace();
		} catch (IncompatibleAddressException e) {
			e.printStackTrace();
		}
		IPAddressSeqRange range = lower.toSequentialRange(upper);
		return range.getCount().intValue();
	}
}

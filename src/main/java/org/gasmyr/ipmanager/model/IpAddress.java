package org.gasmyr.ipmanager.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

public class IpAddress {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

	private long poolId;

	private State state = State.FREE;

	@Column(name = "value")
	private String value;

	public IpAddress() {
	}

	public IpAddress(long poolId, State state, String value) {
		super();
		this.poolId = poolId;
		this.state = state;
		this.value = value;
	}

	public long getPoolId() {
		return poolId;
	}

	public void setPoolId(long poolId) {
		this.poolId = poolId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

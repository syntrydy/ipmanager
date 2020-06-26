package org.gasmyr.ipmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "IPPOOL")
public class IpPool extends PanacheEntity {

	public IpPool() {
	}

	@Column(name = "description")
	private String description;

	@Column(name = "total_capacity")
	private long totalCapacity;

	@Column(name = "used_capacity")
	private long useCapacity;

	@Column(name = "lower_bound")
	private String lowerBound;

	@Column(name = "upper_found")
	private String upperBound;

	public IpPool(String description, long totalCapacity, long useCapacity, String lowerBound, String upperBound) {
		super();
		this.description = description;
		this.totalCapacity = totalCapacity;
		this.useCapacity = useCapacity;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public long getUseCapacity() {
		return useCapacity;
	}

	public void setUseCapacity(int useCapacity) {
		this.useCapacity = useCapacity;
	}

	public String getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(String lowerBound) {
		this.lowerBound = lowerBound;
	}

	public String getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}

	public void increaseUsedCapacity(int quantity) {
		this.useCapacity += quantity;
	}

	public void decreaseUsedCapacity(int quantity) {
		this.useCapacity -= quantity;
	}

	public boolean isDynamic() {
		return this.description.contains("Dynamic");
	}

}

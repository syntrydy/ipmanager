package org.gasmyr.ipmanager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "RESERVATION")
public class Reservation extends PanacheEntity{

	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "reservation_date")
	@Temporal(value = TemporalType.DATE)
	private Date date = new Date();
}

package com.training.project.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int publishId;
	private String name;

	public Publisher() {
		super();

	}
	public Publisher(String name) {
		super();
		this.name = name;
	}

	public int getPublishId() {
		return publishId;
	}

	public void setPublishId(int publishId) {
		this.publishId = publishId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Publisher [publishId=" + publishId + ", name=" + name + "]";
	}

}

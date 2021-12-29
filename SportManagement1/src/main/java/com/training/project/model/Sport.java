package com.training.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Sport {



	@Override
	public String toString() {
		return "Sport [sportId=" + sportId + ", sportName=" + sportName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sport_id")
	private int sportId;
	private String sportName;

	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name = "country_sport",
			joinColumns = @JoinColumn(name = "sport_id"),
			inverseJoinColumns = @JoinColumn(name = "country_id")
			)
	List<Country> countries ;

	public Sport() {
		super();

	}

	public Sport(String sportName) {
		super();
		this.sportName = sportName;
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public void addCountry(Country tempCountry) {
		if(countries == null) {

			countries = new ArrayList<Country>();

		}
		countries.add(tempCountry);
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}

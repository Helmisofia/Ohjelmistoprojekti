package sportslist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Action {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long actionid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "action")
	private List<Sport> sports;

	public Action() {
		
	}

	public Action(String name) {
		super();
		this.name = name;
	}

	public Long getActionid() {
		return actionid;
	}

	public void setActionid(Long actionid) {
		this.actionid = actionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "Action [actionid=" + actionid + ", name=" + name + "]";
	}

}
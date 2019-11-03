package sportslist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String place;
	private String exercise;
	private String date;
	private int minutes;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "actionid")
    private Action action;
	
	public Sport() {
		
	}

	public Sport(String place, String exercise, String date, int minutes, Action action) {
		this.place = place;
		this.exercise = exercise;
		this.date = date;
		this.minutes = minutes;
		this.action = action;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public String toString() {
		if (this.action != null)
			return "Sport [id=" + id + ", place=" + place + ", exercise=" + exercise + ", date=" + date + ", minutes=" + minutes + ", action=" + action + "]";
		else
			return "Sport [id=" + id + ", place=" + place + ", exercise=" + exercise + ", date=" + date + ", minutes=" + minutes +"]";
	}
	
	
	
	
}
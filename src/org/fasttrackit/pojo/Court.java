package org.fasttrackit.pojo;

import java.util.ArrayList;

public class Court {

	private int id;
	private int courtNumber;
	private String courtSurface;
	private ArrayList<Reservation> reservationList;
	private String courtType;

	public String getCourtType() {
		return courtType;
	}

	public void setCourtType(String courtType) {
		this.courtType = courtType;
	}

	public Court(int id, int courtNumber) {
		super();
		this.id = id;
		this.courtNumber = courtNumber;
	}

	public Court() {
		super();
	}

	public Court(int id, int courtNumber, String courtSurface, ArrayList<Reservation> reservationList,
			String courtType) {
		super();
		this.id = id;
		this.courtNumber = courtNumber;
		this.courtSurface = courtSurface;
		this.reservationList = reservationList;
		this.courtType = courtType;
	}

	public Court(int id, int courtNumber, String courtSurface, String courtType) {
		super();
		this.id = id;
		this.courtNumber = courtNumber;
		this.courtSurface = courtSurface;
		this.courtType = courtType;
	}

	public int getCourtNumber() {
		return courtNumber;
	}

	public void setCourtNumber(int courtNumber) {
		this.courtNumber = courtNumber;
	}

	public String getCourtSurface() {
		return courtSurface;
	}

	public void setCourtSurface(String courtSurface) {
		this.courtSurface = courtSurface;
	}

	public ArrayList<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(ArrayList<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

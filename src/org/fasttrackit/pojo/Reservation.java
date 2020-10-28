package org.fasttrackit.pojo;

public class Reservation {
	private int id;
	private Court courtNumber;
	private int year;
	private int month;
	private int day;
	private int hourOfReservation;
	private int minuteOfReservation;

	private int hoursBooked;
	private Player p;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public Reservation(int id, Court courtNumber, int year, int month, int day, int hourOfReservation,
			int minuteOfReservation, int hoursBooked, Player p) {
		super();
		this.id = id;
		this.courtNumber = courtNumber;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hourOfReservation = hourOfReservation;
		this.minuteOfReservation = minuteOfReservation;
		this.hoursBooked = hoursBooked;
		this.p = p;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Reservation(int id, Court courtNumber, int hourOfReservation, int minuteOfReservation, int hoursBooked,
			Player p) {
		super();
		this.id = id;
		this.courtNumber = courtNumber;
		this.hourOfReservation = hourOfReservation;
		this.minuteOfReservation = minuteOfReservation;
		this.hoursBooked = hoursBooked;
		this.p = p;
	}

	public Reservation() {
		super();
	}

	public Reservation(int id, int hourOfReservation, int minuteOfReservation, int hoursBooked) {
		super();
		this.id = id;
		this.hourOfReservation = hourOfReservation;
		this.minuteOfReservation = minuteOfReservation;
		this.hoursBooked = hoursBooked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Court getCourtNumber() {
		return courtNumber;
	}

	public void setCourtNumber(Court courtNumber) {
		this.courtNumber = courtNumber;
	}

	public int getHourOfReservation() {
		return hourOfReservation;
	}

	public void setHourOfReservation(int hourOfReservation) {
		this.hourOfReservation = hourOfReservation;
	}

	public int getMinuteOfReservation() {
		return minuteOfReservation;
	}

	public void setMinuteOfReservation(int minuteOfReservation) {
		this.minuteOfReservation = minuteOfReservation;
	}

	public int getHoursBooked() {
		return hoursBooked;
	}

	public void setHoursBooked(int hoursBooked) {
		this.hoursBooked = hoursBooked;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

}

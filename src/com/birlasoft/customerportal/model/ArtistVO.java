package com.birlasoft.customerportal.model;
/*
 * Artist ValueObject class
 * constructor default and parameterized
 * getter and setter
 */


public class ArtistVO {
	private String artist_id;
	private String artist_name;
	private String address;
	
	public ArtistVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArtistVO(String artist_id, String artist_name, String address) {
		super();
		this.artist_id = artist_id;
		this.artist_name = artist_name;
		this.address = address;
	}
	public String getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ArtistVO [artist_id=" + artist_id + ", artist_name=" + artist_name + ", address=" + address + "]";
	}
	
	

}

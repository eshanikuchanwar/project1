package com.birlasoft.customerportal.model;
/*
 * painting valueObject Class
 *  constructor default and parameterized
 * getters and setters.
 * 
 */

public class paintingVO {
	private String PaintingId;
	private String paintingTitle;
	private String paintingType;
	private String ArtistId;
	private int price;
	
	
	public paintingVO() {
		super();
	}


	public paintingVO(String PaintingId, String paintingTitle, String paintingType, String ArtistId, 
			int price) {
		super();
		this.PaintingId =PaintingId;
		this.paintingTitle = paintingTitle;
		this.paintingType = paintingType;
		this.ArtistId = ArtistId;
		
		this.price = price;
	}


	public String getPaintingId() {
		return PaintingId;
	}


	public void setPaintingId(String paintingId) {
		PaintingId = paintingId;
	}


	public String getPaintingTitle() {
		return paintingTitle;
	}


	public void setPaintingTitle(String paintingTitle) {
		this.paintingTitle = paintingTitle;
	}


	public String getPaintingType() {
		return paintingType;
	}


	public void setPaintingType(String paintingType) {
		this.paintingType = paintingType;
	}


	
	
	public String getArtistId() {
		return ArtistId;
	}


	public void setArtistId(String artistId) {
		ArtistId = artistId;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "paintingVO [PaintingId=" + PaintingId + ", paintingTitle=" + paintingTitle + ", paintingType="
				+ paintingType + ", ArtistId=" + ArtistId + ", price=" + price + "]";
	}


	
}

package com.codeplanet.model;

import org.springframework.web.multipart.MultipartFile;

public class Guide {
	private String name;
	
	private String email;
	private String password;
	
	private String phone;
	private String city;
	private String hobby;
	private String places;
	private String about_tour;
	private int fee;
	private String[] languages;
	private String[] freeslots ;
	private MultipartFile image ;
	
	public Guide() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public String getPlaces() {
		return places;
	}


	public void setPlaces(String places) {
		this.places = places;
	}


	public String getAbout_tour() {
		return about_tour;
	}


	public void setAbout_tour(String about_tour) {
		this.about_tour = about_tour;
	}


	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}
	

	public String[] getLanguages() {
		return languages;
	}


	public void setLanguages(String[] languages) {
		this.languages = languages;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setFreeslots(String[] freeslots) {
		this.freeslots = freeslots;
	}


	public String[] getFreeslots() {
		return freeslots;
	}
	
	
	
}

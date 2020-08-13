package com.codeplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeplanet.dao.TouristDao;
import com.codeplanet.model.Booking;

@Service
public class TouristService {
@Autowired 
TouristDao touristDao ;
	public List<String> getGuideFreeslots(String day, String email) {
		return touristDao.getGuideInfoSlots(day ,email);
	}
	
	public boolean mapTouristToGudie(String guideEmail, String touristEmail, String date, String slot) {
		return touristDao.mapTouristToGudie(guideEmail,  touristEmail,  date,  slot);
	}
	public List<Booking> getRequestsToGuide(String guideEmail) {
		
		return touristDao.getRequestsToGuide(guideEmail);
	}

	public boolean deleteFromToBeMapped(Booking booking) {
		return touristDao.deleteFromToBeMapped(booking);
	}

	public boolean insertIntoMapped(Booking booking) {
		return touristDao.insertIntoMapped(booking);
	}
	
}

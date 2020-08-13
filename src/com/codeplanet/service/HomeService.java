package com.codeplanet.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeplanet.dao.HomeDao;
import com.codeplanet.model.Guide;
import com.codeplanet.model.User;

@Service
public class HomeService {
@Autowired 
HomeDao homeDao;


	public String checkInfo(User user)  throws SQLException {
		//System.out.println("just entered in service");
		return homeDao.checkInfo(user);
		//System.out.println("just exited from service");
	}


	public boolean insertInfo(User user) {
	
		return homeDao.insertInfo(user);
	}


	public List<Guide> getAllGuides() {
		
		return homeDao.getAllGuides();
	}


	public boolean insertGuideSignup(Guide guide) {
		return homeDao.insertGuideSignup(guide);
		
	}


	public boolean insertGuideForm(Guide guide) {
		return homeDao.insertGuideForm(guide);
		
	}


	public boolean insertLanguages(Guide guide) {
			return homeDao.insertLanguages(guide);
	}


	public boolean insertGuideSlots(Guide guide) {
		return homeDao.insertGuideSlots(guide);
	}



	public boolean checkInfo(Guide guide) {
		return homeDao.checkInfo(guide);
	}


	public Guide getGuideInfo(Guide guide) {
		
		Guide g1 = homeDao.getGuideInfoForm(guide);
		
		List<String> langList =  homeDao.getGuideInfoLanguage(guide);
		List<String> slotsList = homeDao.getGuideInfoSlots(guide);
		
		
		String [] lang = langList.toArray(new String [0]);
		
		
		g1.setLanguages(lang);
		
		String [] slots = slotsList.toArray(new String[0]);
		
		g1.setFreeslots(slots);
		
		return g1;
				
		
	}


	

}

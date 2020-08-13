package com.codeplanet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codeplanet.model.Booking;

@Repository
public class TouristDao {
@Autowired
JdbcTemplate jdbcTemplate;
	
	public List<String> getGuideInfoSlots(String day , String email) {
		List<String> listFree = new ArrayList<>();
		
		HashSet<String> hs = new HashSet<String>();
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			String query = "Select Slot from mapped where GuideEmail = ? and Date = ?";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			pst.setString(1,email);
			pst.setString(2,day);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				hs.add(rs.getString(1));
			}
			rs.close();
            pst.close();
            con.close();
		}
		catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pst!=null)
                    pst.close();
            }catch(SQLException se2){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		 List<String> listAll = getAllSlotsOfGuide(email);
		 
		 int sz = listAll.size();
		 for(int i=0;i<sz;i++) {
			 if(!hs.contains(listAll.get(i))) {
				 listFree.add(listAll.get(i));
			 }
		 }
		return listFree;

	}

	private List<String> getAllSlotsOfGuide(String email) {
		 List<String> hs = new ArrayList<String>();
		 
		 Connection con = null;
			PreparedStatement pst = null;
			
			try {
				String query = "Select FreeSlot from guidefreeslots where Email = ? ";
				con = jdbcTemplate.getDataSource().getConnection();
				pst = con.prepareStatement(query);
				
				pst.setString(1,email);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					hs.add(rs.getString(1));
				}
				rs.close();
	            pst.close();
	            con.close();
			}
			catch(SQLException se){
	            se.printStackTrace();
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(pst!=null)
	                    pst.close();
	            }catch(SQLException se2){
	            }
	            try{
	                if(con!=null)
	                    con.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
			
			return hs;
	}

	
	public boolean mapTouristToGudie(String guideEmail, String touristEmail, String date, String slot) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "insert into tobemapped (GuideEmail, TouristEmail,Date , Slot) VALUES (? , ? , ? ,? );";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			
			pst.setString(1,guideEmail);
			pst.setString(2, touristEmail);
			pst.setString(3,date);
			pst.setString(4,slot);
			
			int val= pst.executeUpdate();
			if(val>0) {
				System.out.println("Yes inserted successfully");
				return true;
				
			}
			
            pst.close();
            con.close();
		}
		catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pst!=null)
                    pst.close();
            }catch(SQLException se2){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		return false;

	}
	
	public List<Booking> getRequestsToGuide(String guideEmail) {
		List<Booking> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			String query = "Select GuideEmail, TouristEmail , Date , Slot from tobemapped where GuideEmail = ? ";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			pst.setString(1, guideEmail);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Booking book = new Booking();
				book.setGuideEmail(rs.getString(1));
				book.setTouristEmail(rs.getString(2));
				book.setDate(rs.getString(3));
				book.setSlot(rs.getString(4));
				list.add(book);
			}
			rs.close();
            pst.close();
            con.close();
		}
		catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pst!=null)
                    pst.close();
            }catch(SQLException se2){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		return list;

	}

	public boolean deleteFromToBeMapped(Booking booking) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "delete from tobemapped where GuideEmail=? and TouristEmail=? and Date=? and Slot=?";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			
			pst.setString(1, booking.getGuideEmail());
			pst.setString(2,booking.getTouristEmail());
			pst.setString(3,booking.getDate());
			pst.setString(4,booking.getSlot());
			
			int val= pst.executeUpdate();
			if(val>0) {
				System.out.println("Yes deleted successfully");
				return true;
				
			}
			
            pst.close();
            con.close();
		}
		catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pst!=null)
                    pst.close();
            }catch(SQLException se2){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		return false;

	}

	public boolean insertIntoMapped(Booking booking) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "insert into mapped (TouristEmail ,GuideEmail, Date , Slot) VALUES (? , ? , ? ,? );";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			
			pst.setString(1,booking.getTouristEmail());
			pst.setString(2, booking.getGuideEmail());
			pst.setString(3,booking.getDate());
			pst.setString(4,booking.getSlot());
			
			int val= pst.executeUpdate();
			if(val>0) {
				System.out.println("Yes inserted successfully");
				return true;
				
			}
			
            pst.close();
            con.close();
		}
		catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pst!=null)
                    pst.close();
            }catch(SQLException se2){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		return false;

	}

}

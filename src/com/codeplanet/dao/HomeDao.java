package com.codeplanet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codeplanet.model.Guide;
import com.codeplanet.model.User;
@Repository
public class HomeDao {
@Autowired
JdbcTemplate jdbcTemplate;

	public String checkInfo(User user) throws SQLException {
		//System.out.println("Im in the dao layer");
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "Select Name from signup_data where Email = ? and Password = ?";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1,user.getEmail());
			pst.setString(2, user.getPassword());
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				
				System.out.println("Yes login successfully");
				return rs.getString(1);
				
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
		
		return null;

	}

	public boolean insertInfo(User user) {
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			if(checkEmailExsistance(user.getEmail())) {
				return false;
			}
			String query = "insert into signup_data (Email,Password,Name) VALUES (? , ? , ? );";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			
			pst.setString(1,user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3,user.getUserName());
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

	private boolean checkEmailExsistance(String email) {
		//System.out.println("Im in the dao layer");
				Connection con = null;
				PreparedStatement pst = null;
				try {
					String query = "Select Name from signup_data where Email = ? ";
					con = jdbcTemplate.getDataSource().getConnection();
					pst = con.prepareStatement(query);
					pst.setString(1,email);
					
					
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						
						return true;
						
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
				
				return false;
	}

	public List<Guide> getAllGuides() {
		List<Guide> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			String query = "Select Name , City , Fee , Email from guidedetails";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Guide guide = new Guide();
				guide.setName(rs.getString(1));
				guide.setCity(rs.getString(2));
				guide.setFee(rs.getInt(3));
				guide.setEmail(rs.getString(4));
				list.add(guide);
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

	public boolean insertGuideSignup(Guide guide) {
		Connection con = null;
		PreparedStatement pst = null;
		if(checkEmailExsistance1(guide.getEmail())) {
			return false;
		}
		try {
			String query = "insert into guide_signup_data (Email,Password) VALUES (? , ?  );";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			
			pst.setString(1,guide.getEmail());
			pst.setString(2, guide.getPassword());
			
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
	
	private boolean checkEmailExsistance1(String email) {
		//System.out.println("Im in the dao layer");
				Connection con = null;
				PreparedStatement pst = null;
				try {
					String query = "Select Name from guide_signup_data where Email = ? ";
					con = jdbcTemplate.getDataSource().getConnection();
					pst = con.prepareStatement(query);
					pst.setString(1,email);
					
					
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						
						return true;
						
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
				
				return false;
	}

	public boolean insertGuideForm(Guide guide) {
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "insert into guidedetails (Name , Email , Contact_No , City , Interests , About_Tour , Fee) VALUES (? , ? ,? , ? , ? , ? , ? );";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			
			pst.setString(1,guide.getName());
			pst.setString(2, guide.getEmail());
			pst.setString(3,guide.getPhone());
			pst.setString(4, guide.getCity());
			pst.setString(5,guide.getHobby());
			pst.setString(6, guide.getAbout_tour());
			pst.setInt(7,guide.getFee());
			
			
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
	
	public boolean insertLanguages(Guide guide) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "insert into guidelanguage (Email,Language) VALUES (? , ?  );";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			int n = guide.getLanguages().length;
			String email = guide.getEmail();
			String [] lang = guide.getLanguages();
			int val = 0 ;
			for(int i=0;i<n;i++) {
				
				if(!lang[i].equalsIgnoreCase("None")) {
					pst.setString(1,email);
					pst.setString(2, lang[i]);
					val= pst.executeUpdate();
					val+=1;
				}

			}
			
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

	public boolean insertGuideSlots(Guide guide) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "insert into guidefreeslots (Email,FreeSlot) VALUES (? , ? );";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			int n = guide.getFreeslots().length;
			String email = guide.getEmail();
			String [] slots = guide.getFreeslots();
			int val = 0 ;
			for(int i=0;i<n;i++) {
				pst.setString(1,email);
				pst.setString(2, slots[i]);
				val= pst.executeUpdate();
				val+=1;
			}
			
			if(val==n-1) {
				System.out.println("Yes slots inserted successfully");
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

	public boolean checkInfo(Guide guide) {
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "Select * from guide_signup_data where Email = ? and Password = ?";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1,guide.getEmail());
			pst.setString(2,guide.getPassword());
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				
				System.out.println("Yes guide login successfully");
				return true;
				
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
		
		return false;
	}

	public Guide getGuideInfoForm(Guide guide) {
		
		Connection con = null;
		PreparedStatement pst1 = null;
		
		Guide guide1 = new Guide();
		try {
			
			con = jdbcTemplate.getDataSource().getConnection();
			//Here we fetch guide form(GuideForm.js) data
			String query1 = "Select Name , Email , Contact_No , City , Interests , About_Tour, Fee , Place from guidedetails where Email = ?";
			pst1 = con.prepareStatement(query1);
			pst1.setString(1, guide.getEmail());
			
			ResultSet rs1 = pst1.executeQuery();
			
			
			while(rs1.next()) {
				guide1.setName(rs1.getString(1));
				
				guide1.setEmail(rs1.getString(2));
				guide1.setPhone(rs1.getString(3));
				guide1.setCity(rs1.getString(4));
				guide1.setHobby(rs1.getString(5));
				guide1.setAbout_tour(rs1.getString(6));
				guide1.setFee(rs1.getInt(7));
				guide1.setPlaces(rs1.getString(8));
				
			}
			rs1.close();
            pst1.close();
            
            
            con.close();
		}
		catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pst1!=null)
                    pst1.close();
                
            }catch(SQLException se2){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		
		return guide1;
	}

	public List<String> getGuideInfoSlots(Guide guide) {
		List<String> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			String query = "Select FreeSlot from guidefreeslots where Email = ? ";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			pst.setString(1, guide.getEmail());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
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

	public List<String> getGuideInfoLanguage(Guide guide) {
		List<String> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			String query = "Select Language from guidelanguage where Email = ? ";
			con = jdbcTemplate.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			
			pst.setString(1, guide.getEmail());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
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

		

}

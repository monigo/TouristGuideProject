package com.codeplanet.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.codeplanet.model.Booking;
import com.codeplanet.model.Guide;
import com.codeplanet.model.User;
import com.codeplanet.service.HomeService;
import com.codeplanet.service.TouristService;

@Controller
public class HomeController {
	
@Autowired
HomeService homeService;

@Autowired
TouristService touristService;
	@RequestMapping(value="/")
	public String index() {
		
		System.out.println("home controller is callled by Dispatcher Servlet");
		return "index";
		
		// ye method call kiya tha DS ne .... usi ke pas return hua h "index"
		
	}
	@RequestMapping(value="/show_guide")
	public String test(HttpServletRequest req , Guide guide) {
	
		//System.out.println("s"+guide.getEmail());
		
//////////////////////////////////////////
		   //////////////////////////////
		  //////////////////////////////
		 //////////////////////////////
		//////////////////////////////
	   //////////////////////////////
	  //////////////////////////////
	 //////////////////////////////
		
	
		//String name = req.getParameter("name");
		//System.out.println("Guide name get into parameter issss "+name);
		
		
		HttpSession sess1=req.getSession(false);  
	    sess1.setAttribute("guideEmail",guide.getEmail());  
	    
	    
		Guide baba = new Guide();
		baba = homeService.getGuideInfo(guide);
		//String s = baba.getAbout_tour()+baba.getCity()+baba.getEmail()+baba.getFee()+baba.getHobby()+baba.getName()+baba.getPhone()+baba.getPlaces();
		//System.out.println(baba.getFreeslots().length + " ans "+baba.getLanguages().length+s) ;
		for(int i=0;i<baba.getLanguages().length;i++)
			System.out.println(baba.getLanguages()[i]);
		req.setAttribute("baba", baba);
		return "ShowGuide";
	}
	
	@RequestMapping(value="/login")
	public String Loginn(HttpServletRequest req , HttpServletResponse res , User user) throws SQLException, ServletException, IOException {
		
		String name = homeService.checkInfo(user) ;
		if(name!=null) {
			// start th session to store the email of user who just logged in
			HttpSession sess1=req.getSession();  
		    sess1.setAttribute("userEmail",user.getEmail());  
			
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
			list = homeService.getAllGuides();
			req.setAttribute("guidelist", list);
			req.setAttribute("username", name);
			//RequestDispatcher dispatcher = req.getRequestDispatcher("Home");
			//dispatcher.forward(req, res);
			
			System.out.println("in the login handler controller "+user.getUserName()+" "+user.getEmail());
			return "Home";
		}
		else {
			return "Login";
		}
		
		
	}
	
	List<Guide> list = new ArrayList<Guide>();
	
	@RequestMapping(value="/signup")
	public String home(HttpServletRequest req , HttpServletResponse res , User user) throws SQLException, ServletException, IOException {
		
		if(homeService.insertInfo(user)) {
			
			//session
			HttpSession sess1=req.getSession();  
		    sess1.setAttribute("userEmail",user.getEmail());  
			
			list = homeService.getAllGuides();
			req.setAttribute("guidelist", list);
//			RequestDispatcher dispatcher = req.getRequestDispatcher("Home");
//			dispatcher.forward(req, res);
			System.out.println("in the login/signup handler controller "+user.getEmail()+" "+user.getUserName()+" "+user.getPassword());
			
			return "Home";
		}
		else {
			return "Signup";
		}
		
	}
	
	
	@RequestMapping(value="/handle_guide_form_image" , method=RequestMethod.POST)
	public String handleGuideFormImage(HttpServletRequest  req , Guide guide) {
		
		String uploadPath = "F:\\files\\GuidesImages";
		String filepath = uploadFileOnServer(guide, uploadPath);
		System.out.println(filepath);
		
		list = homeService.getAllGuides();
		req.setAttribute("guidelist", list);
		return "Home";
	}
	
	
	@RequestMapping(value="/get_login_page")
	public String getLogin(HttpServletRequest req ) {
		
		
		System.out.println("in the getLogin controller");
		return "Login";		
			
	}
	
	@RequestMapping(value="/get_signup_page")
	public String getSignUp(HttpServletRequest req) {
		
		System.out.println("in the getSignUp controller ");
		return "Signup";
	}
	
	@RequestMapping(value="/forgot_password")
	public String forgotPassword(HttpServletRequest req , User user) throws SQLException {
	
		System.out.println("in the forgot password handler controller "+user.getEmail());
		
		return "ForgotPassword";
	}
	@RequestMapping(value="/guide_form")
	public String guideForm(HttpServletRequest req) throws SQLException {
	
		System.out.println("in the guide from handler controller ");
		
		return "GuideForm";
	}
	
	@RequestMapping(value="/guide_login")
	public String guideLogin(HttpServletRequest req) throws SQLException {
	
		//System.out.println("in the guide from handler controller ");
		
		return "GuideLogin";
	}
	@RequestMapping(value="/guide_login_handler")
	public String guideLoginHandler(HttpServletRequest req , Guide guide) throws SQLException {
	
		if(homeService.checkInfo(guide)) {
			List<Booking> reqList = touristService.getRequestsToGuide(guide.getEmail());
			req.setAttribute("requestsList", reqList);
			System.out.println(reqList.size());
			return "GuideDisplay";
		}
		else {
			return "Home";
		}
		
	}
	
	@RequestMapping(value="/guide_signup")
	public String guideSignup(HttpServletRequest req) throws SQLException {
	
		//System.out.println("in the guide from handler controller ");
		
		return "GuideSignup";
	}
	
	
	
	@RequestMapping(value="/insert_guide_signup")
	public String insertGuideSignup(HttpServletRequest req , Guide guide) throws SQLException {
		
		if(homeService.insertGuideSignup(guide)) {
			
			HttpSession session=req.getSession();  
		    session.setAttribute("email",guide.getEmail());  
		    
		    return "GuideForm";
		}
		else
			return "GuideSignup";
	}
	
	@RequestMapping(value="/handle_guide_form" , method=RequestMethod.POST)
	public String handleGuideFormm(HttpServletRequest  req , Guide guide) {
//		System.out.println("We have got "+guide.getName()+" "+guide.getEmail()+" "+guide.getCity()+" "+guide.getFee()+" "+guide.getHobby()+" "+
//				guide.getPhone()
//				);
		HttpSession session=req.getSession(false);  
        String email=(String)session.getAttribute("email");  
		guide.setEmail(email);
		System.out.println(guide.getEmail());
		String a[] = guide.getLanguages();
		for(int i=0;i<a.length;i++)System.out.println(a[i]+" ");
		
		if(homeService.insertGuideForm(guide) && homeService.insertLanguages(guide)) {
			return "GuideMoreInfo";
		}
			
		else 
			return "GuideForm" ;
	}
	
	@RequestMapping(value="/handle_guide_more_info" , method=RequestMethod.POST)
	public String handleGuideMoreInfo(HttpServletRequest  req , Guide guide) {
		

		HttpSession session=req.getSession(false);  
        String email=(String)session.getAttribute("email"); 
		guide.setEmail(email);
		System.out.println(guide.getEmail()+ "in freeslots controller");
		session.invalidate();
		if(homeService.insertGuideSlots(guide)) {
			System.out.println("insert hone ke bad");
			return "GuideDisplay";
		}
			
		else {
			System.out.println("na re");
			return "GuideMoreInfo";
		}
			
	}
	
	private String uploadFileOnServer(Guide guide , String PATH) {
		// it upload file on server and return the path of the uploaded file
		// it takes file from UserFile class
		
		String rootdirectory = PATH;  //we can also append userid in the path
		File directory = new File(rootdirectory);
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
		MultipartFile filedata  = guide.getImage();
		if(filedata==null) {
			return "F:\\files\\GuidesImages\\hacker_img.jpg	";
		}
		String filepath = null ; 
		String userfilename = filedata.getOriginalFilename();
		if(userfilename!=null && userfilename.length()>0) {
			filepath = null ;
			try {
				filepath =  directory.getCanonicalPath()+"\\"+ userfilename ;//  */ directory.getCanonicalPath()+\"\\\"+userfilename ;
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath)); 
				bos.write(filedata.getBytes());
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
			
		return filepath;
	}
}

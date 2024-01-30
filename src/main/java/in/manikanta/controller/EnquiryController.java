package in.manikanta.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.manikanta.binding.SearchCriteria;
import in.manikanta.entity.StudentEnq;
import in.manikanta.services.EnquireServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	
	@Autowired
	EnquireServiceImp eservice;

	@GetMapping("/stud-enq")
	public String addStudent(Model model) {
		
		model.addAttribute("student",new StudentEnq());
		return "studentReg";
	}
	
	@GetMapping("/view-enq")
	public String viewEnquiry(HttpServletRequest req,Model model) {
		 HttpSession session = req.getSession(false);
   	     Object attribute = session.getAttribute("CID");
   	     Integer cid = (Integer)attribute;
		List<StudentEnq> enqList = eservice.getEnquiries(cid, new SearchCriteria());
		model.addAttribute("sc",new SearchCriteria());
		model.addAttribute("enqList",enqList);
		return "viewEnquiry";
	}
	
	@PostMapping("/view-enq")
	public String viewEnqDetails(@ModelAttribute("sc") SearchCriteria sc,HttpServletRequest req,Model model) {

		 HttpSession session = req.getSession(false);
   	     Object attribute = session.getAttribute("CID");
   	     Integer cid = (Integer)attribute;
		List<StudentEnq> enqList = eservice.getEnquiries(cid, sc);
		model.addAttribute("enqList",enqList);
        return "viewEnquiry";
	}
	
	@PostMapping("/stud-enq")
	public String studentRegistration(@ModelAttribute("student")StudentEnq student,HttpServletRequest req,Model model) {
		
		 HttpSession session = req.getSession(false);
    	 Object attribute = session.getAttribute("CID");
    	 Integer cid = (Integer)attribute;
		student.setCid(cid);
		student.setCreatedDate(LocalDate.now());
		boolean saved = eservice.addEnq(student);
		if(saved) 
		{
			model.addAttribute("Added Successfully");
		}
		else {
			model.addAttribute("Failed to add Successfully");
		}
		return "redirect:dashboard";
	}
}

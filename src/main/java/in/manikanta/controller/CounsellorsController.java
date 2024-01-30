package in.manikanta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.manikanta.binding.DashboardResponse;
import in.manikanta.entity.Counsellor;
import in.manikanta.services.CounsellorServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class CounsellorsController {

	@Autowired
	CounsellorServiceImp cservice;
	
	
	@GetMapping("/")
	public String loginView(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);
		if(session!=null) {
			session.invalidate();
		}	
		model.addAttribute("counsellor",new Counsellor());
		return "loginView";
	}
	 
    @PostMapping("/")
	public String loginCounsellor(Counsellor c,HttpServletRequest req ,Model model) {
    	Counsellor output = cservice.loginCheck(c.getEmail(), c.getPwd());
    	if(output!=null)
    	{
    		HttpSession session = req.getSession(true);
    		session.setAttribute("CID", output.getCid());
    		return "redirect:dashboard"; 
    	}
		model.addAttribute("msg","Invalid Credintials");
		return "loginView";
	}
	
    @GetMapping("/dashboard")
    public String gotoDashboard(HttpServletRequest req,Model model) {
    	
    	 HttpSession session = req.getSession(false);
    	 Object attribute = session.getAttribute("CID");
    	 Integer cid = (Integer)attribute;
    	   DashboardResponse dashboardInfo = cservice.getDashboardInfo(cid);
    	   model.addAttribute("dashboard",dashboardInfo);  
    	  return "dashboard";
    }
    
    @GetMapping("/forgotPwd")
    public String forgotPWD(Model model) {
    	model.addAttribute("counsellor",new Counsellor());
    	return "forgotPwd";
    }
    
    @PostMapping("/recover-pwd")
    public String recoverPWD(Counsellor c, Model model) {
    	  boolean recoverPwd = cservice.recoverPwd(c.getEmail());
    	  if(recoverPwd) {
    		  model.addAttribute("msg","Password send to Email id");
    	  }
    	  else {
    		  model.addAttribute("msg","invalid Email id");
    	  }
    	return "forgotPwd";
    }
    
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("counsellor",new Counsellor());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(Counsellor c, Model model)
	{	
		String output = cservice.saveCounsellor(c);
		if(output!=null)
		{
			model.addAttribute("msg",output);
		}
		else {
			model.addAttribute("msg","Failed to add Counsellor");
		}
		return "register";
	}
}

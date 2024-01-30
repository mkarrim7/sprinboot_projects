package in.manikanta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.manikanta.binding.DashboardResponse;
import in.manikanta.entity.Counsellor;
import in.manikanta.entity.StudentEnq;
import in.manikanta.repo.counsellorRepo;
import in.manikanta.repo.studentEnqRepo;
import in.manikanta.util.EmailUtils;

@Service
public class CounsellorServiceImp implements CounsellorService {
 
	@Autowired
	counsellorRepo crepo;
	
	@Autowired
	studentEnqRepo srepo;
	
	@Autowired
	EmailUtils emailUtils;
	
	@Autowired
	DashboardResponse dashResp;
	
	@Override
	public String saveCounsellor(Counsellor c) {
		Counsellor obj = crepo.findByEmailAndPwd(c.getEmail(),c.getPwd());
		if(obj==null) {
			Counsellor output = crepo.save(c);
			if(output!=null)
		     {
		    	 return "Counsellor Details added Successfully";
		     }
			else {
				return null;
			}
		}
		else {
			return "User already existed";
		}
	     
	}
     
	@Override
	public Counsellor loginCheck(String email, String pwd) {
		Counsellor output = crepo.findByEmailAndPwd(email, pwd);
		return output;
	}

	@Override
	public boolean recoverPwd(String email) {
		// TODO Auto-generated method stub
		Counsellor obj = crepo.findByEmail(email);
		
		if(obj!=null)
		{
			String subject = "Recover Password";
			String to = obj.getEmail();
			String body = "<h1>Your Password::" + obj.getPwd() + "</h1>";
			emailUtils.sendEmail(body, to, subject);
			return true;
		}
		return false;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer cid) {
		// TODO Auto-generated method stub
		List<StudentEnq> totalStudents = srepo.findByCid(cid);
		
		dashResp.setTotalEnq(totalStudents.size());
		int totalEnrolled = (int) totalStudents.stream()
		              .filter(std->std.getEnqStatus().equals("Enrolled"))
		              .count();
		dashResp.setEnrolled(totalEnrolled);
		dashResp.setLostEnq(totalStudents.size()-totalEnrolled);
		
		return dashResp;
	}

}

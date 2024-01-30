package in.manikanta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.manikanta.binding.SearchCriteria;
import in.manikanta.entity.StudentEnq;
import in.manikanta.repo.studentEnqRepo;

@Service
public class EnquireServiceImp implements EnquiryService{

	@Autowired
	studentEnqRepo std;
	
	@Override
	public boolean addEnq(StudentEnq s) {
		// TODO Auto-generated method stub
		
		StudentEnq obj = std.save(s);
		
		if(obj!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<StudentEnq> getEnquiries(Integer cid, SearchCriteria sc) {
		// TODO Auto-generated method stub
		StudentEnq enq = new StudentEnq();
		enq.setCid(cid);
		if(sc.getClassMode()!=null && !sc.getClassMode().equals(""))
		{
			enq.setMode(sc.getClassMode());
		}
		if(sc.getCourse()!=null && !sc.getCourse().equals(""))
		{
			enq.setCourse(sc.getCourse());
		}
		if(sc.getEnqStatus()!=null && !sc.getEnqStatus().equals(""))
		{
			enq.setEnqStatus(sc.getEnqStatus());
		}
		
		Example<StudentEnq> of = Example.of(enq);
		
		return std.findAll(of);
		
	}

}

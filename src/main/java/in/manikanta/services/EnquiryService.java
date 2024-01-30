package in.manikanta.services;

import java.util.List;

import in.manikanta.binding.SearchCriteria;
import in.manikanta.entity.StudentEnq;

public interface EnquiryService {


	public boolean addEnq(StudentEnq se);

	public List<StudentEnq> getEnquiries(Integer cid, SearchCriteria s);
}

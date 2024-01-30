package in.manikanta.services;

import in.manikanta.binding.DashboardResponse;
import in.manikanta.entity.Counsellor;

public interface CounsellorService {

	public String saveCounsellor(Counsellor c);
	 
	public Counsellor loginCheck(String email, String pwd);

	public boolean recoverPwd(String email);

	public DashboardResponse getDashboardInfo(Integer cid);
}

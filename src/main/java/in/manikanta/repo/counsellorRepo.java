package in.manikanta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.manikanta.entity.Counsellor;

public interface counsellorRepo extends JpaRepository<Counsellor,Integer> {
	
	public Counsellor findByEmailAndPwd(String email,String pwd);
	
	public Counsellor findByEmail(String email);

}

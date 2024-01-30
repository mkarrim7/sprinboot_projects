package in.manikanta.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.manikanta.entity.StudentEnq;

@Repository
public interface studentEnqRepo extends JpaRepository<StudentEnq,Integer>{
	
	public List<StudentEnq> findByCid(Integer cid);

}

package in.manikanta.binding;

import org.springframework.stereotype.Component;

@Component
public class DashboardResponse {

	private Integer totalEnq;
	private Integer enrolled;
	private Integer lostEnq;
	@Override
	public String toString() {
		return "DashboardResponse [totalEnq=" + totalEnq + ", enrolled=" + enrolled + ", lostEnq=" + lostEnq + "]";
	}
	public Integer getTotalEnq() {
		return totalEnq;
	}
	public void setTotalEnq(Integer totalEnq) {
		this.totalEnq = totalEnq;
	}
	public Integer getEnrolled() {
		return enrolled;
	}
	public void setEnrolled(Integer enrolled) {
		this.enrolled = enrolled;
	}
	public Integer getLostEnq() {
		return lostEnq;
	}
	public void setLostEnq(Integer lostEnq) {
		this.lostEnq = lostEnq;
	}
	
}

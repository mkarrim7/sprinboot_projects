package in.manikanta.binding;

import org.springframework.stereotype.Component;

@Component
public class SearchCriteria {
	
	private String course;
	private String enqStatus;
	private String classMode;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getEnqStatus() {
		return enqStatus;
	}
	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}
	public String getClassMode() {
		return classMode;
	}
	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}
	@Override
	public String toString() {
		return "SearchCriteria [course=" + course + ", enqStatus=" + enqStatus + ", classMode=" + classMode + "]";
	}

}

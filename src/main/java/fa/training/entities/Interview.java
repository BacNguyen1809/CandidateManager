/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.entities;


import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo", name = "Interview")
public class Interview {
	@Id
	@Column(name = "interview_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int interviewId;
	
	@Column(name = "time", length = 255)
	private String time;
	
	@Column(name = "date",columnDefinition = "DATE")
	private LocalDate date;
	
	@Column(name = "interviewer", length = 255)
	private String interviewer;
	
	@Column(name = "comments", length = 2000)
	private String comments;
	
	@Column(name = "interviewResutl", length = 255)
	private String interviewResutl;

	@Column(name = "remark", length = 1000)
	private String remark;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
	private Candidate candidate;

	public Interview(String time, LocalDate date, String interviewer, String comments, String interviewResutl,
			String remark) {
		super();
		this.time = time;
		this.date = date;
		this.interviewer = interviewer;
		this.comments = comments;
		this.interviewResutl = interviewResutl;
		this.remark = remark;

	}

	public Interview() {
		super();
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getInterviewResutl() {
		return interviewResutl;
	}

	public void setInterviewResutl(String interviewResutl) {
		this.interviewResutl = interviewResutl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + "]";
	}

	

	
	
	

}

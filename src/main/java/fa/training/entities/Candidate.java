/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.entities;


import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;



@Entity
@Table(schema = "dbo", name = "Cadidate")
public class Candidate {
	@Id
	@Column(name = "candidate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidateId;
	
	@Column(name = "full_name", length = 255)
	@NotNull(message = "Please enter full name")
	private String fullName;
	
	@Column(name = "date_of_birth",columnDefinition = "DATE")
	@NotNull(message = "Please enter date of birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "gender")
	@Min(value = 0, message = "{candidate.gender.invalid}")
	@Max(value = 1, message = "{candidate.gender.invalid}")
	private int gender;
	
	@Column(name = "graduation_year",columnDefinition = "DATE")
	@NotNull(message = "Please enter graduation year")
	private LocalDate graduationYear;
	
	@Column(name = "phone", length = 255, unique = true)
	@NotNull(message = "Please enter phone")
	private String phone;
	
	@Column(name = "email", length = 255, unique = true)
	@Email(message ="{candidate.email.invalid}")
	@NotNull(message = "Please enter email")
	private String email;
	
	@Column(name = "skill", length = 255)
	private String skill;
	
	@Column(name = "foreign_language", length = 255)
	private String foreignLanguage;
	
	@Column(name = "level", length = 255)
	@Min(value = 1, message = "{candidate.level.invalid}")
	@Max(value = 7, message = "{candidate.level.invalid}")
	private int level;
	
	@Column(name = "cv", length = 255)
	private String cv;
	
	@Column(name = "allocation_status", length = 255)
	private int allocationStatus;
	
	@Column(name = "remark", length = 1000)
	private String remark;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
	private Set<EntryTest> entryTests;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
	private Set<Interview> interviews;

	public Candidate(String fullName, LocalDate dateOfBirth, int gender, LocalDate graduationYear, String phone,
			String email, String skill, String foreignLanguage, int level, String cv, int allocationStatus,
			String remark) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.cv = cv;
		this.allocationStatus = allocationStatus;
		this.remark = remark;
	}

	public Candidate() {
		super();
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public LocalDate getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(LocalDate graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getForeignLanguage() {
		return foreignLanguage;
	}

	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public int getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(int allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + "]";
	}

	

	
	
	

}

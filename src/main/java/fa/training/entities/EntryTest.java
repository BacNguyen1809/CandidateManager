/*
	* @author bacng
	* @ Date Aug 25, 2022
*/
package fa.training.entities;

import java.math.BigDecimal;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(schema = "dbo", name = "EntryTest")
public class EntryTest {
	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;

	@Column(name = "time", length = 255)
	private String time;

	@Column(name = "date", columnDefinition = "DATE")
	private LocalDate date;

	@Column(name = "language_valuator", length = 255)
	private String languageValuator;

	@Column(name = "language_result", precision = 4, scale = 2)
	@Range(min = 0,max = 10)
	private BigDecimal languageResult;

	@Column(name = "technical_valuator", length = 255)
	private String technicalValuator;

	@Column(name = "technical_result", precision = 4, scale = 2)
	@Range(min = 0,max = 10)
	private BigDecimal technicalResult;

	@Column(name = "result", length = 255)
	@Pattern(regexp = "pass|fail")
	private String result;

	@Column(name = "entry_test_skill", length = 255)
	private String entryTestSkill;

	@Column(name = "remark", length = 1000)
	private String remark;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
	private Candidate candidate;

	public EntryTest(String time, LocalDate date, String languageValuator, BigDecimal languageResult,
			String technicalValuator, String result, String entryTestSkill, String remark, BigDecimal technicalResult) {
		super();
		this.time = time;
		this.date = date;
		this.languageValuator = languageValuator;
		this.languageResult = languageResult;
		this.technicalValuator = technicalValuator;
		this.result = result;
		this.entryTestSkill = entryTestSkill;
		this.remark = remark;
		this.technicalResult = technicalResult;

	}

	public EntryTest() {
		super();
	}

	public BigDecimal getTechnicalResult() {
		return technicalResult;
	}

	public void setTechnicalResult(BigDecimal technicalResult) {
		this.technicalResult = technicalResult;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
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

	public String getLanguageValuator() {
		return languageValuator;
	}

	public void setLanguageValuator(String languageValuator) {
		this.languageValuator = languageValuator;
	}

	public BigDecimal getLanguageResult() {
		return languageResult;
	}

	public void setLanguageResult(BigDecimal languageResult) {
		this.languageResult = languageResult;
	}

	public String getTechnicalValuator() {
		return technicalValuator;
	}

	public void setTechnicalValuator(String technicalValuator) {
		this.technicalValuator = technicalValuator;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getEntryTestSkill() {
		return entryTestSkill;
	}

	public void setEntryTestSkill(String entryTestSkill) {
		this.entryTestSkill = entryTestSkill;
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
		return "EntryTest [testId=" + testId + "]";
	}

}

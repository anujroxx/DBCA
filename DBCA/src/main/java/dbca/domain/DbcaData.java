package dbca.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import dbca.utils.DateParser;

@Entity
public class DbcaData extends Reading implements Serializable {

	private static final long serialVersionUID = -2977483707963112157L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDbcaData;

	private String insuranceCompanyIdentification;

	@NotNull
	private String driverIdentification;

	private double engineLoad;
	private double engineRpm;
	private double maf;
	private double speed;
	private double throttlePos;
	private double timingAdvance;
	private String driverBehavior;

	@Temporal(TemporalType.DATE)
	private Date date;

	public DbcaData() {
	}

	public DbcaData(String driverIdentification, String date) {
		this.driverIdentification = driverIdentification;
		this.driverBehavior = new String("cluster1");
		try {
			this.setDate(DateParser.parseString(date));
		} catch (Exception e) {
			this.setDate(null);
			e.printStackTrace();
		}
	}

	public Integer getIdDbcaData() {
		return idDbcaData;
	}

	public void setIdDbcaData(Integer idDbcaData) {
		this.idDbcaData = idDbcaData;
	}

	public String getInsuranceCompanyIdentification() {
		return insuranceCompanyIdentification;
	}

	public void setInsuranceCompanyIdentification(String insuranceCompanyIdentification) {
		this.insuranceCompanyIdentification = insuranceCompanyIdentification;
	}

	public String getDriverIdentification() {
		return driverIdentification;
	}

	public void setDriverIdentification(String driverIdentification) {
		this.driverIdentification = driverIdentification;
	}

	public double getEngineLoad() {
		return engineLoad;
	}

	public void setEngineLoad(double engineLoad) {
		this.engineLoad = engineLoad;
	}

	public double getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(double engineRpm) {
		this.engineRpm = engineRpm;
	}

	public double getMaf() {
		return maf;
	}

	public void setMaf(double maf) {
		this.maf = maf;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getThrottlePos() {
		return throttlePos;
	}

	public void setThrottlePos(double throttlePos) {
		this.throttlePos = throttlePos;
	}

	public double getTimingAdvance() {
		return timingAdvance;
	}

	public void setTimingAdvance(double timingAdvance) {
		this.timingAdvance = timingAdvance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDriverBehavior() {
		return driverBehavior;
	}

	public void setDriverBehavior(String driverBehavior) {
		this.driverBehavior = driverBehavior;
	}

}

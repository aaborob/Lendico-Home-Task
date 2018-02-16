package com.lendico.assignment.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Ahmad Naser - ahmad.aborob94@gmail.com
 *
 *         Feb 16, 2018
 */

@ApiModel("Loan Details Model")
public class Loan {
	@ApiModelProperty(value = "Loan Amount", required = true)
	private Double loanAmount;
	@ApiModelProperty(value = "Nominal Rate", required = true)
	private Double nominalRate;
	@ApiModelProperty(value = "Loan Duration", required = true)
	private long duration;
	@ApiModelProperty(value = "Loan Start Date", required = true)
	private Date startDate;

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getNominalRate() {
		return nominalRate;
	}

	public void setNominalRate(Double nominalRate) {
		this.nominalRate = nominalRate;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}

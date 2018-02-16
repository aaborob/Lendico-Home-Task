package com.lendico.assignment.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lendico.assignment.model.Installment;
import com.lendico.assignment.model.Loan;
import com.lendico.assignment.service.PlansService;

/**
 * @author Ahmad Naser - ahmad.naser@erabia.com
 *
 *         Feb 16, 2018
 */

@Service("plansServiceDefaultImpl")
public class PlansServiceDefaultImpl implements PlansService {

	@Override
	public List<Installment> generateBorrowerPlan(Loan loan) {
		Double pv = loan.getLoanAmount();
		Double interestRate = loan.getNominalRate();
		long periods = loan.getDuration();
		LocalDate date = loan.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		List<Installment> plan = new ArrayList<>();
		Double annuityPayment, interest, principal;
		for (int i = 0; i < loan.getDuration(); i++) {
			
			annuityPayment = getAnnuityPayment(pv, interestRate, periods);
			interest = (interestRate * 30 * pv / 360d) / 100d;
			interest = interest > pv ? round(pv, 2) : round(interest, 2);
			principal = round((annuityPayment-interest), 2);
			
			Installment installment = new Installment();
			installment.setInterest(interest);
			installment.setBorrowerPaymentAmount(annuityPayment);
			installment.setPrincipal(principal);
			installment.setInitialOutstandingPrincipal(pv);
			installment.setRemainingOutstandingPrincipal(round((pv-principal), 2));
			installment.setDate(date.toString());
			plan.add(installment);
			
			date = date.plusMonths(1);
			pv = round(pv-principal, 2);
			periods--;
			
		}

		return plan;
	}

	private Double getAnnuityPayment(Double pv, Double interest, long period) {
		Double subInterest = (interest/12d) / 100d;
		Double annuityPayment = (subInterest * pv) / (1 - Math.pow((1 + subInterest), -period));
		return round(annuityPayment, 2);
	}
	
	private Double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}

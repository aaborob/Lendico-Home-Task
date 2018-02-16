package com.lendico.assignment.service;

import java.util.List;

import com.lendico.assignment.model.Installment;
import com.lendico.assignment.model.Loan;

/**
 * @author Ahmad Naser - ahmad.aborob94@gmail.com
 *
 *         Feb 16, 2018
 */
public interface PlansService {
	public List<Installment> generateBorrowerPlan(Loan loan);
}

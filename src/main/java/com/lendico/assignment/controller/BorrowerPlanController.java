package com.lendico.assignment.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.assignment.model.Installment;
import com.lendico.assignment.model.Loan;
import com.lendico.assignment.service.PlansService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Ahmad Naser - ahmad.aborob94@gmail.com
 *
 *         Feb 16, 2018
 */

@RestController
@Api(value = "lendicohometest", tags = { "Lendico Test APIs" }, description = "Lendico Home-Test Rest APIs")
public class BorrowerPlanController {

	@Resource(name = "plansServiceDefaultImpl")
	private PlansService plansService;

	@ApiOperation(value = "Generate Borrower Plan", nickname = "generateBorrowerPlan", response = Installment.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Generated Plan"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@RequestMapping(value = "/generate-plan", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Installment>> generateBorrowerPlan(@RequestBody(required = true) Loan loan,
			HttpServletRequest request, HttpServletResponse response) {
		// Validation to make sure needed inputs are not null 
		if (loan == null || loan.getLoanAmount() == null || loan.getStartDate() == null
				|| loan.getNominalRate() == null) {
			return new ResponseEntity<List<Installment>>(HttpStatus.BAD_REQUEST);
		}

		List<Installment> plan = plansService.generateBorrowerPlan(loan);
		if (plan == null || plan.isEmpty()) {
			return new ResponseEntity<List<Installment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Installment>>(plan, HttpStatus.OK);
	}
}

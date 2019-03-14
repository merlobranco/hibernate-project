package com.infiniteskills.data.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUDGET")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUDGET_ID")
	private Long budgetId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "GOAL_AMOUNT")
	private BigDecimal goalAmount;

	@Column(name = "PERIOD")
	private String period;
	
	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(BigDecimal goalAmount) {
		this.goalAmount = goalAmount;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
}

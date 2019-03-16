package com.infiniteskills.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MARKET")
public class Market {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MARKET_ID")
	private Long marketId;

	private Currency currency;

	@Column(name = "MARKET_NAME")
	private String marketName;

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public final Currency getCurrency() {
		return currency;
	}

	public final void setCurrency(Currency currency) {
		this.currency = currency;
	}

}

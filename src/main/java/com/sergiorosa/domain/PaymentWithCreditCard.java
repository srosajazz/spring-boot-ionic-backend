package com.sergiorosa.domain;

import javax.persistence.Entity;

import com.sergiorosa.domain.enums.PaymentStatus;


@Entity
public class PaymentWithCreditCard extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer paymentInstallments;

	public PaymentWithCreditCard() {

	}

	public PaymentWithCreditCard(Integer id, PaymentStatus status, Request request, Integer paymentInstallments) {
		super(id, status, request);

		this.paymentInstallments = paymentInstallments;
	}

	public Integer getPaymentInstalments() {
		return paymentInstallments;
	}

	public void setPaymentInstalments(Integer paymentInstallments) {
		this.paymentInstallments = paymentInstallments;
	}

}

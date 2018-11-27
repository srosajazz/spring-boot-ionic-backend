package com.sergiorosa.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergiorosa.domain.enums.PaymentStatus;

@Entity
public class PaymentWithInvoice extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dueDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date paymentDate;

	public PaymentWithInvoice() {

	}

	public PaymentWithInvoice(Integer id, PaymentStatus status, Request request, Date dueDate, Date paymentDate) {
		super(id, status, request);
		
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	
}

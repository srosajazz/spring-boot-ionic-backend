package com.sergiorosa.domain.enums;

public enum PaymentStatus {

	PENDING(1, "Pending"), PAIDOFF(2, "Paid Off"), CANCELED(3, "Canceled");

	private int cod;
	private String description;

	private PaymentStatus(int cod, String description) {

		this.cod = cod;
		this.description = description;

	}

	public int getCod() {
		return cod;
	}

	public String getDescrition() {
		return description;
	}

	public static PaymentStatus toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (PaymentStatus x : PaymentStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid Id: " + cod);
	}

}

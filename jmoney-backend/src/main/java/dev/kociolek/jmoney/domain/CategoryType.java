package dev.kociolek.jmoney.domain;

public enum CategoryType {
	INCOME("Przychód"),
	EXPENSE("Wydatek");
	
	private String type;
	
	CategoryType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}

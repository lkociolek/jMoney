package dev.kociolek.jmoney.domain.operation;

public enum OperationType {
	INCOME("Przychód"),
	EXPENSE("Wydatek"),
	TRANSFER("Transfer");
	
	private String type;
	
	OperationType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
}

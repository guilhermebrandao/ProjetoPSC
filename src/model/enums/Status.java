package model.enums;

public enum Status {
	APROVADO_PORNOTA("Aprovado por NOTA"),REPROVADO_PORNOTA("Reprovado por Nota"),RECUPERACAO("Recupera��o"),REPROVADO_PORFALTA("Reprovado por falta");
	private final String status;
	private Status(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
}

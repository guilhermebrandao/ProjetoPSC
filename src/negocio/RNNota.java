package negocio;

import dao.IDAONota;
import exception.DAOException;
import model.enums.Status;

public class RNNota {
	IDAONota daonota;

	public String NotaFinal(int id_aluno, int id_disciplina) throws DAOException {
		String status;
		double nota_final = this.daonota.NotaFinal(id_aluno, id_disciplina);
		if (nota_final >= 7.0) {
			status = Status.APROVADO_PORNOTA.getStatus();
		} else {
			status = Status.REPROVADO_PORNOTA.getStatus();
		}
		return status;

	}
}

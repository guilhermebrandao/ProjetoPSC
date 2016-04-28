package negocio;

import dao.DAOUsuario;
import dao.IDAOUsuario;
import exception.DAOException;
import model.Usuario;

public class RNUsuario {
	IDAOUsuario daousuario;
	
	public RNUsuario(){
		daousuario = new DAOUsuario();
	}
	
	/**
	 * Retorna false,caso n�o consiga encontrar o usu�rio
	 * @param login
	 * @param senha
	 * @return
	 * @throws DAOException
	 */
	public boolean VerificaLogin(String login, String senha) throws DAOException {
		boolean verifica = true;
		Usuario u;
		u = this.daousuario.Logar(login, senha);
		if (u == null) {
			verifica = false;
		}
		return verifica;
	}
}

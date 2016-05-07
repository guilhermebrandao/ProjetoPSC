package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOUsuario;
import dao.IDAOUsuario;
import exception.DAOException;
import model.Usuario;

public class RNUsuario {
	IDAOUsuario daousuario;
	
	public RNUsuario(){
		daousuario = new DAOUsuario();
	}
	
	public void inserir(Usuario u) throws DAOException {
		try {
			daousuario.inserir(u);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}

	public void verificaObjeto(Usuario u) throws Exception {
		if (u == null) {
			throw new Exception("Cadastro inv�lido");
		}
	}

	public void validaRegistro(Usuario u) throws Exception {
		if(u.getLogin() == null){
			throw new Exception("Login Inv�lido!");
		}
		if(u.getSenha() == null){
			throw new Exception("Senha Inv�lida!");
		}
	}

	public Usuario buscaUsuario(Usuario u) throws DAOException {
		try {
			return daousuario.BuscaUsuarioLogin(u.getLogin());
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar usu�rio por login!");
		}
	}

	public void registroNovoUsuario(Usuario u) throws Exception {
		if (buscaUsuario(u) != null) {
			throw new Exception("Usu�rio j� existente!");
		}
	}

	public void registroExistente(Usuario u) throws DAOException, Exception{
		if(buscaID(u) == null){
			throw new Exception("Usu�rio n�o existe no banco!");
		}
	}

	public Usuario buscaID(Usuario u) throws DAOException {
		try {
			return daousuario.buscarId(u.getId(),Usuario.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao buscar Usu�rio por id");
		}
	}
	
	public void alterar(Usuario u) throws DAOException {
		try {
			daousuario.alterar(u);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}
	
	public void excluir(int id) throws DAOException {
		try {
			daousuario.excluir(Usuario.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}
	
	public List<Usuario> listarTudo() throws DAOException{
		try {
			return daousuario.listaTudo(Usuario.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("N�o foi poss�vel Listar todos usu�rios!");
		}
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

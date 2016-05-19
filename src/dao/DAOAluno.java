package dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import exception.DAOException;
import exception.GeralException;
import model.Aluno;
import model.enums.Status;

public class DAOAluno extends DAOGenerico<Aluno> implements IDAOAluno {

	public Aluno buscaAlunoNome(String nome) throws DAOException {
		try {
			Query query = em.createQuery("SELECT a FROM Aluno a WHERE a.nome = :nome", Aluno.class);
			query.setParameter("nome", nome);
			return (Aluno) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao Buscar Aluno por Nome!");
		}
	}

	/**
	 * Retorna a quantidade de alunos de uma determinada turma
	 * 
	 * @param turma_id
	 * @return
	 */
	public int QtdAlunoTurma(int turma_id) throws DAOException {
		int qtd;
		try {
			Query query = em.createQuery("SELECT COUNT (*) from Aluno a WHERE a.id_turma = :id", Aluno.class);
			query.setParameter("id", turma_id);
			qtd = (int) query.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao obter a quantidade de Alunos!");
		}
		return qtd;
	}

	/**
	 * Retorna a quantidade de faltas de um aluno
	 */
	public int NumeroFaltas(int id_aluno) throws DAOException {
		int qtd;
		try {
			Query query = em.createQuery("SELECT a.faltas FROM Aluno a WHERE a.id = :id", Aluno.class);
			query.setParameter("id", id_aluno);
			qtd = (int) query.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao verificar a quantidade de faltas!");
		}
		return qtd;
	}

	public void LancaFalta(Aluno a) throws DAOException {
		int faltas;
		try {
			et.begin();
			faltas = a.getFaltas();
			a.setFaltas(faltas + 1);
			em.merge(a);
			et.commit();
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao lançar falta");
		}
	}
	
	public List<Status> status() throws GeralException{
		try {
			List<Status> status = Arrays.asList(Status.values());
			return status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException("Erro a listar Status");
		}
	}
	/**
	 * Lista Alunos de uma turma
	 * @param id_turma
	 * @return
	 * @throws GeralException 
	 */
	@SuppressWarnings("unchecked")
	public List<Aluno> alunoPorTurma(int id_turma) throws GeralException{
		try {
			Query query = em.createQuery("SELECT a FROM Aluno a WHERE a.id_turma = :id");
			query.setParameter("id", id_turma);
			return (List<Aluno>)query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException("Não foi possível listar Alunos pela Turma!");
		}
	}
}

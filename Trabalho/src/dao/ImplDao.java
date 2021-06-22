/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Estados;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author yagov
 */


public class ImplDao implements EstadoDao {

    @Override
    public void excluir(Estados estado) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        em.remove(estado);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Estados> pesquisar(Estados estado) {
       EntityManager em = Conexao.getEntityManager();
       StringBuilder sql = new StringBuilder("from Estados e where 1=1");
        if (estado.getId()!=null) {
            sql.append("and e.id= :id ");
        }
        if (estado.getNome()!=null && !estado.getNome().equals(" ")) {
            sql.append(" and e.nome like :NOME_CLIENTE ");
        }
         if (estado.getSigla()!=null && !estado.getSigla().equals(" ")) {
            sql.append(" and e.sigla :SIGLA_CLIENTE ");
        }
                
         if (estado.getOrcamentoTotal()!=0) {
            sql.append(" and e.orcamento_total :ORCAMENTO_TOTAL ");
        }
         if (estado.getGastoTotais()!=0) {
            sql.append(" and e.gastoTotais :GASTO_TOTAIS ");
        }

         
        Query query = em.createQuery(sql.toString());
        if (estado.getId()!=null) {
            query.setParameter("id", estado.getId());
        }
        if (estado.getNome()!=null && !estado.getNome().equals(" ")) {
            query.setParameter("nome","%"+estado.getNome());
        }
         if (estado.getSigla()!=null && !estado.getSigla().equals(" ")) {
            query.setParameter("sigla","%"+estado.getSigla());
        }
         if (estado.getOrcamentoTotal()!=0) {
            query.setParameter("orcamentoTOtal",estado.getOrcamentoTotal());
        }
         if (estado.getOrcamentoTotal()!=0) {
            query.setParameter("gastoTais",estado.getOrcamentoTotal());
        }
         
         
         
        return query.getResultList();
    }

    @Override
    public void salvarAtualizar(Estados estado) {
        EntityManager em= Conexao.getEntityManager();
        em.getTransaction().begin();
        if (estado.getId()!=null) {
            estado=em.merge(estado);
        }
        em.persist(estado);
        em.getTransaction().commit();
        em.close();
    }
   
    
    
}

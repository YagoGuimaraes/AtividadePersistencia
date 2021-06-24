/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Municipio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gabriel Rigolon
 */
public class ImplMunicipioDao implements MunicipioDao {

    @Override
    public void excluir(Municipio municipio) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        em.remove(municipio);
        em.getTransaction().commit();
        em.close();
    }
    
    @Override
    public List<Municipio> pesquisar(Municipio municipio) {
        EntityManager em = Conexao.getEntityManager();
        TypedQuery<Municipio> query = em.createQuery("select m from Municipio m", Municipio.class);
        return query.getResultList();
        
        
       /* StringBuilder sql = new StringBuilder("from Municipio m where 1=1");
        if (municipio.getId() != null) {
            sql.append("and m.id= :id ");
        }
        if (municipio.getNome() != null && !municipio.getNome().equals(" ")) {
            sql.append(" and m.nome like :NOME_MUNICIPIO ");
        }
        if (municipio.getPopulacao() != 0) {
            sql.append(" and m.populacao :POPULACAO ");
        }

        if (municipio.getClima() != null && !municipio.getClima().equals(" ")) {
            sql.append(" and m.clima :CLIMA ");
        }
//         if (municipio.getClima()!= 0) {
//            sql.append(" and m.clima :CLIMA ");
//        }
        if (municipio.getGastos() != 0) {
            sql.append(" and m.gastos :GASTOS ");
        }

        Query query = em.createQuery(sql.toString());
        if (municipio.getId() != null) {
            query.setParameter("id", municipio.getId());
        }
        if (municipio.getNome() != null && !municipio.getNome().equals(" ")) {
            query.setParameter("nome", "%" + municipio.getNome());
        }
        if (municipio.getPopulacao() != 0) {
            query.setParameter("populacao", municipio.getPopulacao());
        }

        if (municipio.getClima() != null && !municipio.getClima().equals(" ")) {
            query.setParameter("clima", "%" + municipio.getClima());
        }

        if (municipio.getGastos() != 0) {
            query.setParameter("gastos", municipio.getGastos());
        }

        return query.getResultList();*/
    }

    @Override
    public void salvarAtualizar(Municipio municipio) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if (municipio.getId() != null) {
            municipio = em.merge(municipio);
        }
        em.persist(municipio);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Municipio> pesquisarPorClima(Municipio municipio) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Municipio m where 1=1");
        if (municipio.getClima() != null && !municipio.getClima().equals(" ")) {
            sql.append(" and m.clima :CLIMA ");
        }

        Query query = em.createQuery(sql.toString());
        if (municipio.getClima() != null && !municipio.getClima().equals(" ")) {
            query.setParameter("clima", municipio.getClima());
        }

        return query.getResultList();
    }

}

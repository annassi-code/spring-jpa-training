package com.application.dao;

import com.application.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findByBrand(String brand) {
        Query query = entityManager.createQuery("from Product where brand = :brand");
        query.setParameter("brand", brand);
        return query.getResultList();
    }

    @Override
    public List<Product> findAvailableProducts() {
        return entityManager.createQuery("from Product p where p.available == 1").getResultList();
    }
/*
    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product").getResultList();
    }
*/
    @Override
    public Product findOne(Integer key) {
        return entityManager.find(Product.class, key);
    }

    @Override
    public Product create(Product entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return findOne(entity.getId());
    }

    @Override
    public Product update(Product entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Product entity) {
        entityManager.remove(entityManager.find(Product.class, entity.getId()));
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }
}

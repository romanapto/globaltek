package com.app.repository.es;

import com.app.persistence.model.es.product.Product;
import com.app.repository.es.custom.ProductRepositoryCustom;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String>, ProductRepositoryCustom {

}

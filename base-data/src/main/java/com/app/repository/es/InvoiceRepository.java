package com.app.repository.es;

import com.app.persistence.model.es.invoice.Invoice;
import com.app.repository.es.custom.InvoiceRepositoryCustom;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends ElasticsearchRepository<Invoice, String>, InvoiceRepositoryCustom {

}

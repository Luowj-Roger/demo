package com.hnisi.component.es.repository;

import com.hnisi.component.es.dataobject.ESProductDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Roger
 * @since 2021/3/22
 */
public interface ProductRepository extends ElasticsearchRepository<ESProductDO, Integer> {
}

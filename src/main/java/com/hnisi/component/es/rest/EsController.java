package com.hnisi.component.es.rest;

import com.hnisi.common.account.user.domain.SUser;
import com.hnisi.component.es.dataobject.ESProductDO;
import com.hnisi.component.es.repository.ProductRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Roger
 * @since 2021/3/22
 */
@RestController
@RequestMapping("/api/es")
public class EsController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping(value = "/save")
    public void save(@RequestBody ESProductDO s) {
        productRepository.save(s);

    }

    @PostMapping(value = "/delete")
    public void testDelete(int id) {
        productRepository.deleteById(id);
    }

    @PostMapping(value = "/get")
    public ESProductDO selectById(int id) {
        Optional<ESProductDO> userDO = productRepository.findById(id);
        return  userDO.get();
    }

    @PostMapping(value = "/list")
    public List<ESProductDO> testSelectByIds(@RequestBody List<Integer> idsList) {
        Iterable<ESProductDO> users = productRepository.findAllById(idsList);
        List<ESProductDO> list = Lists.newArrayList(users);
        return list;
    }
}

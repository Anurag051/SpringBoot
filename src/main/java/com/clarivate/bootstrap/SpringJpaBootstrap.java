package com.clarivate.bootstrap;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.clarivate.domain.Product;
import com.clarivate.repositories.ProductRepository;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;


    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
    }

    private void loadProducts() {
        Product book = new Product();
        book.setDescription("Book Test");
        book.setPrice(new BigDecimal("18.95"));
        book.setImageUrl("https://clarivate.com/wp-content/uploads/2017/11/clarivate_Book_Test-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        book.setProductId("235268845711068308");
        productRepository.save(book);

        log.info("Saved Shirt - id: " + book.getId());

        Product reserchDoc = new Product();
        reserchDoc.setDescription("Test Reserch Document");
        reserchDoc.setImageUrl("https://clarivate.com/wp-content/uploads/2017/11/clarivate_Reserch_Doc_Test-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        reserchDoc.setProductId("168639393495335947");
        reserchDoc.setPrice(new BigDecimal("11.95"));
        productRepository.save(reserchDoc);

        log.info("Saved Reserch Doc id:" + reserchDoc.getId());
    }


    }




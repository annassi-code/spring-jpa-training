package com.application;

import com.application.config.AppConfiguration;
import com.application.dao.ProductDao;
import com.application.model.Product;
import com.application.repository.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args){
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        ProductDao productDao = context.getBean(ProductDao.class);
        productDao.create(new Product("white", "fresh meat", 8));
        productDao.create(new Product("kinder", "chocolate", 19));

       ProductRepository productRepository = context.getBean(ProductRepository.class);
        List<Product> productsByDescription = productRepository.findByThisDescription("meat");
        List<Product> productsByPrice = productRepository.findByQuantityBetween(10,20);

        System.out.println("By description :");
        for(Product p : productsByDescription){
            System.out.println(p.toString());
        }

        System.out.println("By quantity :");
        for(Product p : productsByPrice){
            System.out.println(p.toString());
        }

/*
        MarketService marketService = conf.getBean(MarketService.class);
        Product p1 = new Product("white", "fresh meat", 5);
        Product p2 = new Product("kinder", "chocolate", 18);
        Market market = new Market("First market");
        List<Product> products = Arrays.asList(p1, p2);
        marketService.saveMarketAndProducts(market, products);
*/
    }
}



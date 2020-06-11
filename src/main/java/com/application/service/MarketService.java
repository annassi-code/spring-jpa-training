package com.application.service;
import com.application.model.Market;
import com.application.model.Product;
import com.application.repository.MarketRepository;
import com.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MarketService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MarketRepository marketRepository;

    public void saveMarketAndProducts(Market market, List<Product> products){
        marketRepository.save(market);
        for(Product p : products){
        //    p.setMarket(market);
       //     productRepository.save(p);
        }
    }

}

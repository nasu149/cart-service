package org.nasuda.shopping.service;


// import java.util.Map;

import org.infinispan.client.hotrod.RemoteCache;
// import org.infinispan.client.hotrod.RemoteCacheManager;
// import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
// import org.infinispan.commons.api.BasicCacheContainer;
import org.nasuda.shopping.model.Cart;

import io.quarkus.infinispan.client.Remote;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CartServiceImpl implements CartService{

    @Inject
    @Remote("test") 
    RemoteCache<String, Cart> cache;

    public Cart getCart(String cartId) {
        
        // String host = "127.0.0.1";
        // String port = "11222";
        // ConfigurationBuilder builder = new ConfigurationBuilder();
        // builder.addServer()
        //        .host(host)
        //        .port(Integer.parseInt(port));
        // BasicCacheContainer manager = new RemoteCacheManager(builder.build());
        // Map<String, Cart> carts = manager.getCache("test");
        // carts.put(cartId, new Cart());
        Cart cart = cache.get(cartId);
        System.out.println(cart);
        return cart;
    }

    public Cart addItem(Integer cartId, Integer itemId, int quantity) {
        return null;
    }

    public Cart set(Integer cartId, Integer tempId) {
        return null;
    }

    public Cart deleteItem(Integer cartId, Integer itemId, int quantity) {
        return null;
    }

    public Cart checkout(Integer cartId) {
        return null;
    }
}

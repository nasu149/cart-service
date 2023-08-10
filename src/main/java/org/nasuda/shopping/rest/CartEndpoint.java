package org.nasuda.shopping.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import org.infinispan.client.hotrod.RemoteCache;
import org.nasuda.shopping.model.Cart;
import org.nasuda.shopping.model.CartItem;
import org.nasuda.shopping.model.Product;
import org.nasuda.shopping.service.CartService;

import io.quarkus.infinispan.client.Remote;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("cart")
public class CartEndpoint {
    
    @Inject
    CartService cartService;

    @Inject
    @Remote("test") 
    RemoteCache<String, Cart> cache;

    @POST
    @Path("/test/{id}")
    public CompletionStage<String> postGreeting(String id, Cart greeting) {
        System.out.println("POST test/id id = " + id + " cart = " + greeting);
        return cache.putAsync(id, greeting, 60, TimeUnit.SECONDS, 10, TimeUnit.SECONDS) 
              .thenApply(g -> "Greeting done!")
              .exceptionally(ex -> ex.getMessage());
    }

    @GET
    @Path("/test/{id}")
    public CompletionStage<Cart> getGreeting(String id) {
        List<CartItem> list = new ArrayList<CartItem>();
        Product product = new Product(1000, "nasuda", 100);
        CartItem cartItem = new CartItem(10, product);
        list.add(cartItem);
        cache.put(id, new Cart(1, 2, 123, list));
        System.out.println(cache);
        return cache.getAsync(id); 
    }


    @GET
    @Path("/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getCart(@PathParam("cartId") String cartId) {
        System.out.println("nasuda debug: CartEndpoint getCart called");
        return cartService.getCart(cartId);
    }

    @POST
    @Path("/{cartId}/{itemId}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart add(Integer cartId,
                            @PathParam("itemId") Integer itemId,
                            @PathParam("quantity") int quantity) throws Exception {
        return cartService.addItem(cartId, itemId, quantity);
    }

    @POST
    @Path("/{cartId}/{tmpId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart set(@PathParam("cartId") Integer cartId,
                            @PathParam("tmpId") Integer tmpId) throws Exception {

        return cartService.set(cartId, tmpId);
    }

    @DELETE
    @Path("/{cartId}/{itemId}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart delete(@PathParam("cartId") Integer cartId,
                               @PathParam("itemId") Integer itemId,
                               @PathParam("quantity") int quantity) throws Exception {

        return cartService.deleteItem(cartId, itemId, quantity);
    }

    @POST
    @Path("/checkout/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart checkout(@PathParam("cartId") Integer cartId) {
        return cartService.checkout(cartId);
    }
}

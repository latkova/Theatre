package mate.academy.spring.service;

import mate.academy.spring.model.PerformanceSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clearShoppingCart(ShoppingCart cart);
}

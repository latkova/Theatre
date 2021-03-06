package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.PerformanceSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final PerformanceSessionService movieSessionService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  PerformanceSessionService movieSessionService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.userService = userService;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam(value = "UserId") Long userId,
                                @RequestParam(value = "movieSessionId") Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam(value = "userId") Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }
}

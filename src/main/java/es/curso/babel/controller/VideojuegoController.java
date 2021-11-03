package es.curso.babel.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import es.curso.babel.model.entity.Order;
import es.curso.babel.model.entity.Usuario;
import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.service.OrderService;
import es.curso.babel.model.service.UsuarioService;
import es.curso.babel.model.service.VideojuegoService;

@Controller
@RequestMapping("videojuegos")
@SessionAttributes("order")
public class VideojuegoController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private VideojuegoService videoService;
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private Usuario usuario;
	
	@ModelAttribute("order")
	public Order setupOrder() {
		Order order = new Order();
		order.setUsuario(userService.findByUsername(usuario.getUsername()));
		System.out.println(usuario.getId());
		return order;
	}
	
	@GetMapping("")
	public ModelAndView getVideojuegos() {
		if(usuario.getUsername() == null) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelAndView modelView = new ModelAndView("videojuegos");
		modelView.addObject("videojuegos", videoService.getAllVideojuegos());
		return modelView;
	}
	
	@GetMapping("/detalle")
	public ModelAndView getVideojuegoDetalle(@RequestParam("id") int id) {
		if(usuario.getUsername() == null) {
			return new ModelAndView("redirect:/login");
		}
		ModelAndView modelView = new ModelAndView("videojuegoDetalle");
		modelView.addObject("videojuego", videoService.findVideojuegoById(id));
		return modelView;
	}
	
	@GetMapping("/delete")
	public String eliminarVideojuego(@RequestParam("id") int id, Model model) {
		if(usuario.getUsername() == null) {
			return "redirect:/login";
		}
		videoService.eliminarVideojuego(id);
		return "redirect:/videojuegos";
	}
	
	@GetMapping("/formVideojuego")
	public String getFormVideojuego(@RequestParam(required=false) Integer id, Model model) {
		
		if(usuario.getUsername() == null) {
			return "redirect:/login";
		}
		
		if (id != null) {
			model.addAttribute("videojuego", videoService.findVideojuegoById(id));
		} else {
			model.addAttribute("videojuego", new Videojuego());
		}
		return "formVideojuego";
	}
	
	@PostMapping("/doFormVideojuego")
	public String newVideojuego(Model model, @Valid @ModelAttribute Videojuego videojuego, BindingResult errors) {

		if (errors.hasErrors()) {
			return "formVideojuego";
		}
			
		videojuego.setImagen("imagen-default.jpg");
			
		videoService.añadirVideojuego(videojuego);
			
		return "redirect:/videojuegos";
		
	}
	
	@GetMapping("/addVideojuego")
	public String addVideojuego(@RequestParam("id") Integer id, @ModelAttribute("order") Order order) {
		
		if(usuario.getUsername() == null) {
			return "redirect:/login";
		}
		
		order.getVideojuegos().add(videoService.findVideojuegoById(id));
		return "redirect:/videojuegos";
	}
	
	@GetMapping("/removeVideojuego")
	public String removeVideojuego(@RequestParam("id") Integer id, @ModelAttribute("order") Order order) {
		
		if(usuario.getUsername() == null) {
			return "redirect:/login";
		}
		
		order.getVideojuegos().remove(videoService.findVideojuegoById(id));
		return "redirect:/videojuegos";
	}
	
	@GetMapping("/carritoCompra")
	public String getCarritoCompra(Model model, @ModelAttribute("order") Order order) {
		if(usuario.getUsername() == null) {
			return "redirect:/login";
		}
		model.addAttribute("listaCompra", order.getVideojuegos());
		model.addAttribute("total", orderService.calcularTotal(order));
		System.out.println(order);
		return "listaCompra";
	}
	
	@GetMapping("/carritoCompra/comprar")
	public String hacerPedido(@ModelAttribute("order") Order order, SessionStatus sessionStatus) {
		
		if(usuario.getUsername() == null) {
			return "redirect:/login";
		}
		
		order.setDate(new Date());
		System.out.println(order);

		orderService.save(order);
		
		sessionStatus.setComplete();
		return "redirect:/videojuegos";
	}
	
	@GetMapping("/orders")
	public String getOrders(Model model) {
		
		if(usuario.getUsername() == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("orders", orderService.findByUsuarioId(usuario.getId()));
		return "ordersView";
	}
}

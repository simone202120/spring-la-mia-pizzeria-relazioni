package org.pizzeria.italy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/promozione")
public class PromotionController {
	
	@Autowired
	private PromozioneService prService;
	
	@Autowired 
	private PizzaService pzService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Promotion> promotions = prService.findAllWPizza();
		model.addAttribute("promotions", promotions);
		return "promotion-index";
	}
	
	@GetMapping("/create")
	public String getPromotionCreate(Model model) {
		
		Promotion promotion = new Promotion();
		List<Pizza> pizzas = pzService.findAll();
		model.addAttribute("promotion", promotion);
		model.addAttribute("pizzas", pizzas);
		
		return "promotion-create";
	}
	
	@PostMapping("/create")
	public String storePromotion(@Valid Promotion promotion) {
		List<Pizza> promotionPizzas = promotion.getPizzas();
		for (Pizza pizza : promotionPizzas) {
			pizza.setPromotion(promotion);
		}
		prService.save(promotion);
		
		return "redirect:/promotion";
	}
}

package sring_boot.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sring_boot.project.model.Product;
import sring_boot.project.service.ProductRepoService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRepoController {
    private final ProductRepoService productRepoService;

    @GetMapping ("/all")
    public String showAll(Model model) {
        model.addAttribute("products",productRepoService.showAll());
        return "products_view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable int id) {
        productRepoService.deleteProductById(id);
        return "redirect:/products/all";
    }

    @PostMapping ("/add")
    public String addNewProduct (@ModelAttribute Product product) {
        productRepoService.saveOrUpdate(product);
        return "redirect:/products/all";
    }
}

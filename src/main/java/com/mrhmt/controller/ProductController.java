package com.mrhmt.controller;

import com.mrhmt.models.Product;
import com.mrhmt.models.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private void loadData() {
        if (ProductData.created == false) {
            ProductData.loadData();
            ProductData.created = true;
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        loadData();

        return new ModelAndView("/product/index", "listProduct", ProductData.listProduct);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("/product/create", "product", new Product(1, "Sua chuaa", 12, 12));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RedirectView create(@Valid @ModelAttribute("product")Product product, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new RedirectView("/product/index");
        }

        ProductData.listProduct.add(product);

        return new RedirectView("/product/index");
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ModelAndView details(@RequestParam(value = "id", required = false) int id) {
        loadData();

        if (findProduct(id) != null) {
            return new ModelAndView("/product/details", "product", findProduct(id));
        } else {
            return new ModelAndView("/product/notfound");
        }
    }

    private Product findProduct(int id) {
        for (Product product : ProductData.listProduct) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public RedirectView delete(@RequestParam(value = "id", required = false) int id) {
        loadData();

        if (deleteProduct(id) == true) {
            return new RedirectView("/product/index");
        } else {
            return new RedirectView("/product/index");
        }
    }

    private boolean deleteProduct(int id) {
        for (Product product : ProductData.listProduct) {
            if (product.getId() == id) {
                ProductData.listProduct.remove(product);
                return true;
            }
        }

        return false;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "id", required = false) int id) {
        if (findProduct(id) != null) {
            return new ModelAndView("/product/edit", "product", findProduct(id));
        } else {
            return null;
        }
    }

    private boolean updateProduct(Product product) {
        System.out.println("hehe " + product.getId());
        for (Product newProduct : ProductData.listProduct) {
            if (newProduct.getId() == product.getId()) {
                newProduct.setAmout(product.getAmount());
                newProduct.setName(product.getName());
                newProduct.setPrice(product.getPrice());

                return true;
            }
        }

        return false;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RedirectView edit(@Valid @ModelAttribute("product")Product product, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new RedirectView("/product/index");
        }

        if (updateProduct(product)) {
            return new RedirectView("/product/index");
        } else {
            System.out.println("Fail!");
            return new RedirectView("/product/index");
        }
    }
}

package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {

        List<Car> list = new ArrayList<>();
        list.add(new Car("bmw", 1990, "grey"));
        list.add(new Car("volga", 1980, "black"));
        list.add(new Car("lada", 1991, "white"));
        list.add(new Car("peugeot", 2010, "red"));
        list.add(new Car("kia", 2019, "white"));

        CarServiceImpl carService = new CarServiceImpl();

        List<Car> result = carService.listCars(list, count);
        model.addAttribute("cars", result);

        return "cars";
    }

}

package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    @Override
    public List<Car> listCars(List<Car> list, int count) {
        if (count > 5) {
            return list;
        }
        return list.stream().limit(count).collect(Collectors.toList());
    }
}

package com.realestate.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.model.Property;
import com.realestate.repo.PropertyRepository;

@Service
public class PropertyService {

	@Autowired
	UserService userService;

@Autowired
private PropertyRepository propertyRepository;

public Property save(Property property, Long id) {
	Property savedProperty = propertyRepository.save(property);
	userService.addPropertyToUser(id, savedProperty);
	return savedProperty;
}


public List<Property> findPropertiesBySize(Double size){
    return propertyRepository.findBySize(size);
}

public List<Property> getUnsoldProperties(){
    return propertyRepository.findBySold(false);
}

public List<Property> getAllProperties(){
    return propertyRepository.findAll();
}

public List<Property> findPropertiesInInventory() {
		List<Property> properties = propertyRepository.findPropertiesInInventory();
		return properties;
	}

    public List<Property> checkForDiscount(List<Property> properties){
		
		for (Property property : properties) {
			LocalDate startDate = property.getDatePosted();
			LocalDate currentDate = LocalDate.now();
			long daysBetween = ChronoUnit.DAYS.between(startDate, currentDate);
	
			if (daysBetween > 90) {
				Double currentPrice = property.getPrice();
				Double discountedPrice = currentPrice * 0.9;
				property.setPrice(discountedPrice);
				propertyRepository.save(property);
			}
		}
		return properties;
	}

    
}

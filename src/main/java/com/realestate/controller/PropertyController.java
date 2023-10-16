package com.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.model.Photo;
import com.realestate.model.Property;
import com.realestate.service.PropertyService;

@RestController
@RequestMapping("/properties")
@CrossOrigin("*")
public class PropertyController {
    
    @Autowired
    private PropertyService propertyService;

	@RequestMapping(
		  		value = "/save/{id}",
		  		consumes = MediaType.APPLICATION_JSON_VALUE,
		  		produces = MediaType.APPLICATION_JSON_VALUE,
		  		method = RequestMethod.POST
		  )
	 public ResponseEntity<Object> save(@RequestBody Property property, @PathVariable Long id) {

	      try {
			
	          Property savedProperty = propertyService.save(property, id);
	          return new ResponseEntity<Object>(savedProperty, HttpStatus.CREATED);
	      } catch (Exception e) {

	          return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
	      } catch (Error e) {

	          return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	      }

	  }

    @RequestMapping(
				value="/findPropertiesBySize/{size}",
  
				produces = MediaType.APPLICATION_JSON_VALUE,
				method = RequestMethod.GET
				)
			public ResponseEntity<Object> findPropertiesBySquareFoot(@PathVariable Double size) {
				  try{ 
					
					List <Property> foundProperty = propertyService.findPropertiesBySize(size);
					return new ResponseEntity<Object>(foundProperty, HttpStatus.OK);
				} catch (Exception e) {
					System.out.println(e);
					return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
				} catch (Error e) {
					System.out.println(e);
					return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}  


		@RequestMapping(
			      value="/findPropertiesInInventory",
			      produces = MediaType.APPLICATION_JSON_VALUE,
			      method = RequestMethod.GET
			  )
			  public ResponseEntity<Object> findPropertiesInInventory() {

			      try {
			          List<Property> inventoryProperties = propertyService.findPropertiesInInventory();
						List<Property> discountCheckedProperty = propertyService.checkForDiscount(inventoryProperties);

			          return new ResponseEntity<Object>(discountCheckedProperty, HttpStatus.OK);
			      } catch (Exception e) {
			          System.out.println(e);
			          return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
			      } catch (Error e) {
			          System.out.println(e);
			          return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
			      }

			  }

    @GetMapping("/unsold")
    public ResponseEntity<List<Property>>  getUnsoldProperties(){
        List<Property> unsoldProperties = propertyService.getUnsoldProperties();
        return ResponseEntity.ok(unsoldProperties);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Property>> getAllProperties(){
       List<Property> allProperties = propertyService.getAllProperties();
       return ResponseEntity.ok(allProperties);
    }

	// 	  }
	//   @RequestMapping(
	// 	      value="/addPhoto/{id}",
	// 		  consumes = MediaType.APPLICATION_JSON_VALUE,
	// 	      produces = MediaType.APPLICATION_JSON_VALUE,
	// 	      method = RequestMethod.POST
	// 	  )
	// 	  public ResponseEntity<Object> addPhoto (@RequestBody Photo photo, @PathVariable Integer id) {

	// 	      try {
	// 	    	  photoService.save(photo);
	// 	          Property foundProperty = propertyService.findById(id);
	// 	          foundProperty.addPropertyPhoto(photo);
	// 	          propertyService.update(foundProperty);
		         
		          
		          
		          
	// 	          return new ResponseEntity<Object>(foundProperty, HttpStatus.OK);
	// 	      } catch (Exception e) {
	// 	          System.out.println(e);
	// 	          return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	// 	      } catch (Error e) {
	// 	          System.out.println(e);
	// 	          return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	// 	      }

		  
}

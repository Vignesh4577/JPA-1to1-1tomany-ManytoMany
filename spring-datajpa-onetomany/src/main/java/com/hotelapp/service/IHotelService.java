package com.hotelapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;
@Service
public interface IHotelService {

	//in built
	Hotel addHotel(Hotel hotel);
	void updateHotel(Hotel hotel);
	void deleteHotel(int hotelId);
	List<Hotel>  getAll();
	Hotel getById(int hotelId);
	
	//derived queries
	List<Hotel> getByCity(String city);
	List<Hotel> getByType(Type type); //veg or nonveg
	List<Hotel> getByRating(double rating);
	
	//custom queries
	List<Hotel> getByItemName(String itemName); //dosa
	List<Hotel> getByItemNameCategory(String itemName,Category category); //paneer and starter
	List<Hotel> getByCuisine(String cuisine);
	List<Hotel> getByCategory(Category category);//starter or dessert
	List<Hotel> getByCuisineAndType(String cuisine,Type type); //chinese and veg or non-veg
	List<Hotel> getByItemNameLessPrice(String itemName,double price);
	
}

package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;
import com.hotelapp.repository.IHotelRepository;
@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	IHotelRepository hotelRepository;
	
	@Autowired
	public void setHotelRepository(IHotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		 hotelRepository.save(hotel);
	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepository.deleteById(hotelId);
	}

	@Override
	public List<Hotel> getAll() {
		
		//Sort sort = Sort.by("name");
		
		Sort sort = Sort.by(Direction.DESC,"name");
		return hotelRepository.findAll(sort);
	}

	
	@Override
	public Hotel getById(int hotelId) {
		return hotelRepository.findById(hotelId).get();
	}

	@Override
	public List<Hotel> getByCity(String city) {
		return hotelRepository.findByCity(city);
	}

	@Override
	public List<Hotel> getByType(Type type) {
		return hotelRepository.getBytype(type,Sort.by("name"));
	}

	@Override
	public List<Hotel> getByRating(double rating) {
		return hotelRepository.findByrating(rating);
	}

	@Override
	public List<Hotel> getByItemName(String itemName) {
		// TODO Auto-generated method stub
		return hotelRepository.findByItemName(itemName);
	}

	@Override
	public List<Hotel> getByItemNameCategory(String itemName, Category category) {
		// TODO Auto-generated method stub
		return hotelRepository.findByItemNameCategory(itemName, category);
	}

	@Override
	public List<Hotel> getByCuisine(String cuisine) {
		// TODO Auto-generated method stub
		return hotelRepository.findByCuisine(cuisine);
	}

	@Override
	public List<Hotel> getByCategory(Category category) {
		// TODO Auto-generated method stub
		return hotelRepository.findByCategory(category);
	}

	@Override
	public List<Hotel> getByCuisineAndType(String cuisine, Type type) {
		// TODO Auto-generated method stub
		return hotelRepository.findByCuisineAndType(cuisine, type);
	}

	@Override
	public List<Hotel> getByItemNameLessPrice(String itemName, double price) {
		// TODO Auto-generated method stub
		return hotelRepository.findByItemNameLessPrice(itemName, price);
	}

}

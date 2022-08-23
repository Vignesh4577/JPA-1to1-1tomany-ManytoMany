package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

	List<Hotel> findByCity(String city);

	List<Hotel> getBytype(Type type, Sort sort);

	List<Hotel> findByrating(double rating);

	List<Hotel> getByItemListItemName(String name);

	// custom queries
	@Query("from Hotel h inner join h.itemList i where i.itemName=?1")
	List<Hotel> findByItemName(String itemName); // dosa

	@Query("from Hotel h inner join h.itemList i where i.itemName=?1 or i.category=?2")
	List<Hotel> findByItemNameCategory(String itemName, Category category); // paneer and starter

	//NativeQuery
	//@Query("from Hotel h inner join h.itemList i where i.cuisine=?1")
	@Query(value = "select * from hotel h inner join item i on i.hotel_id where i.cuisine=?1",nativeQuery = true)
	List<Hotel> findByCuisine(String cuisine);

	// Named Query
	@Query(name = "ReadByCat")
	List<Hotel> findByCategory(Category category);// starter or dessert

	@Query("from Hotel h inner join h.itemList i where i.cuisine=?1 or i.itemType=?2")
	List<Hotel> findByCuisineAndType(String cuisine, Type type); // chinese and veg or non-veg

	@Query("from Hotel h inner join h.itemList i where i.itemName=?1 or i.price<?2")
	List<Hotel> findByItemNameLessPrice(String itemName, double price);

}

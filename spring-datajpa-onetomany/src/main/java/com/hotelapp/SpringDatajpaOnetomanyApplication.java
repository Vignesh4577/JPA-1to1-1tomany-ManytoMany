package com.hotelapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Item;
import com.hotelapp.model.Type;
import com.hotelapp.service.IHotelService;

@SpringBootApplication
public class SpringDatajpaOnetomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanyApplication.class, args);
	}

	@Autowired
	IHotelService hotelService;

	@Override
	public void run(String... args) throws Exception {
		Item item = new Item("Dosa", Category.BREAKFAST, "South", Type.VEG, 60);
		Item item1 = new Item("Lunch", Category.MAINCOURSE, "South", Type.VEG, 170);
		Item item2 = new Item("IceCream", Category.BEVERAGES, "juices", Type.VEG, 150);
		Set<Item> items = new HashSet<>(Arrays.asList(item, item1, item2));

		Hotel hotel = new Hotel("sagar", Type.VEG, "Bangalore", 4.5, items);
		// hotelService.addHotel(hotel);

		Item item3 = new Item("Dosa", Category.FASTFOOD, "North", Type.VEG, 40);
		Item item4 = new Item("Idly", Category.STARTERS, "North", Type.VEG, 30);
		Item item5 = new Item("kabab", Category.MAINCOURSE, "special", Type.NONVEG, 150);
		Set<Item> itemsList1 = new HashSet<>(Arrays.asList(item3, item4, item5));

		Hotel hotel2 = new Hotel("Dragon King", Type.NONVEG, "pune", 3.8, itemsList1);
		// hotelService.addHotel(hotel2);

		System.out.println("ByCity");
		hotelService.getByCity("Bangalore").forEach(System.out::println);
		System.out.println("********************************************************");

		System.out.println("ByRating");
		hotelService.getByRating(4.5).forEach(System.out::println);
		System.out.println("********************************************************");

		System.out.println("ByItemName");
		hotelService.getByItemName("Dosa").forEach(System.out::println);
		System.out.println("********************************************************");

		System.out.println("ByItemNameCategory");
		hotelService.getByItemNameCategory("Dosa", Category.BREAKFAST).forEach(System.out::println);
		System.out.println("********************************************************");

		System.out.println("ByType");
		hotelService.getByType(Type.VEG).forEach(System.out::println);
		System.out.println("********************************************************");

		System.out.println("ByCuisine");
		hotelService.getByCuisine("South").forEach(System.out::println);
		System.out.println("********************************************************");

		System.out.println("ByCategory");
		hotelService.getByCategory(Category.BREAKFAST).forEach(System.out::println);
		System.out.println("********************************************************");

		System.out.println("ByCuisineAndType");
		hotelService.getByCuisineAndType("chinese", Type.VEG).forEach(System.out::println);
		System.out.println("********************************************************");

		
		System.out.println("ByItemNameLessPrice");
		hotelService.getByItemNameLessPrice("North", 100).forEach(System.out::println);
		System.out.println("********************************************************");

//		hotelService.getByItemNameCategory("Dosa", Category.BREAKFAST).forEach(nhotel->{
//			System.out.println("Name "+nhotel.getName());
//			System.out.println("City "+nhotel.getName());
//		});

		 System.out.println("By Sorting");
		 hotelService.getAll().forEach(System.out::println);
		 System.out.println("****************************");

	}

}

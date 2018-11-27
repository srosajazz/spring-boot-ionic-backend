package com.sergiorosa;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sergiorosa.domain.Address;
import com.sergiorosa.domain.Categorie;
import com.sergiorosa.domain.City;
import com.sergiorosa.domain.Client;
import com.sergiorosa.domain.ItemOrder;
import com.sergiorosa.domain.Payment;
import com.sergiorosa.domain.PaymentWithCreditCard;
import com.sergiorosa.domain.PaymentWithInvoice;
import com.sergiorosa.domain.Product;
import com.sergiorosa.domain.Request;
import com.sergiorosa.domain.State;
import com.sergiorosa.domain.enums.ClientType;
import com.sergiorosa.domain.enums.PaymentStatus;
import com.sergiorosa.repositories.AddressRepository;
import com.sergiorosa.repositories.CategoryRepository;
import com.sergiorosa.repositories.CityRepository;
import com.sergiorosa.repositories.ClientRepository;
import com.sergiorosa.repositories.ItemOrderRepository;
import com.sergiorosa.repositories.PaymentRepository;
import com.sergiorosa.repositories.ProductRepository;
import com.sergiorosa.repositories.RequestRepository;
import com.sergiorosa.repositories.StateRepository;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private ItemOrderRepository itemOrderRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categorie cat1 = new Categorie(null, "Computer");
		Categorie cat2 = new Categorie(null, "Mac Book Apple Computer");

		Product p1 = new Product(null, "Computer", 1800.00);
		Product p2 = new Product(null, "MacBook", 2800.00);
		Product p3 = new Product(null, "Ipad", 400.00);

		cat1.getProdut().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdut().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State sta1 = new State(null, "Boston");
		State sta2 = new State(null, "Broklyn");

		City c1 = new City(null, "Massachusetts", sta1);
		City c2 = new City(null, "New York", sta2);
		City c3 = new City(null, "California", sta2);

		sta1.getCities().addAll(Arrays.asList(c1));
		sta2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Mike Smith", "msmith@gmail.com", "63789300", ClientType.PHYSICALPERSON);

		cli1.getPhones().addAll(Arrays.asList("536383839", "9202938930"));

		Address a1 = new Address(null, "Main St", "777", "Apt 256", "Malden", "02678", cli1, c1);
		Address a2 = new Address(null, "Lowes St", "657", "Apt 67", "Downtown", "07865", cli1, c2);

		cli1.getAdresses().addAll(Arrays.asList(a1, a2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Request req1 = new Request(null, sdf.parse("25/11/2018 10:00"), cli1, a1);
		Request req2 = new Request(null, sdf.parse("10/12/2018 10:00"), cli1, a2);

		Payment pay1 = new PaymentWithCreditCard(null, PaymentStatus.PAIDOFF, req1, 5);
		req1.setPayment(pay1);

		Payment pay2 = new PaymentWithInvoice(null, PaymentStatus.PENDING, req2, sdf.parse("21/12/2018 00:00"), null);
		req2.setPayment(pay2);

		cli1.getRequest().addAll(Arrays.asList(req1, req2));

		requestRepository.saveAll(Arrays.asList(req1, req2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		ItemOrder io1 = new ItemOrder(req1, p1, 0.00, 2000.00, 1);
		ItemOrder io2 = new ItemOrder(req1, p3, 0.00, 80.00, 2);
		ItemOrder io3 = new ItemOrder(req2, p2, 100.00, 800.00, 1);

		req1.getItems().addAll(Arrays.asList(io1, io2));
		req2.getItems().addAll(Arrays.asList(io3));

		p1.getItems().addAll(Arrays.asList(io1));
		p2.getItems().addAll(Arrays.asList(io3));
		p3.getItems().addAll(Arrays.asList(io2));

		itemOrderRepository.saveAll(Arrays.asList(io1, io2, io3));

	}
}

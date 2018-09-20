package com.example.demo.bean;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.db.AccountRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AccountRepositoryIntegrationTest {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	@SuppressWarnings("deprecation")
	public void whenFindByName_thenReturnAccount() {
		Account acc = new Account((long) 0, "Chase", new Date(2017, 2, 5), 2345.67);
		Account found = accountRepository.findByName(acc.getName());
		
		assertThat(found.getName()).isEqualTo(acc.getName());
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void whenFindById_thenReturnAccount() {
		
		Account acc = new Account((long) 0, "Chase", new Date(2017, 2, 5), 2345.67);
		Optional<Account> found = accountRepository.findById(acc.getId());
		
		assertThat(found.get().getName()).isEqualTo(acc.getName());
	}

	@Test
	@SuppressWarnings("deprecation")
	public void testGetters() {
		Account acc = new Account((long) 0, "Chase", new Date(2017, 2, 5), 2345.67);
		assertThat(acc.getId()).isEqualTo((long) 0);
		assertThat(acc.getName()).isEqualTo("Chase");
		assertThat(acc.getCreated_on()).isEqualTo(new Date(2017, 2, 5));
		assertThat(acc.getBalance()).isEqualTo(2345.67);
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void testSetters() {
		Account acc = new Account((long) 0, "Chase", new Date(2017, 2, 5), 2345.67);
		acc.setId((long) 1);
		acc.setName("PNC Bank");
		acc.setCreated_on(new Date(2018, 4, 7));
		acc.setBalance(78900.25);
		
		assertThat(acc.getId()).isEqualTo((long) 1);
		assertThat(acc.getName()).isEqualTo("PNC Bank");
		assertThat(acc.getCreated_on()).isEqualTo(new Date(2018, 4, 7));
		assertThat(acc.getBalance()).isEqualTo(78900.25);
	}
}

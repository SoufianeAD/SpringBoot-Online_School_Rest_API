package com.esisa.back.office.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esisa.back.office.entities.Account;
import com.esisa.back.office.repositories.AccountRepository;
import com.esisa.back.office.services.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public Account add(@RequestBody Account account) {
		account.setId(sequenceGeneratorService.generateSequence(Account.SEQUENCE_NAME));
		return accountRepository.save(account);
	}
	
	@PutMapping("/update")
	public Account update(@RequestBody Account account) {
		return accountRepository.save(account);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		accountRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		accountRepository.deleteAll();
	}
	
	@GetMapping("/getAll")
	public List<Account> getAll() {

		return accountRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Account> getById(@PathVariable("id") long id) {
		return accountRepository.findById(id);
	}
	
	
}

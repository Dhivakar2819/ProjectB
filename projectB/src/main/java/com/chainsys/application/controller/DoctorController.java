package com.chainsys.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	@Autowired
	private DoctorRepositories repo;
	//@Bean
//	public void createrepo(DoctorRepositories repo) {
//		this.repo=repo;
//	}
//	@GetMapping("/getdoctor")
//	public Doctor getDoctor(int id)
//	{
//		return repo.findById(id);
//	}
	
	@GetMapping("/getdoctor")
	public Doctor getDoctor(int id)
	{
		return repo.findById(id);
	}
	
	
	@PostMapping(value="/adddoctor",consumes="application/json")
	// we need to give from where to read data from the HTTP request and also the content type ("application/json")
	public String adddoctor(@RequestBody Doctor dr) {
		System.out.println("Doctor : "+dr.getDoc_id()+" "+dr.getDoc_name());
		repo.save(dr);
		return "redirect:/getalldoctors";
	}
	@PutMapping(value="/updatedoctor",consumes="application/json")
	// we need to give from where to read data from the HTTP request and also the content type ("application/json")
	public String updatedoctor(@RequestBody Doctor dr) {
		System.out.println("Doctor : "+dr.getDoc_id()+" "+dr.getDoc_name());
		repo.save(dr);
		return "redirect:/getalldoctors";
	}
	@DeleteMapping("/deletedoctor")
	public String deleteDoctor(int id) {
		 repo.deleteById(id);
		 return "redirect:/getalldoctors";
	}
	@GetMapping("/getalldoctor")
	public List<Doctor>getDoctor(){
		return repo.findAll();
	}
}

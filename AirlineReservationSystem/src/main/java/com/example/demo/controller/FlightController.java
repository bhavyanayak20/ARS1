package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;

@RestController
@RequestMapping("/flight")

public class FlightController {

	@Autowired
	private FlightService flightService;

	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@PostMapping("/add")
	public ResponseEntity<Flight> addFlight(@RequestBody FlightDto flightdto) {
		Flight flightsaved = flightService.addFlight(flightdto);
		return new ResponseEntity<Flight>(flightsaved, HttpStatus.CREATED);

	}

	@GetMapping("/list")
	public ResponseEntity<List<FlightDto>> getFlight() {
		List<FlightDto> flightlist = flightService.getFlight();
		return new ResponseEntity<List<FlightDto>>(flightlist, HttpStatus.OK);
	}

	@GetMapping("/flight/{flightId}")
	public ResponseEntity<Flight> getFlightById(@PathVariable("flightId") Integer id) {
		Flight flightlist = flightService.getFlightById(id);
		return new ResponseEntity<Flight>(flightlist, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{flightId}")
	public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") Integer id) {
		flightService.deleteFlight(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable("id") Integer id, @RequestBody Flight flight) {
		Flight flight_details = flightService.getFlightById(id);
		try {
			flightService.updateFlight(flight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Flight>(HttpStatus.OK);
	}

}
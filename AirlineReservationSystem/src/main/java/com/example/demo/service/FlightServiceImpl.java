package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.EmptyInputException;
import com.example.demo.repository.FlightRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;

	public FlightServiceImpl(FlightRepository flightRepo) {

		this.flightRepo = flightRepo;
	}

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Flight addFlight(FlightDto flightdto) {
		Flight flight = new Flight(flightdto.getFlightNumber(), flightdto.getSeatNumber(), flightdto.getClassType(),
				flightdto.getPrice());
		return flightRepo.save(flight);
	}

	/*
	 * @Override public void deleteFlight(Integer id) { //
	 * flightRepo.deleteById(flightNumber); Optional<Flight> op =
	 * flightRepo.findById(id); if (op.isPresent()) { flightRepo.delete(op.get()); }
	 * }
	 * 
	 * @Override public Flight updateFlight(Flight flight) throws Exception {
	 * Optional<Flight> op = flightRepo.findById(flight.getId()); if
	 * (op.isPresent()) { Flight flight1 = op.get(); flightRepo.save(flight); return
	 * flight; } else { throw new Exception(); } }
	 */

	@Override
	public List<FlightDto> getFlight() {
		List<Flight> flightlist = flightRepo.findAll();
		return flightlist.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public Flight getFlightById(Integer id) {
		return flightRepo.findById(id).get();

	}

	@Override
	public Flight updateFlight(Flight flight) throws Exception {
		return flightRepo.saveAndFlush(flight);
	}

	@Override
	public void deleteFlight(Integer id) {
		flightRepo.deleteById(id);
	}

	/*
	 * @Override public void deleteFlight(String flightNumber) { // TODO
	 * Auto-generated method stub //flightRepo.deleteById(flightNumber);
	 * Optional<Flight> op=flightRepo.findById(flightNumber); if(op.isPresent()){
	 * flightRepo.delete(op.get()); } }
	 */

	public FlightDto convertEntityToDto(Flight flight) {
		FlightDto flightDto = new FlightDto();
		flightDto = modelMapper.map(flight, FlightDto.class);
		return flightDto;
	}

}
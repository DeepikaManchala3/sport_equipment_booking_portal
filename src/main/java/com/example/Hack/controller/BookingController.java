package com.example.Hack.controller;

import com.example.Hack.model.Book;
import com.example.Hack.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class BookingController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/create")
    public String createBooking(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String registerNumber,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime returnTime) {

        Book book = new Book();
        book.setName(name);
        book.setEmail(email);
        book.setRegisterNumber(registerNumber);
        book.setBookingDate(bookingDate);
        book.setStartTime(startTime);
        book.setReturnTime(returnTime);

        bookRepository.save(book);

        return "redirect:/api/bookings/admin";
    }
}

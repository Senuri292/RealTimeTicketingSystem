package com.example.RealTimeTicketingSystem.Controller;

import com.example.RealTimeTicketingSystem.DTO.TicketRequest;
import com.example.RealTimeTicketingSystem.Service.TicketLogger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tickets/start")
@CrossOrigin(origins = "http://localhost:4200",
        allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.OPTIONS},
        allowCredentials = "true")
public class TicketController {
    private final TicketLogger ticketLogger;

    public TicketController(TicketLogger ticketLogger) {
        this.ticketLogger = ticketLogger;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startTicketSystem(@RequestBody TicketRequest ticketRequest) {
        ticketLogger.log(
                ticketRequest.getNumTickets(),
                ticketRequest.getReleaseRate(),
                ticketRequest.getRetrievalRate(),
                ticketRequest.getMaxTicketCapacity()
        );
        return ResponseEntity.ok("Ticket system started");
    }
}
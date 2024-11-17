package com.example.lab5_eventsystem.eventSystemController;


import com.example.lab5_eventsystem.Model.Event;
import com.example.lab5_eventsystem.apiRespnse.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/event-system")
public class EventSystemController {

    ArrayList<Event> events = new ArrayList<Event>();

    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }


    @PostMapping("/new")
    public ApiResponse newEvent(@RequestBody Event event) {
        if (events.contains(event)) {
            return new ApiResponse("Event already exists");
        }
        events.add(event);
        return new ApiResponse("Event created");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index,  @RequestBody Event event) {
        if (index < 0 || index >= events.size()) {
            return new ApiResponse("Invalid index");
        }
        events.set(index, event);
        return new ApiResponse("event updated");
    }

    @DeleteMapping("delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index) {
        if (index < 0 || index >= events.size() ) {
            return new ApiResponse("Invalid index");
        }
        events.remove(index);
        return new ApiResponse("event deleted");

    }

    @GetMapping("/search/{id}")
    public Event getEventById(@PathVariable int id) {
        if (id < 0 || id >= events.size() ) {
          return null;
        }

        for (Event event : events) {
            if (event.getID() == id) {
                return event;
            }
        }

        return null;

    }

    @PutMapping("/change-capacity")
    public ApiResponse changeCapacity(@RequestBody Map<String, Integer> newCapacity) {

       int id = newCapacity.get("id");
       int capacity = newCapacity.get("capacity");

       if ( capacity < 0) {
           return new ApiResponse("Invalid capacity");
       }
       for (Event event : events) {
           if (event.getID() == id ) {
               event.setCapacity(capacity);
           }
       }
        return new ApiResponse("capacity changed");

    }
}

package org.example.lap53.Controller;

import org.example.lap53.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
ArrayList<Event> events = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Event> getAllEvents() {
        return events;

    }

    @PostMapping("add")
    public String addEvent(@RequestBody Event event) {
        events.add(event);
        return "Event added";
    }

    @PutMapping("/update/{index}")
    public String updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return "Event updated";
    }

    // حذف فعالية
    @DeleteMapping("/delet/{index}")
    public String deleteEvent(@PathVariable int index) {
        events.remove(index);
        return "Event deleted";
    }

@PutMapping("/{index}/capacity")
public String changeCapacity(@PathVariable int index, @RequestBody int newCapacity) {
    if (index >= 0 && index < events.size()) {
        Event event = events.get(index);
        event.setCapacity(newCapacity);
        return " change successfully" + newCapacity;
    }return "error";
}
@GetMapping("/search/{id}")
public Event getEventById(@PathVariable int id) {
    if (id >= 0 && id < events.size()) {
        return events.get(id);
        }
    return null;
} }
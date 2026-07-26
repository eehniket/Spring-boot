package com.eehniket.journalApp.controller;

import com.eehniket.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping()
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean JournalEntry(@RequestBody JournalEntry myEntries) {
        journalEntries.put(myEntries.getId(), myEntries);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalById (@PathVariable Long myId) {
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalByID(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalById (@PathVariable Long myId,@RequestBody JournalEntry myEntries) {
        return journalEntries.put(myId, journalEntries.get(myId));
    }
}

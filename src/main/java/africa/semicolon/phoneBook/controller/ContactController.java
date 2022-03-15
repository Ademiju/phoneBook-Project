package africa.semicolon.phoneBook.controller;

import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.FindContactResponse;
import africa.semicolon.phoneBook.services.ContactService;
import africa.semicolon.phoneBook.services.ContactServiceImpl;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/contact")
@RestController
public class ContactController {
    private ContactService contactService = new ContactServiceImpl();

    @PostMapping("/addContact")

    public AddContactResponse addNewContact(@RequestBody AddContactRequest request){

        return contactService.addContact(request);
    }
    @GetMapping("/{phoneNumber}")
    FindContactResponse getContactByPhoneNumber(@PathVariable String phoneNumber){
        return contactService.findByPhoneNumber(phoneNumber);
    }

}

package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.FindContactResponse;
import africa.semicolon.phoneBook.exceptions.ContactDoesNotExistException;
import africa.semicolon.phoneBook.exceptions.AddContactFailureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {

    private ContactService contactService;
    @BeforeEach
    void setUP(){
        contactService = new ContactServiceImpl();

    }
    @Test
    void contactCanBeAddedToRepositoryTest(){
        AddContactRequest newRequest = createContact();
        contactService.addContact(newRequest);
        assertEquals(1, contactService.getRepository().count());
    }

    private AddContactRequest createContact() {
        AddContactRequest newRequest = new AddContactRequest();
        newRequest.setFirstName("Increase");
        newRequest.setMiddleName("Joseph");
        newRequest.setLastName("Lois");
        newRequest.setPhoneNumber("08069");
        newRequest.setOfficeAddress("315 Herbert M.");
        return newRequest;
    }

    @Test
    void duplicatePhoneNumber_throwExceptionTest() {
        AddContactRequest newContact = createContact();
        contactService.addContact(newContact);
        assertThrows(AddContactFailureException.class, () -> contactService.addContact(newContact));
    }
    @Test
    void addingNewContactGivesCorrectResponseTest(){
        AddContactRequest newContact = createContact();
        AddContactResponse response = contactService.addContact(newContact);
        assertEquals("Increase Lois",response.getFullName());
        assertEquals("08069", response.getPhoneNumber());

    }
    @Test
    void findAddedContactByPhoneNumberTest(){
        AddContactRequest newContact = createContact();
        contactService.addContact(newContact);
        FindContactResponse foundResponse = contactService.findByPhoneNumber(newContact.getPhoneNumber());
        assertEquals("Increase Lois",foundResponse.getFullName());
        assertEquals("08069", foundResponse.getPhoneNumber());

    }
    @Test
    void findingNonExistingContact_throwsExceptionTest(){
        AddContactRequest newContact = createContact();
        contactService.addContact(newContact);
        assertThrows(ContactDoesNotExistException.class, () ->contactService.findByPhoneNumber("08043526"));
    }
    @Test
    void deleteContactUsingPhoneNumber(){

    }


}
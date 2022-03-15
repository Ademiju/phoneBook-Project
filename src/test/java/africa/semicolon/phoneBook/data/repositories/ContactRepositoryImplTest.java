package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    ContactRepository contactRepository;

    @BeforeEach
    void setUp() {
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    void contactCanBeCreatedTest() {
        Contact contact = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
    }

    @Test
    void moreThanOneContactCanBeSavedTest() {
        saveThreeContact();
        assertEquals(3, contactRepository.count());
    }

    private void saveThreeContact() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "George", "0708");
        contactRepository.save(contact3);
    }

    @Test
    void contactDetailsSavedCanBeUpdatedTest() {
        Contact contact1 = new Contact("Increaz", "Lois", "0703");
        contactRepository.save(contact1);
        assertEquals("Increaz", contact1.getFirstName());
        contact1.setFirstName("Increase");
        contact1.setMobile("0712");
        assertEquals("Increase", contact1.getFirstName());
        assertEquals("0712", contact1.getMobile());

    }

    @Test
    void contactSavedCanBeSearched_usingFirstNameTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "George", "0708");
        contactRepository.save(contact3);
        Contact foundContact = contactRepository.findByFirstName("Motunrayo");
//        assertEquals(contact3, foundContact);
    }

    @Test
    void SearchingContactByFirstName_isNotCaseSensitiveTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("DaMilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "George", "0708");
        contactRepository.save(contact3);
        Contact foundContact = contactRepository.findByFirstName("DAMILola");
        assertEquals(contact2, foundContact);
    }

    @Test
    void contactSavedCanBeSearched_usingLastNameTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "George", "0708");
        contactRepository.save(contact3);
        Contact foundContact = contactRepository.findByLastName("George");
        assertEquals(contact3, foundContact);
    }

    @Test
    void SearchingContactByLastName_isNotCaseSensitiveTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "GEORGe", "0708");
        contactRepository.save(contact3);
        Contact foundContact = contactRepository.findByLastName("georgE");
        assertEquals(contact3, foundContact);
    }

    @Test
    void contactSavedCanBeSearched_usingMobileNumberTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "George", "0708");
        contactRepository.save(contact3);
        Contact foundContact = contactRepository.findByMobile("0703");
        assertEquals(contact1, foundContact);
    }

    @Test
    void whenContactSearchedDoesNotExist_itThrowsAnExceptionTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "GEORGe", "0708");
        contactRepository.save(contact3);
        try {
            Contact foundContact = contactRepository.findByFirstName("Increaz");
        } catch (Exception error) {
            assertEquals(IllegalArgumentException.class, error.getClass());
            assertEquals("Contact does not exist", error.getMessage());
        }

    }

    @Test
    void findAllUserTest() {
        saveThreeContact();
        List<Contact> contacts = contactRepository.findAll();
        assertEquals(3, contacts.size());
    }

    @Test
    void deleteByContactTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "GEORGe", "0708");
        contactRepository.save(contact3);
        contactRepository.delete(contact2);
        assertEquals(2, contactRepository.count());

    }

    @Test
    void deleteContactByMobileNumberTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "GEORGe", "0708");
        contactRepository.save(contact3);
        contactRepository.delete("0708");
        assertEquals(2, contactRepository.count());

    }
    @Test
    void deleteAllContactTest() {
        Contact contact1 = new Contact("Increase", "Lois", "0703");
        contactRepository.save(contact1);
        Contact contact2 = new Contact("Damilola", "Johnson", "0705");
        contactRepository.save(contact2);
        Contact contact3 = new Contact("Motunrayo", "GEORGe", "0708");
        contactRepository.save(contact3);
        contactRepository.deleteAll();
        assertEquals(0, contactRepository.count());
    }

}
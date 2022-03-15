package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    Contact save (Contact contact);
    Contact findByFirstName(String firstName);
    Contact findByLastName(String lastName);
    Contact findByMobile(String mobile);
    void delete(Contact contact);
    void delete(String mobile);
    void deleteAll();
    List<Contact> findAll();

    int count();


}

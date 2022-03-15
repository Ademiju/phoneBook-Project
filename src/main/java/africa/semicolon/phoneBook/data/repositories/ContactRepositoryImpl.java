package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    private List<Contact> database = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {
        database.add(contact);
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        database.remove(contact);
    }

    @Override
    public void delete(String mobile) {
        Contact contact = findByMobile(mobile);
            database.remove(contact);

    }

    @Override
    public void deleteAll() {
        database.clear();
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for (Contact contact : database)
            if(contact.getFirstName().equalsIgnoreCase(firstName)) return contact;
        throw new IllegalArgumentException("Contact does not exist");
    }

    @Override
    public Contact findByLastName(String lastName) {
        for (Contact contact : database)
            if(contact.getLastName().equalsIgnoreCase(lastName)) return contact;
        throw new IllegalArgumentException("Contact does not exist");
    }

    @Override
    public Contact findByMobile(String mobile) {
        for (Contact contact : database)
            if(contact.getMobile().equals(mobile)) return contact;
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return database;
    }

    @Override
    public int count() {
        return database.size();
    }
}

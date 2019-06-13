package rmit.team5.springtut.DAO;

import rmit.team5.springtut.Model.ContactInfo;

public interface ContactDAO {
    // Create
    void addNewContact (ContactInfo contactInfo);
    // Read
    void retrieveAllContact();
    void getSingleContact ();
    // Update
    void updateContact (ContactInfo contactInfo);
    // Delete
    void deleteContact (int contactID);
}

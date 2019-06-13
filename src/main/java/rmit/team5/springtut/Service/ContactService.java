
package rmit.team5.springtut.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.team5.springtut.DAO.ContactRepo;
import rmit.team5.springtut.Model.ContactForm;
import rmit.team5.springtut.Model.ContactInfo;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private ContactRepo contactRepo;
    // init ContactRep -- where to perform CRUD
    @Autowired
    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    // CREATE METHOD
    public ContactInfo addNewContact (ContactInfo cI) {
        return contactRepo.save(cI);
    }

    // READ METHOD -- list all the contacts
    public List<ContactInfo> findAllContacts () {
        return contactRepo.findAll();
    }

    // READ METHOD -- find by phone number
    public Optional<ContactInfo> findByPhoneNumber (String phoneNum) {
        return contactRepo.findByPhoneNumber(phoneNum);
    }

    public Optional<ContactInfo> findByID (int ID) {
        return contactRepo.findById((long) ID);
    }

    // UPDATE METHOD -- update the contact information
    public boolean updateContactInfo (long ID, ContactInfo newContact) {
        Optional<ContactInfo> contactExisted = contactRepo.findById(ID);
        if (contactExisted.isPresent()) {
            ContactInfo CI = contactExisted.get();
            CI.setAddress(newContact.getAddress());
            CI.setAge(newContact.getAge());
            CI.setName(newContact.getName());
            CI.setPhoneNumber(newContact.getPhoneNumber());
            contactRepo.save(CI);
            return true;
        }else return false;
    }

    // DELETE METHOD -- delete single account
    public boolean deleteContactByID (long ID) {
        Optional<ContactInfo> contactExisted = contactRepo.findById(ID);
        if (contactExisted.isPresent()) {
            contactRepo.deleteById(ID);
            return true;
        }else return false;
    }

    public ContactInfo createContact (ContactForm contactForm) {
        String contactName = contactForm.getName();
        String contactAddress = contactForm.getAddress();
        String contactPhone = contactForm.getPhoneNumber();
        Integer contactAge = contactForm.getAge();
        if (contactForm.getFormID() != null) {
            long contactID = contactForm.getFormID();
            return new ContactInfo(contactID,contactName, contactPhone,contactAddress, contactAge);
        }else return new ContactInfo(contactName, contactPhone,contactAddress, contactAge);
    }

    public ContactForm fillInContactForm (ContactInfo contactInfo) {
        String contactName = contactInfo.getName();
        String contactAddress = contactInfo.getAddress();
        String contactPhone = contactInfo.getPhoneNumber();
        Integer contactAge = contactInfo.getAge();
        long contactID = contactInfo.getContactID();
        System.out.println("fill in contact form: "+ contactID);
        return new ContactForm(contactID, contactName, contactPhone, contactAddress, contactAge);
    }
}

package rmit.team5.springtut.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rmit.team5.springtut.Model.ContactInfo;
import rmit.team5.springtut.Service.ContactService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ContactRESTController {
    // create and init contactService object
    private final ContactService contactService;

    @Autowired
    public ContactRESTController(ContactService contactService) {
        this.contactService = contactService;
    }

    // get all contacts
    @GetMapping("/alls")
    public List<ContactInfo> getAllContacts () {
        System.out.println("FIND ALL CONTACT");
        return contactService.findAllContacts();
    }

    // get single contact by ID
    @GetMapping("/single/{ID}")
    public ResponseEntity<?> getSingleContactByID (@PathVariable int ID) {
        Optional<ContactInfo> contactInfo = contactService.findByID(ID);
        if (contactInfo.isPresent()) {
            return ResponseEntity.ok(contactInfo.get());
        }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact Not Found");
    }

    // get single contact by phone number
    @GetMapping("/single")
    public ResponseEntity<?> getSingleContactByPhone (@RequestParam("phone") String phoneNum) {
        Optional<ContactInfo> contactInfo = contactService.findByPhoneNumber(phoneNum);
        if(contactInfo.isPresent()) {
            return ResponseEntity.ok(contactInfo.get());
        }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact Not Found");
    }

    // create new contact
    @PostMapping(value = "/create", consumes = {"application/json", "application/x-www-form-urlencoded;charset=UTF-8"})
    public ResponseEntity<ContactInfo> createNewContact (@RequestBody ContactInfo contactInfo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactInfo);
    }

    // update existed contact by ID
    @PutMapping("/update/{ID}")
    public ResponseEntity<?> updateContact (@PathVariable int ID,@RequestBody ContactInfo newContact) {
        boolean canBeUpdate = contactService.updateContactInfo(ID, newContact);
        if (canBeUpdate) return ResponseEntity.status(HttpStatus.OK).body("Contact has been updated");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact Not Found");
    }

    // delete contact by ID
    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<?> deleteContact (@PathVariable int ID) {
        boolean canBeDeleted = contactService.deleteContactByID(ID);
        if (canBeDeleted) return ResponseEntity.status(HttpStatus.OK).body("Contact has been deleted");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact Not Found");
    }


}

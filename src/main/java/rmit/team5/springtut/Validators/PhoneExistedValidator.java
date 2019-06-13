package rmit.team5.springtut.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import rmit.team5.springtut.DAO.ContactRepo;
import rmit.team5.springtut.Model.ContactForm;
import rmit.team5.springtut.Model.ContactInfo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class PhoneExistedValidator implements ConstraintValidator<PhoneExistedConstraint, String> {

    public PhoneExistedValidator() {}

    private ContactRepo contactRepo;

    @Autowired
    public PhoneExistedValidator(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }


    @Override
    public void initialize(PhoneExistedConstraint constraintAnnotation) {

    }

//    @Override
//    public boolean isValid(Object o, ConstraintValidatorContext context) {
//        ContactForm formContact = (ContactForm) o;
//        System.out.println("phone number:" +formContact.getPhoneNumber() );
//        Optional<ContactInfo> contactInfo = contactRepo.findByPhoneNumber(formContact.getPhoneNumber());
//        System.out.println("phone number is null: " + contactInfo.isPresent());
//        if(formContact.getFormID() == null) { // create case
//            if(contactInfo.isPresent()) {
//                context.buildConstraintViolationWithTemplate("The phone number is existed").
//                        addPropertyNode("phoneNumber").addConstraintViolation();
//                return false;
//            }else return true;
//        }else {  // update case
//            System.out.println("update case");
//            if(contactInfo.isPresent()) {
//                ContactInfo phoneContact = contactInfo.get();
//                long phoneContactID = phoneContact.getContactID();
//                System.out.println("phone Contact ID: " + phoneContactID);
//                long formContactID = formContact.getFormID();
//                System.out.println("form contact ID: " + formContactID);
//                if (phoneContactID != formContactID) {
//                    context.buildConstraintViolationWithTemplate("The phone number is existed").
//                            addPropertyNode("phoneNumber").addConstraintViolation();
//                    return false;
//                }else return true;
//                //return phoneContactID == formContactID;
//
//            } else return true;
//        }
//    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Optional<ContactInfo> contactInfo = contactRepo.findByPhoneNumber(s);
        return !contactInfo.isPresent();
    }
}

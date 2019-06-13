package rmit.team5.springtut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rmit.team5.springtut.Model.ContactForm;
import rmit.team5.springtut.Model.ContactInfo;
import rmit.team5.springtut.Service.ContactService;
import javax.validation.Valid;
import java.sql.Date;
import java.util.Optional;


@Controller
@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET) // class mapping
public class HomeController {

    private final ContactService contactService;

    @Autowired
    public HomeController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/") // use getMapping function which is similar to RequestMapping with only HTTP Request Get
    public ModelAndView showHomePage() {
        Date date = new Date(System.currentTimeMillis());
        ModelAndView modelAndView = new ModelAndView("HomePage"); // initialize with the JSP file
        // add objects
        modelAndView.addObject("pageMethod", "This is our home page");
        modelAndView.addObject("currentTime", date);
        modelAndView.addObject("testNumber", 3000);
        return modelAndView;
    }

    // use RequestMapping function, this function can use with various of HTTP request
    @RequestMapping(value = "/rm", method = RequestMethod.GET)
    public ModelAndView useRequestMethod() {
        Date date = new Date(System.currentTimeMillis());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("HomePage"); // set JSP by setViewName function
        // add object
        modelAndView.addObject("pageMethod", "This is our home page using Request Mapping");
        modelAndView.addObject("currentTime", date);
        modelAndView.addObject("testNumber", 3000);
        return modelAndView;
    }

    // return contact page with table view
    @GetMapping("/contact")
    public ModelAndView showContactView () {
        return new ModelAndView("ContactRestPage");
    }

    // show adding contactPage
    @PostMapping("/addContact")
    public String addContact (@Valid @ModelAttribute("newContact") ContactForm contactInfo, BindingResult result) {
        if (result.hasErrors()) {
            // return EditContactPage with errors
            return "AddContactPage";
        }else {
            // save the contact
            ContactInfo newContact = contactService.createContact(contactInfo);
            contactService.addNewContact(newContact);
            return "redirect:/contact";
        }

    }

    // return EditContactPage where to add the contact
    @GetMapping("/add")
    public ModelAndView showAddContactPage () {
        ContactForm contactForm = new ContactForm();
        return new ModelAndView("AddContactPage","newContact", contactForm);
    }

    //
    @GetMapping("/edit/{ID}")
    public ModelAndView showEditContactPage (@PathVariable int ID) {
        Optional<ContactInfo> contactInfo = contactService.findByID(ID);
        ModelAndView modelAndView = new ModelAndView("EditContactPage");
        if (contactInfo.isPresent()) {
            ContactForm updateForm = contactService.fillInContactForm(contactInfo.get());
            modelAndView.addObject("updateContact", updateForm);
        }else {
            String isExisted = "Contact Not Found";
            modelAndView.addObject("contactExist", isExisted);
        }
        return modelAndView;
    }

    @PostMapping("/updateContact")
    public String updateContact (@Valid @ModelAttribute("updateContact") ContactForm contactInfo,
                                 BindingResult result){
        if (result.hasErrors()) {
            // return EditContactPage with errors
            return "EditContactPage";
        }else {
            ContactInfo newContact = contactService.createContact(contactInfo);
            contactService.updateContactInfo(newContact.getContactID(), newContact);
            return "redirect:/contact";
        }
    }



}

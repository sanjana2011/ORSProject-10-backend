package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.ContactDTO;
import com.rays.form.ContactForm;
import com.rays.service.ContactServiceInt;

/**
 * ContactCtl is the controller class for managing contact-related operations.
 * This class extends {@link BaseCtl} and inherits common CRUD functionality
 * such as save, update, delete, get, and search operations.
 * 
 * <p>This controller handles HTTP requests for the Contact entity and
 * delegates business logic to the ContactServiceInt service layer.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Contact")
public class ContactCtl extends BaseCtl<ContactForm, ContactDTO, ContactServiceInt> {

    /**
     * Preloads any necessary data required before loading the contact form.
     * This method can be extended to load dropdown lists, default values,
     * or any other data needed for the contact management interface.
     *
     * @return ORSResponse containing success status
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        return res;
    }
}
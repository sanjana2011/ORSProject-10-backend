package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;

/**
 * TestCtl is a controller class used for testing purposes.
 * This class provides endpoints to verify that the application
 * is running correctly and to test the ORSResponse functionality.
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Test")
public class TestCtl {
    
    /**
     * Test endpoint that returns a sample ORSResponse with various data types.
     * This method is used to verify that the controller and response
     * handling are working properly.
     *
     * @return ORSResponse containing sample data, input error, message, and custom result
     */
    @GetMapping("Test")
    public ORSResponse TestAdd() {
        ORSResponse res = new ORSResponse();
            
        res.addData("sanjna");
        res.addInputError("gangrade");
        res.addMessage("sanjana gangrade");
        res.addResult("123", "qwerf");
        return res;
    
    }
    
}
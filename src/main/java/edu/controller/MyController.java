package edu.controller;
import edu.entity.Customer;
import edu.entity.Merchant;
import edu.entity.Payment;
import edu.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.openjson.JSONObject;



import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;


@RestController
@RequestMapping(value = "/api")
public class MyController {

    @Autowired
    CustomerService cService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHelloWorldMessage() {
        //Use template instead of hard-coded HTML
//		return "helloWorld";

        return "<div style=\"text-align:center;\">" + "<h1>Hello world</h1>"
                + "<button>add customer</button>"
                + "<button>add merchant</button>"
                + "<button>add payment</button>"

//				+ "<p> This is my first web-page </p>"
//				+ "<img src=https://cdn-images-1.medium.com/fit/t/1600/672/0*n-2bW82Z6m6U2bij.jpeg></img>"
                + "</div>";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getHelloWorldMessageForUser(@RequestParam String name) {
        return "<div style=\"text-align:center;\">" + "<h1>Welcome, " + name + "</h1>"
                + "<p> This is my first web-page </p>" + "</div>";
    }

    @RequestMapping(value = "/{resource}", method = RequestMethod.GET)
    public String getHelloWorldMessageFromResource(@PathVariable String resource) {
        return "<div style=\"text-align:center;\">" + "<h1>This request was done to the resource: " + resource
                + "</h1>" + "</div>";
    }

    @RequestMapping(value = "/customizedWelcome", method = RequestMethod.POST)
    public String getHelloWorldWithFromJSON(@RequestBody String message) {
        JSONObject json = new JSONObject(message);
        String firstName = "Albert";
        String defaultPictureAddress = "https://cdn-images-1.medium.com/fit/t/1600/672/0*n-2bW82Z6m6U2bij.jpeg";

        String firstNameFromRequest = json.getString("firstName");
        if (StringUtils.isNotBlank(firstNameFromRequest)) {
            firstName = firstNameFromRequest;
        }
        String pictureURLFromRequest = json.getString("pictureURL");
        if (StringUtils.isNotBlank(pictureURLFromRequest)) {
            defaultPictureAddress = pictureURLFromRequest;

        }
        return "<div style=\"text-align:center;\">" + "<h1>Hello world from " + firstName + "</h1>"
                + "<p> This is my first web-page </p>" + "<img src=" + defaultPictureAddress + "></img>"
                + "</div>";

    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomerFromJSON(@RequestBody String message) {

        JSONObject json = new JSONObject(message);
        Customer c = new Customer();

        c.setName(json.getString("name"));
        c.setAddress(json.getString("address"));
        c.seteMail(json.getString("email"));
        c.setCcNo(json.getString("ccNo"));
        c.setCcType(json.getString("ccType"));
        c.setMaturity(java.sql.Date.valueOf(LocalDate.now()));

        cService.save(c);

        return "<div style=\"text-align:center;\">" + "<h1>Customer " + c.getName() + " successfully added</h1>"
                + "</div>";

    }
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getCusomers() {
        //cService.
        //JSONObject json = new JSONObject();
        return "<div style=\"text-align:center;\">" +  cService.findAll().toString() + "</div>";

    }
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public String getCusomer(@PathVariable int id) {
        return "<div style=\"text-align:center;\">" +  cService.findById(id).toString() + "</div>";

    }


    @RequestMapping(value = "/customers/{id}/payments", method = RequestMethod.GET)
    public String getPayments(@PathVariable int id) {
        String str="<div style=\"text-align:center;\">";
        Collection<Payment> col = cService.getPayments(id);
        Iterator iterator = col.iterator();

        while(iterator.hasNext()){
            str += iterator.next().toString();
        }

        return str	+ "</div>";

    }
    @RequestMapping(value = "/customers/{id}/merchants", method = RequestMethod.GET)
    public String getMerchants(@PathVariable int id) {
        String str="<div style=\"text-align:center;\">";
        Collection<Merchant> col = cService.getMerchants(id);
        Iterator iterator = col.iterator();

        while(iterator.hasNext()){
            str += iterator.next().toString();
        }
        return str	+ "</div>";

    }
}

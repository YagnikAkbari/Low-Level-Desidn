package com.library.seeder;

import com.library.entity.Patron;
import com.library.service.PatronService;

public class SeedPatron {
  public static void seed(PatronService patronService) {
    patronService.addPatron(new Patron("Aarav Sharma", "9000000001", "aarav.sharma@example.com"));
    patronService.addPatron(new Patron("Diya Patel", "9000000002", "diya.patel@example.com"));
    patronService.addPatron(new Patron("Kabir Singh", "9000000003", "kabir.singh@example.com"));
    patronService.addPatron(new Patron("Meera Iyer", "9000000004", "meera.iyer@example.com"));
    patronService.addPatron(new Patron("Rohan Gupta", "9000000005", "rohan.gupta@example.com"));
    patronService.addPatron(new Patron("Ananya Nair", "9000000006", "ananya.nair@example.com"));
    patronService.addPatron(new Patron("Vivaan Khan", "9000000007", "vivaan.khan@example.com"));
    patronService.addPatron(new Patron("Isha Verma", "9000000008", "isha.verma@example.com"));
    patronService.addPatron(new Patron("Arjun Malhotra", "9000000009", "arjun.malhotra@example.com"));
    patronService.addPatron(new Patron("Sana Kapoor", "9000000010", "sana.kapoor@example.com"));
    patronService.addPatron(new Patron("Dev Joshi", "9000000011", "dev.joshi@example.com"));
    patronService.addPatron(new Patron("Nina Menon", "9000000012", "nina.menon@example.com"));
    patronService.addPatron(new Patron("Karan Bhatia", "9000000013", "karan.bhatia@example.com"));
    patronService.addPatron(new Patron("Pooja Rao", "9000000014", "pooja.rao@example.com"));
    patronService.addPatron(new Patron("Rahul Sinha", "9000000015", "rahul.sinha@example.com"));
    patronService.addPatron(new Patron("Tara Choudhary", "9000000016", "tara.choudhary@example.com"));
    patronService.addPatron(new Patron("Aditya Roy", "9000000017", "aditya.roy@example.com"));
    patronService.addPatron(new Patron("Neha Das", "9000000018", "neha.das@example.com"));
    patronService.addPatron(new Patron("Siddharth Bose", "9000000019", "siddharth.bose@example.com"));
    patronService.addPatron(new Patron("Riya Mallick", "9000000020", "riya.mallick@example.com"));
  }
}

package com.example.s27236tpo051.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {
    @PostMapping(path = "/convert")
    @ResponseBody
    public String index(@RequestParam String val1, @RequestParam int base_from, @RequestParam int base_to) {
        String result = "";
        String binary_value;
        String octal_value;
        String decimal_value;
        String hexadecimal_value;
        try {
            String val = String.valueOf(Integer.parseInt(val1, base_from));
            result = Integer.toString(Integer.parseInt(val, base_from), base_to);
            binary_value = Integer.toString(Integer.parseInt(val, base_from), 2);
            octal_value = Integer.toString(Integer.parseInt(val, base_from), 8);
            decimal_value = Integer.toString(Integer.parseInt(val, base_from), 10);
            hexadecimal_value = Integer.toString(Integer.parseInt(val, base_from), 16);
        } catch (NumberFormatException e) {
            return "Invalid input " + e;
        }
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<style>\n" +
                "body {\n" +
                "    font-family: Arial, sans-serif;\n" +
                "    background-color: #f7f7f7;\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                "    text-align: left;\n" +
                "}\n" +
                "h2 {\n" +
                "    color: #333;\n" +
                "}\n" +
                "p {\n" +
                "    font-size: 18px;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Conversion Results</h2>\n" +
                "<p>Converted Value: " + result + "</p>\n" +
                "<p>Binary: " + binary_value + "</p>\n" +
                "<p>Octal: " + octal_value + "</p>\n" +
                "<p>Decimal: " + decimal_value + "</p>\n" +
                "<p>Hexadecimal: " + hexadecimal_value + "</p>\n" +
                "</body>\n" +
                "</html>";
    }
}

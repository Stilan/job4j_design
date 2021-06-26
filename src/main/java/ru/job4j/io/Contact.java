package ru.job4j.io;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Litvinov Alexander
 * @version 1.0
 * @since 14.06.2021
 */

@XmlRootElement(name = "contact")
public class Contact {

    @XmlAttribute
    private  String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contact(String phone) {
        this.phone = phone;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}

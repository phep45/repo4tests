package banking.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
@XmlRootElement(name = "bankclients")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankClients {

    @XmlElement(name = "client")
    private List<Client> asList = new ArrayList<>();

    public List<Client> getAsList() {
        return asList;
    }

    public void setAsList(List<Client> asList) {
        this.asList = asList;
    }

}

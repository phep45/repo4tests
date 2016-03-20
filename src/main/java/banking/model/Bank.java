package banking.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Bank {

    private static final Logger log = LoggerFactory.getLogger(Bank.class);

    private String name;

    @Autowired
    private BankClients bankClients;

    public void addClient(Client client) {
        Preconditions.checkNotNull(client, "No client specified");
        getBankClients().getAsList().add(client);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Preconditions.checkNotNull(name);
        Preconditions.checkArgument(name.length() > 0);
        this.name = name;
    }

    public void loadClientsFromFile(String filename, boolean override) {
        Preconditions.checkArgument(filename.endsWith(".xml"), "Only XML is supported");
        BankClients tmpBankClients = new BankClients();
        try {
            tmpBankClients = parseXml(filename);
        } catch (JAXBException e) {
           log.error("Exception while reading from file: " + filename, e);
        }

        if (override) {
            getBankClients().getAsList().addAll(tmpBankClients.getAsList());
            return;
        }
        setBankClients(tmpBankClients);
    }

    private BankClients parseXml(String filename) throws JAXBException {
        BankClients tmpBankClients;
        try {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(BankClients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            tmpBankClients = (BankClients) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            throw new JAXBException(e);
        }
        return tmpBankClients;
    }

    public void saveClientsToFile(String filename) {
        Preconditions.checkArgument(filename.endsWith(".xml"), "Only XML is supported");
        try {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(BankClients.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(bankClients, file);
        } catch (JAXBException e) {
            log.error("Exception while saving to file: " + filename, e);
        }
    }

    @Override
    public String toString() {
        return "Bank: " + name;
    }

    public BankClients getBankClients() {
        return bankClients;
    }

    public ImmutableList<List<Client>> getBankClientsAsList() {
        return ImmutableList.of(bankClients.getAsList());
    }

    public void setBankClients(BankClients bankClients) {
        this.bankClients = bankClients;
    }
}

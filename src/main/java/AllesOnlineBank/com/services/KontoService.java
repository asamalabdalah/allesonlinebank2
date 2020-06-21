package AllesOnlineBank.com.services;
import AllesOnlineBank.com.models.Konto;
import AllesOnlineBank.com.repository.KontoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class KontoService {

    @Autowired
    KontoRepository kontoRepository;

    public Konto addKonto(Konto konto) {

        kontoRepository.save(konto);
        return konto;
    }
    public Konto getKonto(Long kontoId)
    {

        return kontoRepository.findById(kontoId).get();

    }
    //public Iterable<Product> getAll() { return prokductRepository.findAll(); }
    public List<Konto> getAll() {
        return (List<Konto>)kontoRepository.findAll(); }

    public Konto updateKonto(Long kontoId,Konto newKonto){

        Konto oldKonto =kontoRepository.findById(kontoId).get();
        oldKonto.setIban(newKonto.getIban());
        oldKonto.setUser(newKonto.getUser());

        kontoRepository.save(oldKonto);
        return newKonto;
    }

    public void deleteKonto(Long kontoId) {

        kontoRepository.deleteById(kontoId);

    }


}

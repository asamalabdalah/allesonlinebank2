package AllesOnlineBank.com.controller;
import AllesOnlineBank.com.models.Konto;
import AllesOnlineBank.com.services.KontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/allesonlinebank/konto")
public class KontoController {


        @Autowired
        KontoService kontoService;

        @PostMapping()
        public ResponseEntity<Konto>  addKonto(@RequestBody Konto konto) {
            //return (ResponseEntity<Customer>)customer;
            kontoService.addKonto(konto);
            return new ResponseEntity<>(konto, HttpStatus.OK);
        }

        @GetMapping(path = "/{kontoId}")
        public ResponseEntity<Konto>  getKonto(@PathVariable("kontoId") Long kontoId) {
            //return (ResponseEntity<Customer>)super.get(customerId);
            Konto konto=kontoService.getKonto(kontoId);
            return new ResponseEntity<>(konto, HttpStatus.OK);
        }

        @GetMapping(path="/getAll")
        public ResponseEntity<List<Konto>>  getAllKontos()

        {
            //return (ResponseEntity<List<Customer>>)super.getAll();

            List<Konto> kontos=(List<Konto>) kontoService.getAll();
            return new ResponseEntity<>(kontos, HttpStatus.OK);

        }

        @PutMapping(path = "/{kontoId}")
        public ResponseEntity<Konto>  updateKonto(@PathVariable("kontoId") Long kontoId, @RequestBody Konto konto){
            // return (ResponseEntity<Customer>) super.update(customer,customerId);
            kontoService.updateKonto(kontoId,konto);
            return new ResponseEntity<>(konto, HttpStatus.OK);
        }

        @DeleteMapping(path = "/{productId}")
        public ResponseEntity<Konto>  deleteKonto (@PathVariable("kontoId") Long kontoId) {
            //return (ResponseEntity<Customer>)super.delete(customerId);
            Konto konto=kontoService.getKonto(kontoId);
            kontoService.deleteKonto(kontoId);
            return new ResponseEntity<>(konto, HttpStatus.OK);
        }


}

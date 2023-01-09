package br.com.erudio;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    @GetMapping
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
       if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
          throw new UnsupportedMathOperationException("Valor não suportado");
       }
       return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String number) {
        if(number == null) return 0D;
        String num = number.replaceAll(",", ".");
        if(isNumeric(num)) return Double.parseDouble(num);
        return 0D;
    }

    private boolean isNumeric(String number) {
        if(number == null) return false;
        String num = number.replaceAll("," ,".");
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}

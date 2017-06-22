package ba.isss.restservices;

import ba.isss.exception.ReportGenerationException;
import ba.isss.model.SV20Model;
import ba.isss.model.SV50Model;
import ba.isss.model.SemesterFormModel;
import ba.isss.model.SignUpFormModel;
import ba.isss.util.GenerateEntryPapers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/entrypapers")
public class EntryPapersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntryPapersService.class);

    @Autowired
    private GenerateEntryPapers generateEntryPapers;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        LOGGER.debug("Received an rest request...");
        return "Hello certificates";
    }
    //TODO jquery/ajax ne moze skidati binary objekte, pa se mora ici standardnim x-www-formurlencoded zahtjevom
    @RequestMapping(value = "/signupform", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public  ResponseEntity<byte[]> getSignUpForm(@RequestBody @ModelAttribute SignUpFormModel signUpFormModel) {
        LOGGER.debug("Received an rest request...");
        try {
            byte[] certificate = generateEntryPapers.generateSignUpForm(signUpFormModel);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "upisni_list.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            return new ResponseEntity(certificate, headers, HttpStatus.OK);
        } catch (ReportGenerationException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/semesterform", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<byte[]> getSemesterForm(@RequestBody SemesterFormModel semesterFormModel) {
        LOGGER.debug("Received an rest request...");
        try {
            byte[] certificate = generateEntryPapers.generateSemesterForm(semesterFormModel);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "list_za_prijavu_semestra.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            return new ResponseEntity(certificate, headers, HttpStatus.OK);
        } catch (ReportGenerationException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/sv20", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<byte[]> getSV20(@RequestBody SV20Model sv20Model) {
        LOGGER.debug("Received an rest request...");
        try {
            byte[] certificate = generateEntryPapers.generateSV20(sv20Model);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "obrazac_sv_20.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            return new ResponseEntity(certificate, headers, HttpStatus.OK);
        } catch (ReportGenerationException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/sv50", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<byte[]> getSV50(@RequestBody SV50Model sv50Model) {
        LOGGER.debug("Received an rest request...");
        try {
            byte[] certificate = generateEntryPapers.generateSV50(sv50Model);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "obrazac_sv_50.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            return new ResponseEntity(certificate, headers, HttpStatus.OK);
        } catch (ReportGenerationException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
